import java.util.Scanner;

public class ExceptionTest {

    public static void validateAge(int age) {
        if(age < 18) {
            throw new IllegalAgeException("Age is too small");
        }
        System.out.println("Age is valid");   
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age:"); int age = sc.nextInt();

        try {
            validateAge(age);
        } catch(IllegalAgeException e) {
            System.out.println(e);   
        } catch(Exception e) {
            System.out.println(e);   
        }
    }

}

class IllegalAgeException extends RuntimeException {

    private final int code;

    public IllegalAgeException(String message) {
        super(message);
        this.code = 0;
    }

    public IllegalAgeException(int code) {
        super();
        this.code = code;
    }

    public IllegalAgeException(String message, int code) {
        super(message);
        this.code = code;
    }

    public IllegalAgeException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public IllegalAgeException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }
}
