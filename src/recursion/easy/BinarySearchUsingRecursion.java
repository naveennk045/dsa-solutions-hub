package recursion.easy;

public class BinarySearchUsingRecursion {


    private static boolean searchHelper(int[] nums, int target, int start, int end) {
        if (start >= end) return false;

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) return true;

        if (nums[mid] > target) {
            return searchHelper(nums, target, 0, mid);
        }
        return searchHelper(nums, target, mid + 1, end);

    }

    public static boolean search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        if (search(nums, 8)) {
            System.out.println("Element found ....");
        } else {
            System.out.println("Element not found ...");
        }
    }
}