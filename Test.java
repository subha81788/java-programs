import java.util.*;

public class Test<T extends Number> {
    public static void main(String[] args) {
        //List<?> l1 = new ArrayList<>();
        //List<String> l2 = new ArrayList();
        //List<Object> l3 = new ArrayList<String>();
        List<? extends Object> l4 = new ArrayList<String>();

    }
}
