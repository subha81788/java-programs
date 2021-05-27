import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;

public class PatternSingletonDemo {
    public static void main(String[] args) {
        System.out.println("Singleton class demo");
        SingletonClass x = SingletonClass.getInstance();
        SingletonClass y = SingletonClass.getInstance();
        SingletonClass z = SingletonClass.getInstance();
        assert x == y && y == z && z == x : "Singleton demo failed";
        assert x.hashCode() == y.hashCode() && y.hashCode() == z.hashCode() && z.hashCode() == x.hashCode() : "All singleton instances should have same hashCode";

        try {
            SingletonClass a = (SingletonClass)x.clone();
            System.out.println(a);
        } catch(CloneNotSupportedException e) {
            System.err.println("Exception occurred when cloning singleton instance: " + e);
        }

        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.ser"))) {
            out.writeObject(x);
        } catch(IOException e) {
            System.err.println("Exception occurred when serializing singleton instance: " + e);
        }

        try(ObjectInput in = new ObjectInputStream(new FileInputStream("file.ser"))) {
            SingletonClass p = (SingletonClass) in.readObject();
            assert x == p : "After deserialization the instances should be same";
            assert x.hashCode() == p.hashCode() : "After deserialization hasCode of the instances should be same";
        } catch(ClassNotFoundException | NotSerializableException e) {
            System.err.println("Exception occurred when deserializing singleton instance: " + e);
        } catch(IOException e) {
            System.err.println("IOException occurred when deserializing singleton instance: " + e);
        }

        //System.out.println("\n\nSingleton enum demo");
        //SingletonEnum.INSTANCE.print();
    }   

}

class SingletonClass {
    private static volatile SingletonClass instance;

    private SingletonClass() {}

    public static SingletonClass getInstance() {
        if(instance == null) {
            synchronized(SingletonClass.class) {
                if(instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    // prevent singleton pattern from cloning
    @Override
    protected Object clone() throws CloneNotSupportedException  {
        throw new CloneNotSupportedException();
    }

    // prevent singleton pattern from deserialization
    protected Object readResolve() { 
        return instance; 
    }
}

enum SingletonEnum {
    INSTANCE;

    public void print() {
        System.out.println("Inside singleton enum print method");   
    }
}
