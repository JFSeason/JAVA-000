package java0.conc0303;

import java.util.concurrent.*;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03 {
    
    public static void main(String[] args) throws InterruptedException {
        
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        /**
         * 第一种方法
         */
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            int result = sum();
            System.out.println("1.异步计算结果为："+result);
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("1.使用时间："+ (System.currentTimeMillis()-start) + " ms");

        /**
         * 第二种方法
         */
        start=System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1,()->{
            System.out.println("2.各个子线程结束");
        });
        new Thread(()->{
            try {
                int result = sum();
                System.out.println("2.异步计算结果为："+result);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("2.使用时间："+ (System.currentTimeMillis()-start) + " ms");

        /**
         * 第三种方法
         */
        start=System.currentTimeMillis();
        Semaphore semaphore = new Semaphore(1);
        new Thread(()->{
            try {
                semaphore.acquire();
                int result = sum();
                System.out.println("3.异步计算结果为："+result);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("3.使用时间："+ (System.currentTimeMillis()-start) + " ms");

        /**
         * 第四种方法
         */
        start=System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(()->sum());
        executorService.shutdown();
        try {
            System.out.println("4.异步计算结果为："+future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("4.使用时间："+ (System.currentTimeMillis()-start) + " ms");


        /**
         * 第五种方法
         */
        start=System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            int result = sum();
            System.out.println("5.异步计算结果为："+result);
            return result;
        });
        new Thread(futureTask).start();
        System.out.println("5.使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
