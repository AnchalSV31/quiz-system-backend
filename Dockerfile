# Use Java 21 base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy project files
COPY . .

# Build the application (NO mvnw)
RUN mvn clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the Spring Boot JAR
CMD ["java", "-jar", "target/quiz-system-0.0.1-SNAPSHOT.jar"]
