package slidingwindow.counting;

public class CountSubArraySumLessK {
    public static long countSubarrays(int[] nums, long k) {

        int left = 0;
        long count = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        System.out.println(countSubarrays(nums, 10));
    }
}