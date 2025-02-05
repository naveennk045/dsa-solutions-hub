package arrays;

import java.util.Arrays;

public class LeftRightDifference {
    public static int[] leftSum(int[] nums){
        int[] res=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            res[i]=sum;
            sum+=nums[i];
        }
        return res;
    }
    public static int[] rightSum(int[] nums){
        int[] res=new int[nums.length];
        int sum=0;
        for(int i=nums.length-1;i>=0;i--){
            res[i]=sum;
            sum+=nums[i];
        }
        return res;
    }
    public static int[] leftRightDifference(int[] nums) {
        int[] leftSum=leftSum(nums);
        int[] rightSum=rightSum(nums);
        System.out.println("Left Sum : "+Arrays.toString(leftSum));
        System.out.println("Right Sum : "+Arrays.toString(rightSum));

        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={1,7,3,6,5,6};
//        System.out.println(Arrays.toString(leftRightDifference(nums)));
        String s="ello";
        System.out.println(s.lastIndexOf('h'));

    }
}