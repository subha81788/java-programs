import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailMatcher {
    public static List<String> findEmails(String txt) {
        Pattern p = Pattern.compile("[\\dA-Za-z_-]+@[\\dA-Za-z_-]+\\.[\\dA-Za-z_-]+");
        Matcher m = p.matcher(txt);
        List<String> emails = new ArrayList<>();
        while(m.find()) {
            emails.add(m.group());
        }
        return emails;
    }
    
    public static void main(String[] args) {
        var txt = "*** test@gmail.com&&^ test2@yahoo.com((& ";
        assert findEmails(txt) != null : "failed to extract emails";
        findEmails(txt).forEach(System.out::println);
    }
}
