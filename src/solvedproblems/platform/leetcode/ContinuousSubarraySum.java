package solvedproblems.platform.leetcode;

//https://leetcode.com/problems/continuous-subarray-sum/


import java.util.HashMap;

public class ContinuousSubarraySum {

//    optimized approach - using HashMap + prefix sum
    public static boolean checkSubarraySumII(int[] nums,int k){
        HashMap<Integer,Integer> remainderMap=new HashMap<>();
        remainderMap.put(0,-1); // to handle sune itself
        int prefixSum=0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum+=nums[i];
            int remainder= prefixSum%k;

            if(remainderMap.containsKey(remainder)){
                if(i-remainderMap.get(remainder)>1){
                    return true;
                }
            }else{
                remainderMap.put(remainder,i);
            }
        }
        return false;
    }

//    Brute force approach - using nested loop
    public static boolean checkSubarraySumI(int[] nums, int k) {
        for (int i = 0; i <nums.length-1 ; i++) {
            int sum=nums[i]+nums[i+1];
            if (sum % k == 0) {
                return true;
            }
            for (int j = i+2; j < nums.length; j++) {
                sum+=nums[j];
//                System.out.println("sum : "+sum);
//                System.out.println(Arrays.toString(Arrays.copyOfRange(nums,i,j)));
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums= {23,2,6,4,7};
        int k=6;
        System.out.println(checkSubarraySumI(nums,k));
        System.out.println(checkSubarraySumII(nums,k));
    }
}