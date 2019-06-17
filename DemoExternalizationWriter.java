import java.io.File;
import java.io.Externalizable;
import java.io.ObjectOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

class Bike implements Externalizable { 
    private String name; 
    private int year; 
    public static int age; 
  
    public Bike() { 
        System.out.println("Default Constructor is mandatory for externalization"); 
    } 
    Bike(String name, int year) { 
        this.name = name; 
        this.year = year; 
    } 
    @Override public void writeExternal(ObjectOutput out) throws IOException { 
        out.writeObject(name); 
        out.writeInt(age); 
        out.writeInt(year); 
    } 
    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { 
        name = (String)in.readObject(); 
        year = in.readInt(); 
        age = in.readInt(); 
    } 

    @Override public String toString() { return ("Name: " + name + "\n" +  "Year: " + year + "\n" +  "Age: " + age); } 
} 
  
public class DemoExternalizationWriter { 
    public static final String serFileName = "out.ser";

    public static void main(String[] args) 
    { 
        Bike bike = new Bike("Subhashis Nath", 2011); 
        bike.age = 8;
        System.out.println("Before externalization the original bike is:\n" + bike); 
  
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(serFileName)))) { 
            out.writeObject(bike); 
            out.flush(); 
            System.out.println("Externalized data is saved in " + serFileName + " file");
        } catch (Exception e) { 
            System.err.println(e); 
        } 
  
    } 
} 
