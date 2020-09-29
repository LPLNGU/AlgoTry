package multithread.wait_notify;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Executor executorPool = new ThreadPoolExecutor(2,10,20,TimeUnit.SECONDS,new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        executorPool.execute(new Wait());
        executorPool.execute(new Notify());
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException interruptedException) {
                    }
                }

                System.out.println(Thread.currentThread() + " flag is false. running @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));

                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException interruptedException) {
                    System.out.println("Notify is interrupted");
                }
            }

            synchronized (lock){
                System.out.println(Thread.currentThread()+"hold lock again. sleep @ "+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException interruptedException) {
                }
            }
        }
    }
}
