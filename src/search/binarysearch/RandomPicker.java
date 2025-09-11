package search.binarysearch;

import java.util.Random;

public class RandomPicker {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 3});
        System.out.println(solution.pickIndex());
    }
}
class Solution {
    private final int[] prefixWeight;
    private final int sum;
    private final Random random;

    public Solution(int[] w) {
        this.prefixWeight = buildPrefixSum(w);
        this.sum = prefixWeight[w.length - 1];
        this.random = new Random(); // reuse one instance
    }

    public int pickIndex() {
        int target = random.nextInt(sum) + 1;  // [1, sum]

        int left = 0, right = prefixWeight.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixWeight[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int[] buildPrefixSum(int[] weights) {
        int[] prefixSum = new int[weights.length];
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            prefixSum[i] = sum;
        }
        return prefixSum;
    }
}
