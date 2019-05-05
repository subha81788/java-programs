import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            int a = 10;
            int b = 5;
            return a+b;
        };

        Future<Integer> fut = executors.submit(task);
        try {
            int sum = fut.get();
            System.out.println(sum);   
        } catch(InterruptedException | ExecutionException e) {
            System.err.println(e);   
        } 
        executors.shutdown();
    }   
}
