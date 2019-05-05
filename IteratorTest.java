import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class IteratorTest {
    public static void main(String[] args) {
        Runnable task = ()-> {
            Date startTime = new Date();
            Map<Integer,String> syncMap = new ConcurrentHashMap<>();
            for(int i=0; i < 10000000; i++) {
                syncMap.put(i,"Hello");
            }
            Iterator<Map.Entry<Integer,String>> itr = syncMap.entrySet().iterator();
            int j=0;
            while(itr.hasNext()) {
                Map.Entry e = itr.next();
                //System.out.println(e.getKey() + " === " + e.getValue());   
                j++;
                syncMap.put(500,"Hello");
            }
            System.out.println("Start time -> " + startTime);
            System.out.println("End time -> " + new Date());   
        };

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(task);
        threadPool.shutdown();
    }   
}
