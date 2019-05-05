import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Shared {
    public static int count = 0;
}

class IncThread implements Runnable {
    Semaphore sem;
    String name;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }
    public void run() {
        System.out.println("Starting " + name);
        System.out.println(name + " is waiting to acquire a permit");
        try {
            sem.acquire();
            System.out.println(name + " gets a permit");
            for(int i =0; i <5; i++) {
                Shared.count++;
                System.out.println(name + " : " + Shared.count);
                Thread.sleep(50);
            }

        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println(name + " releases permit");
        sem.release();
    }
}

class DecThread implements Runnable {
    Semaphore sem;
    String name;

    DecThread(Semaphore s, String n) {
        sem = s;
        name=n;
    }

    public void run() {
        System.out.println("Starting " + name);
        System.out.println(name + " is waiting to acquire a permit");
        try {
            sem.acquire();
            System.out.println(name + " gets a permit");
            for(int i =0; i <5; i++) {
                Shared.count--;
                System.out.println(name + " : " + Shared.count);
                Thread.sleep(50);
            }

        } catch(InterruptedException exc) {
            System.out.println(exc);
        }

        System.out.println(name + " releases permit");
        sem.release();
    }
}

class SemDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(1);
        ExecutorService es=Executors.newFixedThreadPool(2);
        Thread a = new Thread(new IncThread(sem,"A")); 
        Thread b = new Thread(new DecThread(sem,"B")); 
        es.execute(a);
        es.execute(b);
        es.shutdown();
    }
}

