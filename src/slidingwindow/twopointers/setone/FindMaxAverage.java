package slidingwindow.twopointers.setone;
//https://leetcode.com/problems/maximum-average-subarray-i/
public class FindMaxAverage {

    public static double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double maxAvg=sum/k;

        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            maxAvg=Math.max(maxAvg,(sum/k));
        }
        return maxAvg;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};

        System.out.println(findMaxAverage(nums,3));

    }
}