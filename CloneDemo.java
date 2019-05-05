class A implements Cloneable {
    String name;
    B b;
    public A() {
        b = new B();
        b.name = "world";
    }

    @Override
    public Object clone() {
        //return new A(); //deep copy
        try {
            return super.clone();
        } catch(CloneNotSupportedException e) {
            System.err.println(e);   
            return null;
        }
    }

    @Override
    public String toString() {
        return "name = " + name + " b.name = " + b.name;
    }
}

class B {
    String name;
}

public class CloneDemo {
    public static void main(String[] args) {
        A ob = new A();
        ob.name = "Hello";
        System.out.println(ob);   

        A cl = (A)ob.clone();
        System.out.println("clone " + cl);   

        try {
            A fornameob = (A)Class.forName("A").newInstance();
            System.out.println("Class for name " + fornameob);   
        }catch(Exception e) {
            System.err.println(e);   
        }

        System.out.println("Modify");   
        ob.b.name = "horray";
        System.out.println(ob);   
        System.out.println("clone " + cl);   

    }   
}
