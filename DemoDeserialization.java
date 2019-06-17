import java.io.File;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DemoDeserialization {
    private static final String serFileName = "employee.ser";

    public static Object readIn(String serFileName) throws IOException, ClassNotFoundException, FileNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(serFileName)))) {
            Object obj = in.readObject();
            return obj;
        }
    }

    public static void main(String[] args) {
        Employee emp = null;
        try {
            emp = (Employee)readIn(serFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found");
            e.printStackTrace();
            return;
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Deserializing Employee...");
        System.out.println(emp);
    }
}
