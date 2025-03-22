package slidingwindow.twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumII {
    public static int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<right){

            int sum=nums[left]+nums[right];
            if(sum==target) return new int[]{left+1,right+1};
            if(sum < target) left++;
            else right--;

        }
        return new int[]{0,0};
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,9,10,20,60,71,98,100,500};
        System.out.println(Arrays.toString(twoSum(nums,505)));
    }
}