package arrays.problems;

public class CountSubarrayWithFixedBound {


    public static long countSubarraysHavingMin(int[] nums, int target) {
//        int minIdx = -1;
        int minVal = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= minVal) {
//                minIdx = i;
                minVal = nums[i];
                count += nums.length - i;
            }
        }
        return count;
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
//        System.out.println(countSubarraysHavingMin(nums,minK));
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}