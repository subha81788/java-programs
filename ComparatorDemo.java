import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Employee> al=new ArrayList<Employee>() {
            {
                add(new Employee("Ram",3000));
                add(new Employee("Sam",4000));
                add(new Employee("Hari",1000));
                add(new Employee("Jadu",2000));
            }
        };
        System.out.println("Employee record:\n" + al);
        System.out.println("\nEmployee record in decreasing order of salary:");
        al.sort(new MySalaryComp());
        System.out.println(al);
    }
}

class Employee {
    public final String name;
    public final int sal;

    Employee(String n, int s) {
        name=n;
        sal=s;
    }

    public String toString() {
        return("Name=" + name + "\tSalary="+ sal);
    }
}

class MySalaryComp implements Comparator<Employee> {

    public int compare(Employee e1, Employee e2) {

        // Descending order of salary
        if(e1.sal < e2.sal) {
            return 1;
        }
        if(e1.sal > e2.sal) {
            return -1;
        }
        return 0;
    }
}
