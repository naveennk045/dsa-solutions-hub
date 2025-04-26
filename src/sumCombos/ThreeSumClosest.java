package sumCombos;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosestII(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];
        int left, right, sum, diff;

        for (int i = 0; i < n - 1; i++) {
            left = i + 1;
            right = n - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                diff = Math.abs(target - sum);

                if (diff < Math.abs(closestSum - target))
                    closestSum = sum;

                if (target < sum) right--;
                else if (target > sum) left++;
                else return sum;
            }
        }
        return closestSum;
    }


    // This is my brute force approach for this problem using hash set n3
    public static int threeSumClosestI(int[] nums, int target) {
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // initialize to first triplet

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
        int[] nums = {-84,92,26,19,-7,9,42,-51,8,30,-100,-13,-38};
        System.out.println(threeSumClosestI(nums,1));
        System.out.println(threeSumClosestII(nums,78));
    }
}