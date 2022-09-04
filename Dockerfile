FROM maven:3.8.6-jdk-11 AS build
WORKDIR usr/src/app
COPY . ./
RUN mvn clean package -DskipTests

FROM adoptopenjdk/openjdk11
EXPOSE 8080
COPY --from=build /usr/src/app/target/algo-space-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "./app.jar"]