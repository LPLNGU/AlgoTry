package multithread.threadlocal;

public class Profiler {

    public static final ThreadLocal<Long> TIME_THREADLOCAL  = new ThreadLocal<Long>(){
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        Thread.sleep(100);
        System.out.println("Cost: "+ Profiler.end() + "mills");
    }
}
