FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR usr/src/app
COPY . ./
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
RUN apt-get update && apt-get install --yes python3.6 && apt-get install --yes g++
EXPOSE 8080
COPY ./src/main/resources/images/languages ./images/languages/
COPY --from=build /usr/src/app/target/algo-space-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "./app.jar"]
