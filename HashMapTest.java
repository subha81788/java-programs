import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Integer> hm=new HashMap<>();
        hm.put("first",1);
        hm.put("second",2);
        hm.put("third",3);
        hm.put("fourth",4);
        hm.put("fifth",5);

        System.out.println("using java 8 forEach loop");
        hm.forEach((k,v) -> System.out.println(k + "\t" + v));

        System.out.println("\n\nusing for loop");
        for(Map.Entry<String,Integer> me : hm.entrySet()) {
            System.out.println("Key " + me.getKey() + "\tValue " + me.getValue());
        }

        System.out.println("\n\nusing iterator");
        Iterator<Map.Entry<String,Integer>> itr = hm.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, Integer> me = (Map.Entry<String,Integer>) itr.next();
            System.out.println(me.getKey() + "\t" + me.getValue());
        }
    }
}
