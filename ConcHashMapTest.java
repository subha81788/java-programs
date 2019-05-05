import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Iterator;

public class ConcHashMapTest {
    public static void main(String args[]) {
         Map<String,Integer> scores = new ConcurrentHashMap<>();
         scores.put("Anil",22);
         scores.put("Ajit",44);
         scores.put("Brad",1);
         scores.put("Sachin",62);
         scores.put("Sourav",89);

         Iterator<Map.Entry<String,Integer>> itr =scores.entrySet().iterator();
         while(itr.hasNext()) {
             Map.Entry me = itr.next();
             System.out.println("Player = " + me.getKey() + "\tScore = " + me.getValue());  
         }

         scores.forEach((k,v) -> System.out.println("Player = " + k + "\tScore = " + v));  
    }
}
