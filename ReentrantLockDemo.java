import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Resource {

	public void doDBOperation(){
            System.out.println("Doing DB Read, Write operations");
	}
	
	public void doLogging(){
            System.out.println("Just logging");
	}
}

class SynchronizedLockExample implements Runnable {

	private Resource resource;
	
	public SynchronizedLockExample(Resource r){
		this.resource = r;
	}
	
	@Override
	public void run() {
		synchronized (resource) {
			resource.doDBOperation();
		}
		resource.doLogging();
	}
}

class ConcurrencyLockExample implements Runnable {

	private Resource resource;
	private Lock lock;
	
	public ConcurrencyLockExample(Resource r){
		this.resource = r;
		this.lock = new ReentrantLock();
	}
	
	@Override
	public void run() {
		try {
			if(lock.tryLock(10, TimeUnit.SECONDS)){
                            resource.doDBOperation();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			//release lock
			lock.unlock();
		}
		resource.doLogging();
	}

}

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Resource r = new Resource();
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.submit(new ConcurrencyLockExample(r));
        Thread.sleep(1000);
        //executors.submit(new SynchronizedLockExample(r));
    }
}
