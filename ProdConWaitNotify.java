import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class ProdConWaitNotify {
    private static final int MAX_Q_SIZE = 10;

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>(); 
        Runnable prod = new Producer("producer",q,MAX_Q_SIZE);
        Runnable con = new Consumer("consumer",q,MAX_Q_SIZE);

        Thread prodThread = new Thread(prod);
        Thread conThread = new Thread(con);

        prodThread.start();
        conThread.start();
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
        var generator = new Random();
        while(true) {
            synchronized(q) {
                if(q.size() == maxSize) {
                    System.out.println("Queue ---> " + q);   
                    System.out.println("Queue is full. No space to produce.");   
                    try{
                        q.wait(2000);
                    } catch(InterruptedException e) {
                        System.err.println(e);   
                    }
                }
                var i = generator.nextInt(1000);
                q.add(i);
                System.out.println(this.name + " produced " + i);   
                q.notifyAll();
                try {
                    Thread.sleep(generator.nextInt(500));
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
                if(q.isEmpty()) {
                    System.out.println("Queue is empty. Nothing to consume.");   
                    try{
                        q.wait();
                    } catch(InterruptedException e) {
                        System.err.println(e);   
                    }
                }
                var i = q.remove();
                System.out.println(this.name + " consumed " + i);   
                System.out.println("Queue ---> " + q);   
                q.notifyAll();
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch(InterruptedException e) {
                    System.err.println(e);   
                }
            }
        }
    }
}
