package level1;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicateII(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]==nums[i]) return true;
        }
        return false;
    }
        public static boolean containsDuplicateI(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() == nums.length;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 5, 5, 5, 5, 3, 2, 3, 4, 3, 2};
        System.out.println(containsDuplicateI(nums));
    }
}