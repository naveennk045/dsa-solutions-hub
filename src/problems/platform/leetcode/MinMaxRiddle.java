package problems.platform.leetcode;

import java.util.Arrays;

public class MinMaxRiddle {
    public static long min(long[] nums , long start,long end){
        long min=Long.MAX_VALUE;
        for(long i=start ; i<end;i++){
            min=Math.min(nums[(int)i],min);
        }
        return min;
    }
    public static long findMaxUsingWindow(long[] nums,long size){
        long left=0,right=size;
        long currMin=min(nums,left,right+1);
        left++;
        right++;
        long prevMin=currMin;
        long max=currMin;

        while(right<nums.length){
            if(prevMin==nums[(int)left-1])
                currMin=min(nums,left,right+1);

            prevMin=currMin;
            if(max<currMin) max=currMin;
            left++;
            right++;
        }

        return max;

    }
    public static void main(String[] args) {
        long[] nums={1,2,3,5,1,13,2};
        long[] list=new long[nums.length];

        for(int i=0;i<nums.length;i++){
            long max=findMaxUsingWindow(nums,i);
            list[i]=max;
        }
        System.out.println(Arrays.toString(list));
    }
}