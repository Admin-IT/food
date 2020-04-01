package edu.nf.food.food.util;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

/**
 * @author ljf
 * @date 2020/3/30
 */
public class testConnection {
   private static final String HOST="182.92.113.189";
   private static final int PORT= 6379;


    public static void main(String[] args) {
        Jedis jedis = new Jedis(HOST,PORT);
        System.out.println(jedis);
        System.out.println("连接成功");
        String ping = jedis.ping();
        System.out.println(ping);
    }

}