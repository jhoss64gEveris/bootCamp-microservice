FROM openjdk:8-jdk-alpine
ADD target/ZuulService-0.0.1-SNAPSHOT.jar zuul.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zuul.jar"]