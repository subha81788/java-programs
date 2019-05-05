import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.nio.file.FileSystemNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;  

@XmlRootElement
class Employee {

    @XmlAttribute
    private long id;

    @XmlElement
    private String name;

    @XmlElement
    private int salary;

    @XmlTransient
    private String city;

    public Employee() {
		super();
	}

	Employee(long id, String name, int salary, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.city = city;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}
}

public class MyJaxbTest {
    public static void main(String[] args) {
        Employee emp=new Employee(1L,"Vimal",50000,"Kolkata");  

        try {
			JAXBContext ctx = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = ctx.createMarshaller();  
			//marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
			marshaller.marshal(emp, new FileOutputStream("employee.xml"));  
			StringWriter sw = new StringWriter();
			marshaller.marshal(emp,sw);
			System.out.println("Serialized string:\n" + sw.toString());
        
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			Employee emp2 = (Employee) unmarshaller.unmarshal(new FileInputStream("employee.xml"));
			System.out.println("\nDeserialized employee object\n" + emp2);
		} catch (JAXBException e) {
			System.err.println(e);
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
    }   
}

<dependency>
        <groupId>javax.xml.bind</groupId>
        <artifactId>jaxb-api</artifactId>
        <version>2.2.11</version>
</dependency>

