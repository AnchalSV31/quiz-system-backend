# 1️⃣ Use Java 21 base image
FROM eclipse-temurin:21-jdk

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy everything to container
COPY . .

# 4️⃣ Build the project (creates JAR)
RUN ./mvnw clean package -DskipTests

# 5️⃣ Expose application port
EXPOSE 8080

# 6️⃣ Run the Spring Boot JAR
CMD ["java", "-jar", "target/quiz-system-0.0.1-SNAPSHOT.jar"]