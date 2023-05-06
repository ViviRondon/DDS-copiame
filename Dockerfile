# syntax = docker/dockerfile:1.2
#
# Build stage
#
FROM maven:3.8.6-openjdk-18 AS build
COPY . .
RUN mvn clean package assembly:single -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/copiame-cli-0.0.1-SNAPSHOT-jar-with-dependencies.jar copiame.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-classpath","copiame.jar","ar.utn.dds.copiame.CopiameAPI"]
