package slidingwindow.grokking.questions;

public class MinimumSizeSubarraySum {
    //    https://leetcode.com/problems/minimum-size-subarray-sum/description/
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = n + 1;

        int sum = 0;
        for (int right = 0, left = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, (right - left + 1));
                sum -= nums[left];
                left++;
            }
        }
        return (minLength == n + 1) ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}