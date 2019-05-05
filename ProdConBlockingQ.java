import java.util.concurrent.Callable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class ProdConBlockingQ {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(8);
        ExecutorService executors = Executors.newFixedThreadPool(3);
        Callable<String> producerThread = new Producer("Producer",queue);
        Future<String> producerStatus = executors.submit(producerThread);
        System.out.println("Producer has started");
        Runnable consumerThread1 = new Consumer("Consumer1",queue);
        executors.execute(consumerThread1);
        Runnable consumerThread2 = new Consumer("Consumer2",queue);
        executors.execute(consumerThread2);
        System.out.println("Consumers have started");
        
        while (!producerStatus.isDone()) {
            //System.out.println("Producer thread is not completed yet...."); 
        }

        try {
            String str = producerStatus.get();
            System.out.println(str);   
        } catch(InterruptedException | ExecutionException e) {
            System.err.println("Exception " + e);   
        }
        executors.shutdown();
    }
}

class Producer implements Callable<String> {
    private String name;
    private BlockingQueue<Integer> sharedQueue;

    public Producer(String name, BlockingQueue<Integer> sharedQueue) {
        this.name = name;
        this.sharedQueue = sharedQueue;
    }

    @Override
    public String call() {
        try {
            for(int i=0; i<30; i++) {
                sharedQueue.put(i);
                System.out.println(name + " produced " + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        return "Proceducer has finished producing";
    }
}

class Consumer implements Runnable {
    private String name;
    private BlockingQueue<Integer> sharedQueue;

    public Consumer(String name, BlockingQueue<Integer> sharedQueue) {
        this.name = name;
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                int i = sharedQueue.take();
                System.out.println("#" + name + " consumed " + i );
                TimeUnit.SECONDS.sleep(1);
            }
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}

