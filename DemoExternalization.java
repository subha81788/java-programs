import java.io.File;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class DemoExternalization { 
    private static final String serFileName = "out.ser";

    public static void main(String[] args) 
    { 
        Bike bike = null; 
  
        System.out.println("Externalizing bike from file " + serFileName);
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(serFileName)))) { 
            bike = (Bike)in.readObject(); 
        } catch (Exception e) { 
            System.err.println(e); 
        } 
  
        System.out.println("After externalization the bike is:\n" + bike); 
    } 
} 
