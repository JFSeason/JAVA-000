package com.example.demo.lock;

import redis.clients.jedis.JedisPubSub;

/**
 * @author
 * @date 2021/1/6 22:46
 */
public class Sub extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(String.format("收到消息成功！ channel: %s, message %s", channel, message));
        if (message.equals("close")) {
            this.unsubscribe("可填,不填就全部主题关闭订阅了");
        }
    }

    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("订阅成功！ channel: %s, subscribedChannels %d",channel,subscribedChannels));
    }

    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("取消订阅！ channel: %s, subscribedChannels %d",channel,subscribedChannels));
    }
}
