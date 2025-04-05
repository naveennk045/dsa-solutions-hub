package slidingwindow.twopointers.constantwindow;

import java.util.HashMap;
import java.util.LinkedHashMap;


//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

    public class MaxSumSubarraySizeK {


    public static long maximumSubarraySum(int[] nums, int k) {

        int n=nums.length;
        int left=0 , right=0;
        long maxSum=0;

        // Sum the initial window numbers
        long sum = 0;
        for (; right < k; right++){
            sum+= nums[right];
        }

        // Adding initial window values for frequency mapping
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < k; i++){
            int  count = map.getOrDefault(nums[i],0) + 1;
            map.put(nums[i],count);
        }

        if (map.size() ==k ) {
            maxSum = Math.max(sum,maxSum);
        }

        while(right<n){

            sum-= nums[left];
            sum+= nums[right];

            int count = map.getOrDefault(nums[right],0)+1;
            map.put(nums[right],count);

            if(map.containsKey(nums[left])){
                int frq = map.get(nums[left])-1;
                map.put(nums[left],frq);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
            }
            if(map.size() == k){
                maxSum = Math.max(maxSum,sum);
            }
            left++;
            right++;
        }
        return maxSum;
    }
    public static void main(String[] args) {

        int[] nums={1,58,858,8,5,5,8,1,3,2};

        System.out.println(maximumSubarraySum(nums,4));
    }
}