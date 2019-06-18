import java.util.logging.Logger;

public class VolatileTest {
    private static final Logger logger = Logger.getLogger(VolatileTest.class.getName());

    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeProducer().start();
    }

    static class ChangeProducer extends Thread{
        @Override
        public void run() {

            int local_value = MY_INT;
            while (MY_INT <5){
                logger.info("Incrementing MY_INT to " + local_value + 1);
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while ( local_value < 5){
                if( local_value!= MY_INT){
                    logger.info("Got Change for MY_INT : " + MY_INT);
                    local_value= MY_INT;
                }
            }
        }
    }

}
