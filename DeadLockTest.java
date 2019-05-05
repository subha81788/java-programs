import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockTest {
    public static void main(String[] args) {
        String x = "Hello ";
        String y = "World";

        Runnable task1=()-> {
            synchronized(x) {
                System.out.println("Thread1 acquired 1st resource");
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println("Thread1 waits for 2nd resource");
                synchronized(y) {
                    System.out.println("Thread1 prints " + x + y);
                }
            }
        };

        Runnable task2 = ()-> {
            synchronized(y) {
                System.out.println("Thread2 acquired 2nd resource");
                System.out.println("Thread2 waits for 1st resource");
                synchronized(x) {
                    System.out.println("Thread2 prints " + y + x);
                }
            }
        };

        /*
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        */
        System.out.println("Starting threads");
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.submit(task1);
        executors.submit(task2);
        executors.shutdown();
        try{
            executors.awaitTermination(1,TimeUnit.MINUTES);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}
