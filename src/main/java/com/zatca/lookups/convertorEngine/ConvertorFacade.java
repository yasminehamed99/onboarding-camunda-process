package com.zatca.lookups.convertorEngine;

import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupMetaData;
import com.zatca.lookups.entity.LookupStatus;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class ConvertorFacade {

    private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();
    public final static Map<Class<?>, Class<?>> primitvesMap = new HashMap<Class<?>, Class<?>>();
    static {
        primitvesMap.put(boolean.class, Boolean.class);
        primitvesMap.put(byte.class, Byte.class);
        primitvesMap.put(short.class, Short.class);
        primitvesMap.put(char.class, Character.class);
        primitvesMap.put(int.class, Integer.class);
        primitvesMap.put(long.class, Long.class);
        primitvesMap.put(float.class, Float.class);
        primitvesMap.put(double.class, Double.class);
    }

    public <T extends Object> T convertFromLookup(Lookup lookup, Class<T> type) {
        if(lookup.getType().equals(type))
            throw new ConvertingException("Lookup have different type from the provided type");

        T object = type.cast(newObjectFromType(lookup.getType()));
        fillFields(object, lookup);

        lookup.getChilds().stream().forEach(c -> {
            try {
                Object cObject = convertFromLookup(c, Class.forName(c.getType()));
                Field f = object.getClass().getDeclaredField(c.getFieldName());
                f.setAccessible(true);
                f.set(object, cObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return object;
    }

    public Lookup convertToLookup(Object object) {
        Lookup root = createRoot(object);

        Class clazz = object.getClass();

        Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {

            field.setAccessible(true);

            Object fieldObj = fetchObjectFromField(object, field, root);

            if(isPrimitiveType(field.getType())) {
                root.getLookupMetaData().add(createMeta(field, fieldObj, root));
            } else {
                root.getChilds().add(convertToLookup(root, field, fieldObj));
            }
        });

        return root;
    }

    private Lookup convertToLookup(Lookup parent, Field field, Object object) {
        Lookup lookup = new Lookup();
        lookup.setLookupStatus(LookupStatus.ENABLED);
        lookup.setParentLookup(parent);
        lookup.setFieldName(field.getName());
        lookup.setCode(parent.getCode() + "-" + field.getName());
        lookup.setType(field.getType().getCanonicalName());
        lookup.setGroup(parent.getCode() + "-Group");
        lookup.setLookupMetaData(new ArrayList<>());
        lookup.setChilds(new ArrayList<>());

        Arrays.stream(field.getType().getDeclaredFields()).forEach(f -> {

            f.setAccessible(true);
            Object fieldObject = fetchObjectFromField(object, f, lookup);

            if(isPrimitiveType(f.getType())) {
                lookup.getLookupMetaData().add(createMeta(f, fieldObject, lookup));
            } else {
                lookup.getChilds().add(convertToLookup(lookup, f, fieldObject));
            }
        });

        return lookup;
    }

    private Object newObjectFromType(String type) {
        try {
            Class<?> rootType = Class.forName(type);
            return rootType.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new ConvertingException(
                    String.format("Can't create new object from %s please make sure you have a no arguments constructor",
                            type));
        }
    }

    private Object fetchObjectFromField(Object object, Field field, Lookup lookup) {

        Object obj = null;

        try {
            obj = field.get(object);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new ConvertingException(
                    String.format("Can't convert field = %s to Object where lookup = %s",
                            field.getName(), lookup));
        }

        return obj;
    }

    private void fillFields(Object object, Lookup root) {
        root.getLookupMetaData().stream().forEach(m -> {
            try {
                Field f = object.getClass().getDeclaredField(m.getName());
                f.setAccessible(true);
                f = fillField(object, m.getValue(), m.getType(), f);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ConvertingException(String.format("Exception while filling the field with name = %s in the object of class = %s and value = %s",
                        m.getName(), object.getClass().getCanonicalName(), m.getValue()));
            }
        });
    }

    private Field fillField(Object object, String value, String type, Field field) throws Exception {
        if(value == null) {
            return field;
        } else if(type.equals(Double.class.getCanonicalName())) {
            field.setDouble(object, Double.valueOf(value));
        } else if(type.equals(Long.class.getCanonicalName())) {
            field.setLong(object, Long.valueOf(value));
        } else if(type.equalsIgnoreCase(Integer.class.getCanonicalName())) {
            field.setInt(object, Integer.valueOf(value));
        } else if(type.equals(Float.class.getCanonicalName())) {
            field.setFloat(object, Float.valueOf(value));
        } else if(type.equals(Boolean.class.getCanonicalName())) {
            field.setBoolean(object, Boolean.valueOf(value));
        } else if(type.equals(String.class.getCanonicalName())) {
            field.set(object, value);
        } else if(type.equals(BigDecimal.class.getCanonicalName())) {
            field.set(object, BigDecimal.valueOf(Double.valueOf(value)));
        } else if(type.equals(LocalDate.class.getCanonicalName())) {
            field.set(object, LocalDate.parse(value));
        } else if(type.equals(LocalDateTime.class.getCanonicalName())) {
            field.set(object, LocalDateTime.parse(value));
        } else if(type.equals(Character.class.getCanonicalName())) {
            field.setChar(object, value.toCharArray()[0]);
        } else if(Class.forName(type).isEnum()) {
            Class<Enum> enumClazz = (Class<Enum>) Class.forName(type);
            Enum ev = Enum.valueOf(enumClazz, value);
            field.set(object, ev);
        }

        return field;
    }

    private Lookup createRoot(Object object) {
        Lookup root = new Lookup();
        root.setGroup("Root");
        root.setCode("Root");
        root.setLookupStatus(LookupStatus.ENABLED);
        root.setType(object.getClass().getCanonicalName());
        root.setLookupMetaData(new ArrayList<>());
        root.setChilds(new ArrayList<>());
        return root;
    }

    private boolean isPrimitiveType(Class<?> clazz) {
        return clazz.isPrimitive() || WRAPPER_TYPES.contains(clazz) || clazz.isEnum();
    }

    private LookupMetaData createMeta(Field f, Object valueObj, Lookup lookup) {
        LookupMetaData meta = new LookupMetaData();
        meta.setValue(valueObj == null ? null : String.valueOf(valueObj));
        meta.setName(f.getName());
        meta.setLookup(lookup);
        if(primitvesMap.containsKey(f.getType()))
            meta.setType(primitvesMap.get(f.getType()).getCanonicalName());
        else
            meta.setType(f.getType().getCanonicalName());

        return meta;
    }

    private static Set<Class<?>> getWrapperTypes() {

        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        ret.add(BigDecimal.class);
        ret.add(LocalDateTime.class);
        ret.add(LocalDate.class);
        ret.add(String.class);

        return ret;
    }
}
