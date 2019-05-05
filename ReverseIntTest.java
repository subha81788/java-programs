import java.io.*;

public class ReverseIntTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an integer ");   
        int num=Integer.parseInt(br.readLine());
        System.out.println("Reverse number is " + reverseNum(num));   
    }   

    public static int reverseNum(int num) {
        int reverseNum = 0;
        while(num != 0) {
            reverseNum = reverseNum*10 + num%10;
            num/=10;
        }
        return reverseNum;
    }
}
