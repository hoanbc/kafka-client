FROM maven:3.9.9-eclipse-temurin-17-focal AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
VOLUME /tmp
WORKDIR /app
COPY --from=build /app/target/kafka-springboot-app-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 7070
ENTRYPOINT ["java","-jar","/app/app.jar", "--server.port=7070"]
