import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows:");
        int r = sc.nextInt();

        drawPattern(r);
    }

    public static void drawPattern(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=n-i+1; j>=1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
