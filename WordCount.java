import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WordCount {
    public static void main(String[] args) {
        Map<String,Integer> m = new TreeMap<>();
        try(Scanner sc = new Scanner(new FileInputStream("input.txt"))) {
            while(sc.hasNextLine()) {
                String line = sc.nextLine().toLowerCase();
                String[] words = line.split(" ");
                for(String w : words) {
                    if(!m.containsKey(w)) {
                        m.put(w,1);
                    }
                    m.put(w,m.get(w)+1);
                }
            }
        } catch(FileNotFoundException e) {
            System.err.println(e);   
        }

        System.out.println("All the words are :");   
        int maxOccurrence=0;
        String mostRepeatedWord = "";
        for(Map.Entry<String,Integer> e : m.entrySet()) {
            String word = e.getKey();
            int count = e.getValue();
            System.out.println(word + "[" + count + "]");   
            if(count > maxOccurrence) {
                maxOccurrence = count;
                mostRepeatedWord = word;
            }
        }
        System.out.println("\n\nMost repeated word is :" + mostRepeatedWord +
                " with occurrence " + maxOccurrence);   
    }   
}
