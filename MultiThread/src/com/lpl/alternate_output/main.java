package com.lpl.alternate_output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * 两个线程交替输出数组
 */
public class main {
    static List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    static Object lock = new Object();
    static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        /**
         * 1、corePoolSize线程池的核心线程数
         * 2、maximumPoolSize能容纳的最大线程数
         * 3、keepAliveTime空闲线程存活时间
         * 4、unit 存活的时间单位
         * 5、workQueue 存放提交但未执行任务的队列
         * 6、threadFactory 创建线程的工厂类
         * 7、handler 等待队列满后的拒绝策略
         */
        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                200L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executorService.execute(new print1());
        Thread.sleep(1);
        executorService.execute(new print2());
        executorService.shutdown();
    }

    static class print1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (; i < list.size(); ) {
                    try {
                        lock.notifyAll();
                        System.out.println(list.get(i) + " print1");
                        i++;
                        lock.wait();
                    } catch (InterruptedException interruptedException) {
                    }
                }
                lock.notifyAll();
            }
        }
    }

    static class print2 implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (; i < list.size(); ) {
                    try {
                        lock.notifyAll();
                        System.out.println(list.get(i) + " print2");
                        i++;
                        lock.wait();
                    } catch (InterruptedException interruptedException) {
                    }
                }
                lock.notifyAll();
            }
        }
    }

}
