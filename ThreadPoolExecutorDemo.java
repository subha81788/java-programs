import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        Runnable task1=()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Task1 waited for 1 sec");
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        };
        Runnable task2=()-> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Task2 waited for 2 sec");
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        };

        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        executor.execute(task1);
        executor.execute(task2);
        executor.shutdown();

    }
}



