package slidingwindow.easy;

import java.util.ArrayList;
import java.util.List;

public class SubArraySum {
    public static void printSubarrays(int[] arr, int k) {
        int start = 0;
        int end = 0;

        while (end < arr.length) {
            end++;

            if (end - start == k) {
                List<Integer> subarray = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    subarray.add(arr[i]);
                }
                System.out.println(subarray);
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