# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the source code into the container
COPY src/ /app/src/

# Compile the Java source code
RUN javac src/Main.java -d out

# Set the classpath and specify the main class to run
CMD ["java", "-cp", "out", "Main"]
