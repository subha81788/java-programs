import java.util.Arrays;
import java.util.Random;

class SelectionSort {
    public void sort(int[] arr) {
        int n = arr.length;
        int minIdx;
        for(int i=0;i<n-1;i++) {
            // Set current element as minimum
            minIdx = i;   

            // Check the element to be minimum
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the numbers 
            if(minIdx != i) {
                swap(arr, minIdx, i);
                System.out.println("Pass: " + Arrays.toString(arr));
            }
        }          
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        System.out.println("\nItems swapped: " + numbers[i] + "\t" + numbers[j]); 
    }
}

public class SortSelectionDemo {
    private static final int MAX = 1000;
    private static final int SIZE = 10;
    
    public static void main(String[] args) {
        Random generator = new Random();
        int[] numbers = new int[SIZE];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }

        System.out.println("Numbers before sort:\n" + Arrays.toString(numbers));

        SelectionSort ob = new SelectionSort();

        ob.sort(numbers);

        System.out.println("\nSorted numbers:\n" + Arrays.toString(numbers));
    }   
}
