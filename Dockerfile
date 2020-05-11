FROM java:8-jdk-alpine
COPY ./build/libs/user_management-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user_management-0.0.1-SNAPSHOT.jar"]