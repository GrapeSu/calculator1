FROM openjdk:17
LABEL authors="wangsj"

COPY /build/libs/calculator1-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]