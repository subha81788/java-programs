/*
 * Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves, calls itself for the
 * two halves, and then merges the two sorted halves. The merge() function is used for merging two halves.
 * The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges
 * the two sorted sub-arrays into one.
 * Time complexity of Merge Sort in all 3 cases (worst, average and best) is θ(nLogn) as merge sort always
 * divides the array into two halves and takes linear time to merge two halves.
 */

import java.util.Arrays;
import java.util.Random;

class MergeSort {

    // Main function that sorts arr[l..r] using merge()
    public void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        var n1 = m - l + 1;
        var n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (var i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (var j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        var i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
}

// Driver class
public class SortMergeDemo {

    private static final int MAX = 1000;
    private static final int SIZE = 10;

    public static void main(String args[]) {
        int[] arr = new int[SIZE];
        Random generator = new Random();
		
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generator.nextInt(MAX);
        }
		
        System.out.println("Numbers before sort:\n" + Arrays.toString(arr));
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted numbers:\n" + Arrays.toString(arr));
    }

}
