import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter investment amount in Rs");
        BigInteger p = new BigInteger(sc.next());
        System.out.println("Enter rate of interest %");
        BigInteger r = new BigInteger(sc.next());

        for(int t = 1; t < 20; t++) {
            var interest = p.multiply(r).multiply(BigInteger.valueOf(t)).divide(BigInteger.valueOf(100));
            var inv = p.add(interest);
            System.out.println("In simple interest after " + t + " year Rs " + p + " investment becomes Rs " + inv);
        }
    }
}
