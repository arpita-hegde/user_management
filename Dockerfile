FROM java:8

COPY /build/libs/user_management-0.0.1-SNAPSHOT.jar user_management-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","user_management-0.0.1-SNAPSHOT.jar"]