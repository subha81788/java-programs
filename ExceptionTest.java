import java.util.Scanner;

public class ExceptionTest {
    public static void validateAge(int age) throws IllegalAgeException {
        if(age < 18) {
            throw new IllegalAgeException("Age is too small");
        } else {
            System.out.println("Age is valid");   
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age:");   
        int age = sc.nextInt();
        try {
            validateAge(age);
        } catch(IllegalAgeException e) {
            System.out.println(e);   
        }
    }
}

class IllegalAgeException extends Exception {
    public IllegalAgeException(String msg) {
        super(msg);
    }
}
