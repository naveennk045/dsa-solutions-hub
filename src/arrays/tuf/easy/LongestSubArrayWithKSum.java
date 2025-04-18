package arrays.tuf.easy;

import java.util.HashMap;

public class LongestSubArrayWithKSum {
//    if it has only positive numbers means two pointers and sliding window is effective but here the array has both positive numbers and negative numbers
    public static int longestSubarray(int[] arr, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum=0;
        int maxLength=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];

            if(prefixSum==k){
                maxLength=Math.max(maxLength,i);
            }
            int remainder=prefixSum-k;

            if(map.containsKey(remainder)){
                int length=i-map.get(remainder);
                maxLength=Math.max(length,maxLength);
            }
            map.put(prefixSum,i);
        }
        return maxLength==Integer.MIN_VALUE ? 0 : maxLength;
    }
    public static void main(String[] args) {

    }
}