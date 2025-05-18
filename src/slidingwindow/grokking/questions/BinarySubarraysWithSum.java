package slidingwindow.grokking.questions;

public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {

        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }

    public static int countAtMost(int[] nums, int k) {
        int sum = 0, count = 0, n = nums.length;


        for (int right = 0, left = 0; right < n; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));

    }
}