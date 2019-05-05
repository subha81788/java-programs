public class SelectionSortDemo {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int minIdx;
        for(int i=0;i<n-1;i++) {
            // Set current element as minimum
            minIdx = i;   

            // Check the element to be minimum
            for(int j = i + 1; j < n; j++) {
                if(arr[j] <arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the numbers 
            if(minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;

                System.out.println("\nItems swapped " + arr[i] + "\t" + arr[minIdx]); 
                for(int x : arr) {
                    System.out.print(x + "\t");   
                }
            }
        }          
    }

    public static void main(String[] args) {
        int[] a = {4,6,3,2,1,9,7};
        System.out.println("Before selection sort");   
        for(int x : a) {
            System.out.print(x + "\t");   
        }
        selectionSort(a);
        System.out.println("\nAfter selection sort");   
        for(int x : a) {
            System.out.print(x + "\t");   
        }
    }   
}
