package leetcode;

import java.util.Arrays;

public class HouseRobberI {
    public static int rob(int[] nums) {
        if(nums.length<4) {
            return max(nums, 0, nums.length);
        }
        int max=0;
        int p1=0,p2=2;
        while(p2<nums.length){
            int ind=max(nums,p1,p2+1);
            max+=nums[ind];
            System.out.println(max);

//            Arrays.stream(nums, p1, p2).forEach(x -> System.out.print(x + " "));
//            System.out.println();

            p1+=ind+2;
            p2=p1+2;

        }
//        System.out.println(p1-1);
        if(p1-1<nums.length)
            max+=nums[max(nums,p1-1,nums.length)];
        return max;
    }

    public static int max(int[] nums, int start, int end) {
        int max=nums[start];
        int maxInd=start++;
        for(;start<end;start++){
            if(max<nums[start]){
                maxInd=start;
            }
        }
        return maxInd;
    }

    public static void main(String[] args) {
//        int[] nums={2,3,1,5,7,2,9,10};
        int[] nums={2,3,1,5,7,2,9,10};
//        int[] nums={1,2,3,1};
        int ans=rob(nums);
        System.out.println(ans);
    }
}