import java.util.*;
import java.util.Map.Entry;

public class MapOrderByValue {
    public static void main(String[] arg){
        Map<String, Integer> map = new HashMap<>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()));
            }
        });

        for(Map.Entry<String, Integer> entry:list) {
            System.out.println(entry.getKey() + " ==== " + entry.getValue());
        }


    }
}
