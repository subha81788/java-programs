import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ProdConWaitNotify {
    private static final int MAX_SIZE = 10;

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>(); 
        ExecutorService executors = Executors.newFixedThreadPool(2);
        Runnable prod = new Producer("producer",q,MAX_SIZE);
        Runnable con = new Consumer("consumer",q,MAX_SIZE);
        executors.execute(prod);
        executors.execute(con);
        executors.shutdown();
    }   
}

class Producer implements Runnable {
    private String name;
    private Queue<Integer> q;
    private int maxSize;

    Producer(String name, Queue<Integer> q, int maxSize) {
        this.name = name;
        this.q = q;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(q) {
                if(q.size() == maxSize) {
                    System.out.println("Queue ---> " + q);   
                    System.out.println("Queue is full. No space to produce.");   
                    try{
                        q.wait();
                    } catch(InterruptedException e) {
                        System.err.println(e);   
                    }
                }
                Random rand = new Random();
                int i = rand.nextInt(1000);
                q.add(i);
                System.out.println("Produced " + i);   
                q.notify();
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    System.err.println(e);   
                }
            }
        }
    }
}

class Consumer implements Runnable {
    private String name;
    private Queue<Integer> q;
    private int maxSize;

    Consumer(String name,Queue<Integer> q,int maxSize) {
        this.name = name;
        this.q = q;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(q) {
                if(q.size() == 0) {
                    System.out.println("Queue is empty. Nothing to consume.");   
                    try{
                        q.wait();
                    } catch(InterruptedException e) {
                        System.err.println(e);   
                    }
                }
                int i = q.remove();
                System.out.println("Consumed " + i);   
                System.out.println("Queue ---> " + q);   
                q.notify();
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    System.err.println(e);   
                }
            }
        }
    }
}
