import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyJacksonTest {
    public static void main(String[] args) {
        Employee emp = createDummyEmployee();
        String jsonFileName = "employee.json";
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        try {
            String jsonString = mapper.writeValueAsString(emp);
            System.out.println("Serialized to string\n" + jsonString);   
            mapper.writeValue(new File(jsonFileName), emp);
            File file = new File("employee.json");
            Employee emp2 = mapper.readValue(file, Employee.class);
            System.out.println("Deserialized employee object\n" + emp2);
        } catch(JsonGenerationException e) {
            e.printStackTrace();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } 
    }   

	public static class Employee {
		private String id;
		private String name;
		private BigDecimal salary;
		private List<String> skills;
		@JsonIgnore
		private String city;

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", skills=" + skills + ", city="
					+ city + "]";
		}
	}

    private static Employee createDummyEmployee() {
        Employee emp = new Employee();
        emp.id = "A001";
        emp.name = "Animesh";
        emp.city = "Kolkata";
        emp.salary = new BigDecimal("10000");
        List<String> skills = new ArrayList<String>();
        skills.add("Sales");
        skills.add("Customer handling");
        skills.add("Attending calls");
        emp.skills = skills;
        return emp;
    }
}

  <dependencies>
	  <dependency>
		  <groupId>com.fasterxml.jackson.core</groupId>
		  <artifactId>jackson-core</artifactId>
		  <version>2.9.6</version>
	</dependency>

	<dependency>
	  <groupId>com.fasterxml.jackson.core</groupId>
	  <artifactId>jackson-annotations</artifactId>
	  <version>2.9.6</version>
	</dependency>

	<dependency>
	  <groupId>com.fasterxml.jackson.core</groupId>
	  <artifactId>jackson-databind</artifactId>
	  <version>2.9.6</version>
	</dependency>
  </dependencies>
