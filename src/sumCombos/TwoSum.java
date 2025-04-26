package sumCombos;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

//    https://leetcode.com/problems/two-sum/description/

//    Best  for interviews, and we can find this in one pass O(n)
    public  static int[] twoSumI(int[] nums, int target) {

        HashMap<Integer,Integer> map=new HashMap<>();
        int val;

        for(int i=0;i<nums.length;i++){
            val=target-nums[i];
            if(map.containsKey(val)){
                return new int[]{map.get(val),i};
            }

            map.put(nums[i],i);
        }
        return new int[]{};

    }
//   Use when only the input array is sorted
    public static int[] twoSumII(int[] nums, int target) {
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
        int[]  nums = {2,7,11,15};
        int[] indices1 = twoSumI(nums,9);
        int[] indices2 = twoSumII(nums,9);
        System.out.println(Arrays.toString(indices1));
        System.out.println(Arrays.toString(indices2));
    }
}