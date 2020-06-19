package com.lpl.output;

import java.util.concurrent.*;

public class main {
    public static void main(String[] args) {
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

        executorService.execute();

    }
}
