# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/target/chatBot-0.0.1-SNAPSHOT.jar chatBot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "chatBot.jar"]
