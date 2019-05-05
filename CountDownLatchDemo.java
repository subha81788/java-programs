import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl=new CountDownLatch(2);

        Runnable task1 =()-> {
            for(int i=0; i<20; i+=2) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);   
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            cdl.countDown();
        };
        
        Runnable task2 =()-> {
            for(int i=1; i<20; i+=2) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);   
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            cdl.countDown();
        };

        Thread thread1 =new Thread(task1);
        Thread thread2 =new Thread(task2);
        thread1.start();
        thread2.start();

        try {
            System.out.println("Waiting " + Thread.currentThread().getName());
            cdl.await();
            System.out.println("Wait over " + Thread.currentThread().getName());
            for(int i=0; i<5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);   
            }
        } catch (InterruptedException e) {
        }
    }
}
