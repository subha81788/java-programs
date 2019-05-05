public class EnumSingleton {
    public static void main(String[] args) {
        SingletonEnum.INSTANCE.print();
        SingletonClass instance = SingletonClass.getInstance();
        instance.print();
    }   

}

enum SingletonEnum {
    INSTANCE;

    public void print() {
        System.out.println("Inside singleton enum");   
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

    public void print() {
        System.out.println("Inside singleton class");   
    }
}
