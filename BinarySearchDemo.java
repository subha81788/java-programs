/*
 * Binary Search: Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval
 * covering the whole array. If the value of the search key is less than the item in the middle of the interval,
 * narrow the interval to the lower half. Otherwise, narrow it to the upper half. Repeatedly check until the value
 * is found or the interval is empty.
 * We basically ignore half of the elements just after one comparison.
 * Binary search is faster than linear search. Time complexity is O(Log n)
 */

import java.util.Arrays;
import java.util.Random;

class BinarySearch {
    // Returns index of key if it is present in arr[l...r], else return -1
    int search(int arr[], int l, int r, int key)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            // If the element is present at the middle itself
            if (arr[mid] == key)
                return mid;
 
            // If element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > key)
                return search(arr, l, mid - 1, key);
 
            // Else the element can only be present in right subarray
            return search(arr, mid + 1, r, key);
        }
 
        // We reach here when element is not present in array
        return -1;
    }
}

public class BinarySearchDemo {
    private static final int MAX = 1000;
    private static final int SIZE = 10;

    public static void main(String[] args) {

        var generator = new Random();

        int[] numbers = new int[SIZE];

        for (var i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }

        var ob = new BinarySearch();

        var key = numbers[4];
        var res = ob.search(numbers, 0, numbers.length - 1, key);
        assert res == 4 : "Key " + key + " is not found";

        key = 1999;
        res = ob.search(numbers, 0, numbers.length - 1, key);
        assert res == -1 : "Incorrect search result. Key " + key + " should be absent.";
    }

    
}
