# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy all project files into the container
COPY src/ /app/

# Compile the Java files
RUN javac -d . /app/*.java

# Set the command to run your Java application
CMD ["java", "Main"]
