package multithread.interrupt;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException interruptedException) {

        }
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupt is" + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupt is " + busyThread.isInterrupted());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException interruptedException) {

        }
    }


    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException interruptedException) {

                }
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
