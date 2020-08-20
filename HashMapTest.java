import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Comparator;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Integer> hm=new HashMap<>();
        hm.put("Apple", 65000);  
        hm.put("HP", 20000);  
        hm.put("Dell", 32000);  
        hm.put("Asus", 21478);  
        hm.put("Samsung", 36546);  
        hm.put("Lenovo", 19990);  

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

        System.out.println("\n\nHashMap in decreasing order by value");
        hm = sortByValueInDescOrder(hm);
        hm.forEach((k,v) -> System.out.println(k + "\t" + v));
    }

    public static Map<String,Integer> sortByValueInDescOrder(Map<String,Integer> m) {
        // create list from map entries
        List<Map.Entry<String,Integer>> al = new ArrayList<>(m.entrySet());
        Comparator<Map.Entry<String,Integer>> descValComparator = (Map.Entry<String,Integer> me1, Map.Entry<String,Integer> me2) -> me2.getValue().compareTo(me1.getValue());

        // sort entry list
        Collections.sort(al, descValComparator);

        // put the map entries into a LinkedHashMap and return
        Map<String,Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> me : al) {
            sortedMap.put(me.getKey(), me.getValue());
        }
        return sortedMap;
    }
}
