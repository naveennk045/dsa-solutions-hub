package slidingwindow.level1;

//templates for two pointer and sliding window

import java.util.Arrays;

public class Problems {

//    Constant Window
    public static int maxSubarraySumFixedSize(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int max=sum;
        int left=0;
        int right=k-1;

        while(right < nums.length-1){
            sum-=nums[left];
            left++;
            right++;
            sum+=nums[right];
            max=Math.max(sum,max);
        }

        return max;
    }

//    Variable window
    private static int maxSubarraySumVariableSize(int[] nums,int target){
        int left=0;
        int sum=0;
        int max=sum;

        for(int right=0; right<nums.length;right++){
            sum+=nums[right];

            while(sum>target){
                sum-=nums[left++];
            }
            max=Math.max(max,sum);
        }
        return max;
    }
//   https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
    public static int maxScore(int[] nums, int k) {

        int right=nums.length-1;

        int leftSum=0;
        int rightSum=0;

        for(int i=0;i<k;i++ ){
            leftSum+=nums[i];
        }

        int maxSum=leftSum;


        for(int i=k-1 ; i>=0 ; i--){
            rightSum+=nums[right--];
            leftSum-=nums[i];
            int sum=leftSum+rightSum;
            // System.out.print("L : "+leftSum+" ");
            // System.out.println("R : "+rightSum);
            maxSum=Math.max(maxSum,sum);
        }

        return maxSum;

    }

    public static int lengthOfLongestSubstring(String str) {

        int maxLength=0;
        int left=0;
        int right=0;
        int[] ascii =new int[256];
        Arrays.fill(ascii,-1);
        while(right<str.length()){

            char ch= str.charAt(right);

            if(ascii[ch]>left && ascii[ch]!=-1){
                left=ascii[ch]+1;
            }

            int length=right-left+1;
            maxLength=Math.max(maxLength,length);
            right++;

            ascii[ch]=right;
        }
        return maxLength;

    }


    public static void main(String[] args) {
        int[] nums={9,7,7,9,7,7,9};

        System.out.println(maxSubarraySumFixedSize(nums,4));
        System.out.println(maxSubarraySumVariableSize(nums,8));
        System.out.println(maxScore(nums,7));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }


}