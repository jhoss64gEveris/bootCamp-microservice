FROM openjdk:8-jdk-alpine
ADD target/cloudGateway-0.0.1-SNAPSHOT.jar cloudGateway.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cloudGateway.jar"]