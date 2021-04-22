import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConReentrantLock {

    public static void main(String[] args) {

        // Object on which producer and consumer thread will operate
        Buffer sharedResource = new Buffer();

        // creating producer and consumer threads
        Runnable prod = new Producer("PRODUCER", sharedResource);
        Runnable con = new Consumer("CONSUMER", sharedResource);
		Thread prodThread = new Thread(prod);
		Thread conThread = new Thread(con);

        // starting producer and consumer threads
        prodThread.start();
        conThread.start();
    }

}

class Buffer {
    // producer consumer problem data
    private static final int CAPACITY = 10;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Random theRandom = new Random();

    // lock and condition variables
    private final Lock theLock = new ReentrantLock();
    private final Condition bufferNotFull = theLock.newCondition();
    private final Condition bufferNotEmpty = theLock.newCondition();

    public void put() throws InterruptedException {
		while(true) {
			theLock.lock();
			try {
				while (queue.size() == CAPACITY) {
					System.out.println(Thread.currentThread().getName()
							+ " : Buffer is full, waiting");
					bufferNotEmpty.await();
				}

				int number = theRandom.nextInt(1000);
				
				queue.add(number);
				System.out.printf("%s produced %d into queue %n", Thread
							.currentThread().getName(), number);

				// signal consumer thread that, buffer has element now
				System.out.println(Thread.currentThread().getName()
							+ " : Signalling that buffer is full now");
				bufferNotFull.signalAll();
				try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    System.err.println(e);   
                }
			} finally {
				theLock.unlock();
			}
		}
    }

    public void get() throws InterruptedException {
		while(true) {
			theLock.lock();
			try {
				while (queue.size() == 0) {
					System.out.println(Thread.currentThread().getName()
							+ " : Buffer is empty, waiting");
					bufferNotFull.await();
				}

				Integer value = queue.poll();
				if (value != null) {
					System.out.printf("%s consumed %d from queue %n", Thread
							.currentThread().getName(), value);

					// signal producer thread that, buffer may be empty now
					System.out.println(Thread.currentThread().getName()
							+ " : Signalling that buffer may be empty now");
					bufferNotEmpty.signalAll();
				}
				try {
                    Thread.sleep(300);
                } catch(InterruptedException e) {
                    System.err.println(e);   
                }
			} finally {
				theLock.unlock();
			}
		}
    }
}

class Producer implements Runnable {
	String name;
    Buffer sharedResource;

    public Producer(String name, Buffer sharedResource) {
		this.name = name;
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            sharedResource.put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
	String name;
    Buffer sharedResource;

    public Consumer(String name, Buffer sharedResource) {
		this.name = name;
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            sharedResource.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
