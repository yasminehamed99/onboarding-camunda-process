FROM openjdk:11-jdk
 
VOLUME /tmp
COPY target/*.jar app.jar
COPY target/classes/* /opt/
EXPOSE 8080
ENV spring.profiles.active "cloud"
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
