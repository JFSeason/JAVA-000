package com.example.demo.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author
 * @date 2021/1/5 23:25
 */
@Component
public class Handler {

    @Autowired
    RedisTool redisTool;

    public void execute(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("stock", "10");
//        RedisTool redisTool = new RedisTool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 15; i++) {
            String lockKey = "lockKey";
            String clientId = String.valueOf(UUID.randomUUID());
            try {
                if (redisTool.tryGetDistributedLock(jedis, lockKey, clientId, 3)) {
                    Long stock = jedis.decr("stock");
                    if (stock < 0) {
                        System.out.println("扣减库存失败！！！" + stock);
                    } else {
                        System.out.println("扣减库存成功，" + stock);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redisTool.releaseDistributedLock(jedis, lockKey, clientId);
            }
        }
        executorService.shutdown();
    }
}
