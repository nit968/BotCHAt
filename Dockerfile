# Stage 1: Build the application using Maven
FROM maven:3.8.5-openjdk-17 AS build

# Copy all the files into the container
COPY . .

# Build the application and skip tests
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image with OpenJDK
FROM openjdk:17.0.1-jdk-slim

# Copy the JAR file from the build stage
# The correct path should be /root/target/demo-0.0.1-SNAPSHOT.jar
COPY --from=build /root/target/demo-0.0.1-SNAPSHOT.jar demo.jar

# Expose the port your application will run on
EXPOSE 8080

# Set the entrypoint to run the JAR file
ENTRYPOINT ["java", "-jar", "demo.jar"]
