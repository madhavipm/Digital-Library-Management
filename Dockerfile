# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY DigitalLibrary.jar /app/DigitalLibrary.jar

# Expose the port (if your app runs on a specific port)
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "/app/DigitalLibrary.jar"]

