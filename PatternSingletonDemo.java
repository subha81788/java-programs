public class PatternSingletonDemo {
    public static void main(String[] args) {
        System.out.println("Singleton class demo");
        SingletonClass x = SingletonClass.getInstance();
        SingletonClass y = SingletonClass.getInstance();
        SingletonClass z = SingletonClass.getInstance();
        if(x == y && y == z && z == x) {
            System.out.println("All references point to same Singleton instance");
        } else {
            System.out.println("Singleton demo failed");
        }
        x.s = (x.s).toUpperCase();
        x.print();
        y.print();
        z.print();
        y.s = (y.s).toLowerCase();
        x.print();
        y.print();
        z.print();

        System.out.println("\n\nSingleton enum demo");
        SingletonEnum.INSTANCE.print();
    }   

}

class SingletonClass {
    private static volatile SingletonClass instance;
    public String s = "Hey there, I am String part of Singleton class";

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

    public void print() {
        System.out.println("Inside singleton class print method");   
        System.out.println(s);
    }
}

enum SingletonEnum {
    INSTANCE;

    public void print() {
        System.out.println("Inside singleton enum print method");   
    }
}
