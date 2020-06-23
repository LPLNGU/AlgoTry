package com.lpl.producer_and_consumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *         synchronized (对象){
 *             while (条件不满足){
 *                 对象.wait();
 *             }
 *             逻辑处理;
 *         }
 *         synchronized (对象){
 *             改变条件;
 *             对象.notifyAll();
 *         }
 */
public class ProducerConsumerTest {

    public static void main(String args[]) {
        final Queue<Integer> sharedQueue = new LinkedList<>();
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();

    }
}
