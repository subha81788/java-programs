import java.util.logging.Logger;

class SharedData {
    private volatile int counter = 0;
     
    public int getCounter() { return counter; }
     
    public void increaseCounter() { ++counter; }
}

class VolatileThread extends Thread {
    private final SharedData data;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
     
    public VolatileThread(SharedData data) {
        this.data = data;
    }
     
    @Override
    public void run() {
        int oldValue = data.getCounter();
        logger.info("[Thread " + Thread.currentThread().getId() + "]: Old value = " + oldValue);
         
        data.increaseCounter();
         
        int newValue = data.getCounter();
        logger.info("[Thread " + Thread.currentThread().getId() + "]: New value = " + newValue);
    }
}

public class VolatileDemo {
     
    private final static int TOTAL_THREADS = 3;
     
    public static void main(String[] args) throws InterruptedException {
        SharedData sharedData = new SharedData();
         
        Thread[] threads = new Thread[TOTAL_THREADS];
        for(int i = 0; i < TOTAL_THREADS; ++i)
            threads[i] = new VolatileThread(sharedData);
         
        //Start all worker threads
        for(int i = 0; i < TOTAL_THREADS; ++i)
            threads[i].start();
         
        //Wait for all threads to terminate.
        for(int i = 0; i < TOTAL_THREADS; ++i)
            threads[i].join();
    }
}
