package sumCombos;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;


public class ThreeSum {

    public static void twoSum(List<List<Integer>> triplets, int[] nums, int left, int right, int target) {
        int sum;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else {
                triplets.add(Arrays.asList(-target, nums[left], nums[right]));

                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            }
        }
    }

    //    Approach two using two pointer and sorting
    public static List<List<Integer>> threeSumII(int[] nums) {

        int n = nums.length;
        List<List<Integer>> triplets = new ArrayList<>();
        int left, right, target;

        // Step - 1 : Sort the array
        Arrays.sort(nums);
        // Step - 2 : Traverse the array for finding second and third using the first element
        for (int i = 0; i < n - 1; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;  // skip the duplicates
            // Step - 3 ; Find the second and third  element using the two sum technique in sorted array;
            left = i + 1;
            right = n - 1;
            target = -(nums[i]);

            twoSum(triplets, nums, left, right, target);

        }
        return triplets;
    }

    //    Approach one using hashset and nested loops
    public static List<List<Integer>> threeSumI(int[] nums) {
        int n = nums.length;

        HashSet<List<Integer>> tripletSet = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> hashSet = new HashSet<>();   // for O(1) look up
            for (int j = i + 1; j < n; j++) {
                int thirdNum = -(nums[i] + nums[j]);
//                Lookup the third value in set
                if (hashSet.contains(thirdNum)) {
                    List<Integer> currTriplet = new ArrayList<>();
                    currTriplet.add(nums[i]);
                    currTriplet.add(nums[j]);
                    currTriplet.add(thirdNum);
//                   Sort + add into set
                    Collections.sort(currTriplet);
                    tripletSet.add(currTriplet);
                }
                hashSet.add(nums[j]);
            }
        }
        return new ArrayList<>(tripletSet);
    }


    public static void main(String[] args) {
        int[] nums = {2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10};

        System.out.println(threeSumI(nums));
        System.out.println(threeSumII(nums));
    }
}