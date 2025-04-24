package slidingwindow.counting;

//https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
public class SubarraysWithBoundedMax {


    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countSubarrayLessEqual(nums, right) - countSubarrayLessEqual(nums, left - 1);
    }

    public static int countSubarrayLessEqual(int[] nums, int k) {
        int n = nums.length, start = 0, count = 0;
        for (int end = 0; end < n; end++) {
            if (nums[end] > k) {
                start = end + 1;
            } else {
                count += end - start + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 2, 5, 6};
        int res = numSubarrayBoundedMax(nums, 2, 8);
        System.out.println(res);
    }
}