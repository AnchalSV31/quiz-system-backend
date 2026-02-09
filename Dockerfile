# Use Java 21
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the application
RUN mvn clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the JAR
CMD ["java", "-jar", "target/quiz-system-0.0.1-SNAPSHOT.jar"]
