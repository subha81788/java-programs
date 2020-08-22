import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class ImmutableCloneableTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var id = 10;
        var name = "Amit";
        var marks = new HashMap<String,Integer>();
        marks.put("English",91);
        marks.put("Maths",99);
        marks.put("Computer",95);
        var dob = new Dob(17,8,1988);
        var student = new ImmutableStudent(id,name,marks,dob);
        System.out.println("Student details\n" + student);

        // try to modify the student object state
        id = 10;
        name = "Amitav";
        marks.put("History",85);
        student.getMarks().put("History",85);
        var year = 1992;
        student.getDob().setYear(year);
        
        System.out.println("\nAfter local modification");
        System.out.println("Student details\n" + student);
        System.out.println("name modified = " + (name == student.getName()));
        System.out.println("marks modified = " + (marks == student.getMarks()));
        System.out.println("dob year modified = " + (year == student.getDob().getYear()));
    }
}

final class ImmutableStudent {
    private final int id;
    private final String name;
    private final HashMap<String,Integer> marks;
    private final Dob dob;

    public ImmutableStudent(int id, String name, HashMap<String,Integer> marks, Dob dob) {
        System.out.println("Creating Student object: performing deep copy of mutable members");
        this.id = id;
        this.name = name;
        this.marks = new HashMap<String,Integer>();
        Iterator<String> itr = marks.keySet().iterator();
        while(itr.hasNext()) {
            var k = itr.next();
            this.marks.put(k,marks.get(k));
        }
        this.dob = new Dob();
        this.dob.setDate(dob.getDate());
        this.dob.setMonth(dob.getMonth());
        this.dob.setYear(dob.getYear());
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String,Integer> getMarks() {
        return (HashMap<String,Integer>) this.marks.clone(); // shallow copy
    }

    public Dob getDob() throws CloneNotSupportedException {
        return (Dob)dob.clone(); // shallow copy
    }

    @Override
    public String toString() { return "id = " + this.id + " name = " + this.name + " marks = " + this.marks + " dob = " + this.dob; }
}

class Dob implements Cloneable {
    private int date;
    private int month;
    private int year;

    public Dob() {}

    public Dob(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getDate() { return this.date; }

    public void setDate(int date) { this.date = date; }

    public int getMonth() { return this.month; }

    public void setMonth(int month) { this.month = month; }

    public int getYear() { return this.year; } 

    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() { return "dob = " + this.date + "/" + this.month + "/" + this.year; }
}
