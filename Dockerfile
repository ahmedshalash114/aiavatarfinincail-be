# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml files first (to leverage Docker caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (Docker layer cache for faster rebuilds)
RUN ./mvnw dependency:go-offline

# Copy the rest of the application code
COPY src src

# Package the application
RUN ./mvnw clean package -DskipTests

# Expose the port your app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/financial-twin-0.0.1-SNAPSHOT.jar"]
