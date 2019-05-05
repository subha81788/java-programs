import java.util.Map;
import java.util.TreeMap;

class Dog implements Comparable {
    String color;
    Dog(String c) {
        color = c;
    }

    @Override
    public int hashCode() {
        return color.length();
    }

    @Override
    public boolean equals(Object d) {
        return this.color.equals(((Dog)d).color);
    }

    @Override
    public int compareTo(Object d) {
        return this.color.compareTo(((Dog)d).color);
    }

    @Override
    public String toString(){
        return color + " dog";
    }
}

public class TreeMapTest {
    public static void main(String[] args) {
        Dog d1 = new Dog("red");
        Dog d2 = new Dog("black");
        Dog d3 = new Dog("white");
        Dog d4 = new Dog("white");
        Map<Dog,Integer> treeMap = new TreeMap<>();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
        for (Map.Entry entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
