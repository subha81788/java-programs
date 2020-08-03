import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class User implements Comparable<User> {
    Integer id;
    String name;
    Date joinDate;

    public User(Integer id, String name, Date joinDate) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
    }

    @Override
    public int compareTo(User u) {
        return this.joinDate.compareTo(u.joinDate);
    }

    @Override
    public String toString() {
        return new String("[id = " + id + " name = " + name + "]");
    }
}

public class TestComparator {


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        User u1 = new User(1, "Ram", df.parse("1988-08-17"));
        User u2 = new User(2, "Shyam", df.parse("1992-01-11"));
        User u3 = new User(3, "Jadu", df.parse("1983-10-19"));
        User u4 = new User(4, "Madhu", df.parse("1981-10-16"));
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);

        Collections.sort(users);
        System.out.println(users);


    }
}

