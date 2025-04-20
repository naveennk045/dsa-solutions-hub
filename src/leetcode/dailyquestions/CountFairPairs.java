package leetcode.dailyquestions;

import java.util.Arrays;

public class CountFairPairs {

//    Binary search
    public static long countFairPairsIII(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int left = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += (right - left);
        }

        return count;
    }
    // Find the first index where nums[index] >= target
    private static int lowerBound(int[] nums, int start, int end, int target) {
        int low = start, high = end + 1;  // end + 1 to handle "not found"
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Find the first index where nums[index] > target
    private static int upperBound(int[] nums, int start, int end, int target) {
        int low = start, high = end + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


//    Two pointer approach + Sorting approach
     public static long countFairPairsII(int[] nums, int lower, int upper) {
         Arrays.sort(nums);
         long count;

         count = countPairsWithSumAtMost(nums, upper) - countPairsWithSumAtMost(nums, lower - 1);
         return count;
    }

    private static long countPairsWithSumAtMost(int[] nums, int maxSum) {
        int left = 0, right = nums.length - 1;
        long count = 0;

        while (left < right) {
            if (nums[left] + nums[right] <= maxSum) {
                // All pairs (left, left+1) to (left, right) are valid
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }


    //    Brute force approach
    public static long countFairPairsI(int[] nums, int lower, int upper) {
        int n = nums.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                if(nums[i]+nums[j]>=lower && nums[i]+nums[j]<=upper) count++;

            }
        }
        return count;

    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int lower = 2;
        int upper = 5;
        System.out.println(countFairPairsI(nums, lower, upper)); // Output: 4
        System.out.println(countFairPairsII(nums, lower,upper)); // Output: 4
        System.out.println(countFairPairsIII(nums,lower,upper));
    }
}