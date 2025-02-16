package slidingwindow.twopointers;

//templates for two pointer and sliding window

public class Basics {

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
    private static int maxSubarraySumVariableSize(int[] nums){
        int  max=0;
        return max;
    }



    public static void main(String[] args) {
        int[] nums={-1,2,3,3,4,5,-1};

        System.out.println(maxSubarraySumFixedSize(nums,4));
    }


}