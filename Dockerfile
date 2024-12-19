
FROM maven:3.9-eclipse-temurin-21 as build
WORKDIR /app

COPY pom.xml .
RUN mvn clean install -DskipTests

COPY src /app/src

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/Free_API_Only-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]