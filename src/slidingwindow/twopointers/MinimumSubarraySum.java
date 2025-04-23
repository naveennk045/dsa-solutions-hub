package slidingwindow.twopointers;

//https://leetcode.com/problems/minimum-size-subarray-sum/

public class MinimumSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = n + 1;

        int left = 0, right = 0;
        int sum = 0;

        while (right < n) {

            sum+= nums[right];

            while (sum > target){

                minLength = Math.min(minLength,(right-left+1));
                sum-= nums[left];
                left++;

            }
            if (sum >= target){
                minLength = Math.min(minLength,(right-left+1));
            }
            right++;
        }


        if(minLength == n + 1) return 0;

        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{1,2,3,5,4,6,}));
    }
}