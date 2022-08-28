FROM adoptopenjdk/openjdk11
EXPOSE 8080
ARG JAR_FILE=target/algo-space-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]