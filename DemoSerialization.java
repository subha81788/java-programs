import java.io.File;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class superEmployee implements Serializable {
    public static String companyName;
    transient String companyAddress;
    static transient String companyCEO;
}

class Employee extends superEmployee {
    private static final long serialVersionUID = 5462223600L;
    private transient int id;
    public String firstName;
    public String lastName;
    public Employee(int id, String firstName, String lastName, String companyName, String companyAddress, String companyCEO) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyCEO = companyCEO;
    }

    @Override
    public String toString() {
        return "id = " + id + ";\tfirst name = " + firstName + ";\tlastName = " + lastName +
            ";\tcompanyName = " + companyName + ";\t companyAddress = " + companyAddress +
            ";\tcompanyCEO = " + companyCEO;
    }
}

public class DemoSerialization {
    private static final String serFileName = "employee.ser";

    public static void main(String[] args) throws IOException {
        Employee emp = new Employee(1,"Subhashis","Nath","Capgemini","BLR","CG CEO");
        System.out.println("Before serializing employee " + emp);
        writeOut(serFileName,emp);
    }

    static void writeOut(String serFileName, Serializable obj) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(serFileName)))) {
            out.writeObject(obj);
        }
        System.out.println("Serialized data is saved in '" + serFileName + "' file");
    }
}

/* Output
Before serializing employee id = 1; first name = Subhashis; lastName = Nath; companyName = Capgemini; companyAddress = BLR; companyCEO = CG CEO
Serialized data is saved in 'employee.ser' file
 */
