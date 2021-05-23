import java.util.Arrays;
import java.util.Random;

class BubbleSort {
    public void sort(int[] arr, int n) {  
        for(int i=0; i < n; i++) {  
            for(int j=1; j < (n-i); j++) {  
                if(arr[j-1] > arr[j]) {  
                    swap(arr, j-1, j);
                }  
            }  
            System.out.println("PASS #" + (i+1) + ": " + Arrays.toString(arr));   
        }  
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

public class SortBubbleDemo {

    private static final int MAX = 1000;
    private static final int SIZE = 10;

    public static void main(String[] args) {  
        int arr[] = new int[SIZE];

        Random generator = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = generator.nextInt(MAX);
        }
        System.out.println("Array before sort: " + Arrays.toString(arr));  

        BubbleSort ob = new BubbleSort();
        ob.sort(arr,arr.length); 

        System.out.println("Sorted array: " + Arrays.toString(arr));  
    }  
}
