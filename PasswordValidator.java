import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordValidator {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a password: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();
        if(isValidPassword(password)) {
            System.out.println("It is a valid password");
        } else {
            System.out.println("It is not a valid password");
        }
    }

    public static boolean isValidPassword(String password) {
        String exp = "^[\\dA-Za-z$@#%.]([\\dA-Za-z$@#%.]){5,19}$";
        Pattern pat = Pattern.compile(exp);
        Matcher m = pat.matcher(password);
        return m.find();
    }
}
