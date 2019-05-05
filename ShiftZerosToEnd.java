public class ShiftZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {2,0,1,0,0,7};
        int c=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=0) {
                arr[c++]=arr[i];
            }
        }
        while(c<arr.length) arr[c++] = 0;
        for(int a : arr) System.out.print(a+"\t");   
    }   

}
