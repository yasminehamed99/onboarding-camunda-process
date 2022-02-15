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
        lookup.setCode(field.getName());
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
