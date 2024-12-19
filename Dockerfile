
FROM maven:3.9-eclipse-temurin-21 as build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offlinets

COPY src /app/src

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre-alpine
COPY --from=build /app/target/your-app.jar /app/your-app.jar
ENTRYPOINT ["java", "-jar", "/app/your-app.jar"]