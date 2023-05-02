FROM openjdk:11-jdk
LABEL maintainer="pgrrr119@gmail.com"
LABEL authors="pgrrr"
LABEL purpose="practice"
ARG JAR_FILE=build/libs/onedelivery-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} docker-springboot.jar
EXPOSE 8081

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/docker-springboot.jar"]