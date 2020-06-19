package method;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用循环CAS实现原子操作
 */
public class CASTest {
    private static AtomicInteger atomicI = new AtomicInteger(0);
    private static int i = 0;

    public static void main(String[] args) {
        final CASTest cas = new CASTest();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }
        //等待执行完成
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        System.out.println(i);
        System.out.println(atomicI);
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
