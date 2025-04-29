package sumCombos;

import java.util.*;

public class FourSum {


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> quadrads = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < n; j++) {
                if(j>i+1 && nums[j-1]==nums[j]) continue;
//                System.out.println("I am here.......");
                long requiredSum = target - (long) (nums[i] + nums[j]);
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
//                    System.out.println("I am here...........");
                    long sum = nums[left] + nums[right];

                    if (sum > requiredSum) right--;
                    else if (sum < requiredSum) left++;
                    else {
                        quadrads.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return quadrads;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(fourSum(nums, 8));

    }
}