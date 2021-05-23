/*
 * It defines a family of algorithms. It encapsulates each algorithm. It makes the algorithms interchangeable within that family.
 * The main benefit of using the Strategy pattern is flexibility. The client can choose any algorithm at run time,
 * you can easily add a new Strategy without modifying classes that use strategies
 */

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
                add(new Student(121, "Ram", "Bangalore")); 
                add(new Student(131, "Sam", "New York City")); 
                add(new Student(111, "Bob", "London")); 
            }
        };
  
        System.out.println("Students before sorting: " + al); 
  
        al.sort(sortByRollStrategy);
        System.out.println("\nStudents sorted by rollNo: " + al); 
  
        al.sort(sortByNameStrategy);
        System.out.println("\nStudents sorted by name: " + al); 

        al.sort(sortByAddressStrategy);
        System.out.println("\nStudents sorted by address: " + al); 
    } 
} 
