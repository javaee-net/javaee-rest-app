# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the pre-built JAR file into the container
COPY target/javaee-rest-app-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on (default is 8080 for Spring Boot)
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
