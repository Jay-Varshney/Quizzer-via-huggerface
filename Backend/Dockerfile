# Step 1: Build stage (using Maven)
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run stage (using a tiny Java Runtime)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 7860
ENTRYPOINT ["java", "-Xmx512m", "-Xms256m", "-jar", "app.jar", "--server.port=7860"]