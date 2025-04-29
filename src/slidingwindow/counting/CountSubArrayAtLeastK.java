package slidingwindow.counting;

public class CountSubArrayAtLeastK {
    public static long countSubarrays(int[] nums, int k) {
        int max = -1;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return countAtLeast(nums, k, max);

    }

    private static long countAtLeast(int[] nums, int k, int max) {
        int n = nums.length, left = 0, maxCount = 0, count = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) maxCount++;
            while (maxCount >= k) {
                if (nums[left] == max) maxCount--;
                count += n - right;
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 3};
        System.out.println(countSubarrays(nums, 2));
    }
}