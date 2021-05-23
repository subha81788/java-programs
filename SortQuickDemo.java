import java.util.Arrays;
import java.util.Random;

class Quicksort  {

    public void sort(int[] numbers) {
        // check for empty or null array
        if (numbers ==null || numbers.length==0){
            return;
        }
        quicksort(numbers, 0, numbers.length - 1);
    }

    private void quicksort(int[] numbers, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we swap the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(numbers, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(numbers, low, j);
        if (i < high)
            quicksort(numbers, i, high);
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

public class SortQuickDemo {

    private static final int MAX = 1000;
    private static final int SIZE = 10;

    public static void main(String[] args) {

        Random generator = new Random();

        int[] numbers = new int[SIZE];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }

        System.out.println("Numbers before sort:\n" + Arrays.toString(numbers));


        Quicksort ob = new Quicksort();

        ob.sort(numbers);

        System.out.println("\nNumbers after sort:\n" + Arrays.toString(numbers));
    }
}

