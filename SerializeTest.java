import java.io.*;

class Student implements Serializable {
    private int id;
    private transient String name;
    private String subject;
    public static int flag = 10;
    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
       return "id = " + id +
                " name = " + name + " subject = " + subject + " flag = " + flag;
    }
}


class CSEStudent extends Student {
    public CSEStudent(int id, String name) {
        super(id,name,"CSE");
    }
}

public class SerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student csStudent = new CSEStudent(1,"Arijit");
        System.out.println(csStudent);   
        try(FileOutputStream fout = new FileOutputStream("output.txt")) {
            try(ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(csStudent);
            }
        }
        System.out.println("Object persisted. Serialization successful");   

        try(FileInputStream fin = new FileInputStream("output.txt")) {
            try(ObjectInputStream in = new ObjectInputStream(fin)) {
                CSEStudent st = (CSEStudent)in.readObject();
                System.out.println("Deserialization successful\n" + st);   
            }
        }
    }   
}


