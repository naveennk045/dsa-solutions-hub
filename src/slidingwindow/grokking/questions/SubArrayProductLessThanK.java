package slidingwindow.grokking.questions;

public class SubArrayProductLessThanK {
//    https://leetcode.com/problems/subarray-product-less-than-k/description/

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        long product = 1;
        int n = nums.length;
        int count = 0;


        for (int right = 0, left = 0; right < n; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            if (product < k) count += right - left + 1;

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}