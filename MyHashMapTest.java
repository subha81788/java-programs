import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class MyHashMapTest {
    public static void main(String[] args) {
        Map<String,Integer> hm=new HashMap<>();
        hm.put("first",1);
        hm.put("second",2);
        hm.put("third",3);
        hm.put("fourth",4);
        hm.put("fifth",5);

        for(Map.Entry<String,Integer> e : hm.entrySet()) {
            System.out.println("Key " + e.getKey() + "\tValue " + e.getValue());
        }
    }
}
