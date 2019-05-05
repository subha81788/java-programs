import java.util.concurrent.Semaphore;

class Q {
    private int n;
    private static Semaphore semProd = new Semaphore(1);
    private static Semaphore semCon = new Semaphore(0);

    int get() {
        int val;
        try {
            semCon.acquire();
        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
        val = n;
        semProd.release();
        return val;
    }

    void put(int val) {
        try {
            semProd.acquire();
        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
        n = val;
        System.out.println("produced : " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
        new Thread(this,"Producer").start();
    }
    public void run() {
        for(int i =0; i<10; i++) q.put(i);
    }
}

class Consumer implements Runnable {
    Q q;
    Consumer(Q q) {
        this.q=q;
        new Thread(this, "Consumer").start();
    }
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("consumed : " + q.get());
        }
    }
}

public class ProdCon {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
