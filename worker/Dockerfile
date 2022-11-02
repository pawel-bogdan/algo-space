FROM alpine:3.16
RUN apk add --update openjdk11 g++ python3 bash curl \
    && curl "https://downloads.apache.org/kafka/3.0.2/kafka-3.0.2-src.tgz" -o /kafka.tgz \
    && mkdir /kafka && cd /kafka \
    && tar -xvzf /kafka.tgz --strip 1 \
    && ./gradlew jar -PscalaVersion=2.13.6 \
    && cd ..


ADD SolutionExecutor.java /
RUN chmod a+x /SolutionExecutor.java
ADD start.sh /
RUN chmod a+x /start.sh
CMD exec /start.sh
