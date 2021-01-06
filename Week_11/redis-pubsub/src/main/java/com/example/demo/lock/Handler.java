package com.example.demo.lock;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author
 * @date 2021/1/5 23:25
 */
@Component
public class Handler {

    public void Execute() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1000);
        config.setMaxIdle(300);
        config.setMaxWaitMillis(1000);
        JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            Jedis jedis = jedisPool.getResource();
            Sub sub = new Sub();
            try {
                jedis.subscribe(sub, "test");
            } finally {
                System.out.println("线程关闭");
                jedis.close();
            }
        });
        executorService.execute(() -> {
            Jedis jedis = jedisPool.getResource();
            try {
                for (int i = 0; i < 10; i++) {
                    jedis.publish("test", String.valueOf(i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                System.out.println("连接关闭");
                jedis.close();
            }
        });
        executorService.shutdown();
        //通知订阅关闭
        jedisPool.getResource().publish("test", "close");
        //关闭线程
        jedisPool.close();
    }
}
