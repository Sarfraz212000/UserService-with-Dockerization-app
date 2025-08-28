FROM openjdk:17-jdk-slim  # smaller base image, less size

COPY target/user-service.jar  /usr/app

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","user-service.jar"]