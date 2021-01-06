package com.intest.udsservice.util;

import java.util.concurrent.*;

/**
 * @author
 * @date 2020/12/16 10:10
 */
public class ThreadPool {
    public static ExecutorService executorService(){
        int cores = Runtime.getRuntime().availableProcessors() * 2;
        long keepAliveTime = 1000;
        int queueSize = 2048;
        ExecutorService proxyService = new ThreadPoolExecutor(cores, cores,
                keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize));
        return proxyService;
    }
}
