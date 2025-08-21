# Use lightweight OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the JAR file into container
COPY target/*.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
