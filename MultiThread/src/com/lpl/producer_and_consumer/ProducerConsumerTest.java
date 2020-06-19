package com.lpl.producer_and_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {

    public static void main(String args[]) {
        final Queue<Integer> sharedQueue = new LinkedList<>();
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
        ThreadLocal threadLocal;
        Thread thread;
    }
}
