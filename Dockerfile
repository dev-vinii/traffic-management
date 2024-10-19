FROM eclipse-temurin:21-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests
FROM eclipse-temurin:21-alpine
WORKDIR /app
COPY --from=build /app/target/traffic-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
