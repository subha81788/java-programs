import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyTest {
    public static void main(String[] args) {
        //Object lock = new Object();
        String lock = "lock";
        Runnable task1 = () -> {
            for(int i =0; i < 20; i+=2) {
                synchronized(lock) {
                    try {
                        lock.wait();
                        System.out.println(i);   
                        lock.notify();
                    }catch(InterruptedException e) {
                        System.err.println(e);   
                    }
                }
            }
        };
        Runnable task2 = () -> {
            /*
            try {
                Thread.sleep(100);
            }catch(InterruptedException e) {
                System.err.println(e);   
            }
            */
            for(int i=1; i<21; i+=2) {
                synchronized(lock) {
                    try {
                        lock.wait();
                        System.out.println(i);   
                        lock.notify();
                    }catch(InterruptedException e) {
                        System.err.println(e);   
                    }
                }
            }
        };
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.submit(task1);
        //executors.submit(task2);
        /*Thread th1 = new Thread(task1);
        Thread th2 = new Thread(task2);
        th1.start();
        th2.start();*/
        executors.shutdown();
    }   
}


