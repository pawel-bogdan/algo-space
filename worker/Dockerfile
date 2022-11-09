FROM alpine:3.16
RUN apk add --update openjdk11 g++ python3 bash curl make pkgconfig \
    && curl "https://download.redis.io/releases/redis-7.0.0.tar.gz" -o /redis.tgz \
    && mkdir /redis && cd /redis \
    && tar -xvzf /redis.tgz --strip 1 \
    && make install

ADD SolutionExecutor.java /
RUN chmod a+x /SolutionExecutor.java
ADD start.sh /
RUN chmod a+x /start.sh \
    && sed -i -e 's/\r$//' start.sh
CMD exec /start.sh
