package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class SubArraySum {
    public static void printSubarrays(int[] arr, int k) {
        int start = 0;
        int end = 0;

        // Expand the window by moving end
        while (end < arr.length) {
            // Add the current element to the window
            end++;

            // When the window size reaches k, print the subarray
            if (end - start == k) {
                // Print the subarray from start to end-1
                List<Integer> subarray = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    subarray.add(arr[i]);
                }
                System.out.println(subarray);

                // Slide the window by moving start pointer
                start++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        printSubarrays(arr, k);
    }
}