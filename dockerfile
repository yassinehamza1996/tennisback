# Use OpenJDK 17 (since your app uses Java 17)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file from target
COPY target/*.jar app.jar

# Expose port (your Spring Boot port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
