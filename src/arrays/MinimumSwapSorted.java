package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumSwapSorted {
    public static int minimumSwap(int[] nums) {
        int n = nums.length;
        int[][] tracker = new int[n][2];

        for (int i = 0; i < n; i++) {
            tracker[i][0] = nums[i];
            tracker[i][1] = i;
        }
        Arrays.sort(tracker, Comparator.comparingInt(a -> a[0]));

        boolean[] visited = new boolean[n];
        int swapCount = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || tracker[i][1] == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = tracker[j][1];
                cycleSize++;
            }
            swapCount += cycleSize - 1;
        }
        return swapCount;
    }

    public static void main(String[] args) {
        int[] nums = {8,20,11,12,13,19,18};
        System.out.println(minimumSwap(nums));
    }
}