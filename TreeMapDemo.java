import java.util.*;

class TreeMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<String,Integer>();
        map.put("Ram",1000);
        map.put("Shyam", 2000);
        map.put("Jadu",5000);
        map.put("Madhu",2500);

        for (Map.Entry<String,Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }
    }
}

