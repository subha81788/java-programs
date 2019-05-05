import java.util.List;
import java.util.Arrays;

public class SubsetSearch {
    public static void main(String[] args) {
        List<Integer> a1 = Arrays.asList(10,20,30,40,50,60,20,30);
        List<Integer> a2 = Arrays.asList(20,30);

        int c=0;
        for(int i=0; i<a2.size() - 1;i++) {
            for(int j=0; j<a1.size() - 1; j++) {
                if( (a1.get(j) == a2.get(i)) && (a1.get(j+1) == a2.get(i+1)) ) {
                    c++;
                }
            }
        }
        System.out.println("Occurrence " + c);   
    }   
}
