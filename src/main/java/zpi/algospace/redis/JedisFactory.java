package zpi.algospace.redis;

import redis.clients.jedis.Jedis;

public class JedisFactory {
    public static synchronized Jedis getJedisInstance(String redisHost, int redisPort) {
        return new Jedis(redisHost, redisPort);
    }
}
