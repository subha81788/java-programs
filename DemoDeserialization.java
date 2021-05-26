import java.io.File;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DemoDeserialization {
    private static final String serFileName = "employee.ser";

    public static Object readIn(String serFileName) throws IOException, ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(serFileName)))) {
            Object obj = in.readObject();
            return obj;
        }
    }

    public static void main(String[] args) {
        Employee emp = null;
        System.out.println("Deserializing Employee from file '" + serFileName + "'");
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
        System.out.println(emp);
    }
}

/* Output
Deserializing Employee from file 'employee.ser'
id = 0;	first name = Subhashis;	lastName = Nath; companyName = null; companyAddress = null; companyCEO = null
 */
