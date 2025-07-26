package recursion.easy;


public class SumOfTriangle {
    public static void sumOfTriangle(int[] nums, int p1, int p2) {
        if (p1 == 0) return;

        if (p2 < p1) {
            nums[p2] = nums[p2] + nums[p2 + 1];
            sumOfTriangle(nums, p1, ++p2);
            return;
        }
        System.out.println(nums[p1]);
        sumOfTriangle(nums, --p1, 0);
    }

    public static int sumOfTriangle(int[] nums) {
        sumOfTriangle(nums, nums.length - 1, 0);
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sumOfTriangle(nums));
    }
}