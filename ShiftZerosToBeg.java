public class ShiftZerosToBeg {
    public static void main(String[] args) {
        int[] arr = new int[] {2,0,1,0,0,7};
        int c=arr.length-1;
        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i] != 0) {
                arr[c--]=arr[i];
            }
        }
        while(c>=0) arr[c--]=0;
        for(int a:arr) System.out.print(a+"\t");   
    }   
}
