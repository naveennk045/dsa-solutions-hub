package arrays.problems;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr={1,2,-1,3,4};
        System.out.println(maxSubArray1(arr));
        System.out.println(maxSubArray2(arr));
    }
// Bruteforce Approach

    public static int maxSubArray1(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(max<sum){
                    max=sum;
                }
            }
        }
        return max;
    }

//    Optimal Approach
    public static int maxSubArray2(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            sum+=num;
            if(max<sum){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }

        }
        return max;
    }
}