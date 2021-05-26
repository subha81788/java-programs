import java.util.concurrent.Callable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.Random;


public class ProdConBlockingQ {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(15);

        Callable<String> producerThread = new Producer("Producer",queue);
        Future<String> producerStatus = executor.submit(producerThread);
        System.out.println("Producer has started");

        Runnable consumerThread1 = new Consumer("Consumer1",queue);
        Runnable consumerThread2 = new Consumer("Consumer2",queue);
        executor.submit(consumerThread1);
        executor.submit(consumerThread2);
        System.out.println("Consumers have started");
        
        while (!producerStatus.isDone()) {}

        try {
            String str = producerStatus.get();
            System.out.println(str);   
        } catch(InterruptedException | ExecutionException e) {
            System.err.println("Exception " + e);   
        }
        executor.shutdown();
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
            for(int i=0; i<50; i++) {
                sharedQueue.put(i);
                System.out.println("#" + name + " produced " + i);
                System.out.println(sharedQueue);
                TimeUnit.SECONDS.sleep(new Random().nextInt(4));
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
                System.out.println("##" + name + " consumed " + i );
                System.out.println(sharedQueue);
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            }
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}

