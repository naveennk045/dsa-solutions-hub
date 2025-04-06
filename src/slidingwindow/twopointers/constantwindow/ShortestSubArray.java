package slidingwindow.twopointers.constantwindow;

// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/

public class ShortestSubArray {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int minLength = n + 1;
        int sum = 0;

        while (right < n){
            sum+= nums[right];
            while ( sum <= 0 ) {
                sum-= nums[left];
            }
            if (sum >= k){
                minLength = Math.min(minLength, right-left+1);
            }
            right++;
        }
        return minLength;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,5,1};
        System.out.println(shortestSubarray(nums,7));
    }
}
