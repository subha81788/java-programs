import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class ArrayLeftRotate {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter number of test cases: "); int t = Integer.parseInt(br.readLine());

            while(t-- > 0) {
                System.out.print("Enter array length: "); int n = Integer.parseInt(br.readLine());
                System.out.print("Enter array elements: "); String s = br.readLine();
                String[] ss = s.trim().split("\\s+");
                int[] ns = new int[n];
                for(int i=0; i<n; i++) {
                    ns[i]=Integer.parseInt(ss[i]);
                }
                System.out.print("Enter how many positions to rotate:"); int d = Integer.parseInt(br.readLine());
                int[] rs = leftRotate(ns,d);
                System.out.println("Left rotated array is " + Arrays.toString(rs));
            }
        }
    }

    public static int[] leftRotate(int[] arr, int d) {
        int l = arr.length;
        if(d > l) {
            System.out.println("Array rotation not possible as number of places to rotate is more than array length");
            return arr;
        }
        int[] x = new int[l];
        for(int i=0; i<l; i++) {
            x[(i-d+l)%l]=arr[i];
        }
        return x;
    }
}
