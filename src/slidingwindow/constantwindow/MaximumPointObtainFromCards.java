package slidingwindow.constantwindow;

public class MaximumPointObtainFromCards {
    public static int maxScore(int[] nums, int k) {
        // code here.
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
            maxSum=Math.max(maxSum,sum);
        }

        return maxSum;

    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,2,5,1,98,7,6},5));
    }
}