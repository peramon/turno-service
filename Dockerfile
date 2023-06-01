FROM maven:3.8.4-openjdk-17-slim AS build
RUN mkdir /app
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests


FROM openjdk:17-slim-buster
RUN mkdir /app
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]
