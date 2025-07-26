package recursion.easy;

public class FindMinimumValue {


    public static int findMinI(int[] nums, int idx) {
        if (idx == nums.length) return Integer.MAX_VALUE;

        return Math.min(nums[idx], findMinI(nums, ++idx));
    }

    public static void findMinII(int[] nums, int idx, int[] min) {
        if (idx == nums.length) return;

        min[0] = Math.min(nums[idx], min[0]);

        findMinII(nums, ++idx, min);

    }

    public static int findMinIII(int[] nums, int idx, int min) {
        if (idx == nums.length) return min;

//        min = Math.min(nums[idx], findMinIII(nums, ++idx, min));
//        return min;

//        OR
        min = Math.min(nums[idx], min);
        return findMinIII(nums, ++idx, min);


    }

    public static void findMin(int[] nums) {
        System.out.println(findMinI(nums, 0));
        int[] min = new int[1];
        findMinII(nums, 0, min);
        System.out.println(min[0]);

        System.out.println(findMinIII(nums, 0, Integer.MAX_VALUE));
    }

    public static void main(String[] args) {
        int[] nums = {-10, -83, 83, 1, 2, 0, 8, 99, -100, 55, 87};

        findMin(nums);
    }
}