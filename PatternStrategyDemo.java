// Java program to demonstrate Strategy design pattern
import java.util.Comparator; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Collections;
  
class Student { 
    int rollNo; 
    String name, address; 
  
    public Student(int rollNo, String name, String address) { 
        this.rollNo = rollNo; 
        this.name = name; 
        this.address = address; 
    } 
  
    @Override
    public String toString() { 
        return this.rollNo + " " + this.name + " " + this.address; 
    } 
} 
  
// Driver class 
public class PatternStrategyDemo { 
    public static void main (String[] args) { 

        // An implementation of Strategy interface Comparator which decides to compare students by rollNo
        Comparator<Student> sortByRollStrategy = (a,b) -> a.rollNo - b.rollNo;

        // Another implementation of Strategy interface Comparator which decides compareilter students by name
        Comparator<Student> sortByNameStrategy = (a,b) -> a.name.compareTo(b.name);

        // Another implementation of Strategy interface Comparator which decides compareilter students by address
        Comparator<Student> sortByAddressStrategy = (a,b) -> a.address.compareTo(b.address);

        /* 
         * compare() method confirms Open Closed design principle, It's open for extension but closed for modification
         * because you can provide any comparison criterion by providing different implementations of compare Strategy
         * but no need to change any code in compare() method iteself. New functionality will be provided by new code.
         */

        List<Student> al = new ArrayList<Student>() {
            {
                add(new Student(121, "Ram", "bangalore")); 
                add(new Student(131, "Sam", "nyc")); 
                add(new Student(111, "Bob", "london")); 
            }
        };
  
        System.out.println("Unsorted"); 
        al.forEach(System.out::println);
  
        Collections.sort(al, sortByRollStrategy); 
        System.out.println("\nSorted by rollNo"); 
        al.forEach(System.out::println);
  
        Collections.sort(al, sortByNameStrategy); 
        System.out.println("\nSorted by name"); 
        al.forEach(System.out::println);

        Collections.sort(al, sortByAddressStrategy); 
        System.out.println("\nSorted by address"); 
        al.forEach(System.out::println);
    } 
} 
