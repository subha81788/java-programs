import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class PairsWithGivenSum {
    public static void main(String[] args) throws NumberFormatException {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of test cases: "); int t = Integer.parseInt(sc.nextLine());
            while(t-- > 0) {
                System.out.print("Enter number of items in each array and the sum: "); String s = sc.nextLine();
                String[] ss = s.split("\\s+");
                int m = Integer.parseInt(ss[0]), n = Integer.parseInt(ss[1]), sum = Integer.parseInt(ss[2]);
                System.out.print("Enter the items in 1st array: "); s = sc.nextLine(); ss = s.split("\\s+");
                int[] a = new int[m];
                a = Arrays.stream(ss).mapToInt(Integer::parseInt).limit(m).toArray();
                System.out.print("Enter the items in 2nd array: "); s = sc.nextLine(); ss = s.split("\\s+");
                int[] b = new int[n];
                b = Arrays.stream(ss).mapToInt(Integer::parseInt).limit(n).toArray();
                System.out.println();
                for(int i=0; i<m; i++) {
                    for(int j=0; j<n; j++) {
                        if(a[i] + b[j] == sum) {
                            System.out.print(a[i] + " " + b[j] + ", ");
                        }
                    }
                }
            }
        }
    }
}
