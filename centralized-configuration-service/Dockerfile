FROM openjdk:8-jdk-alpine
ADD target/centralized-configuration-service-0.0.1-SNAPSHOT.jar config.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config.jar"]