package slidingwindow.easy;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroCount = 0;
        int maxLength = 0;
        while (right < nums.length) {
            if (nums[right] == 0) zeroCount++;
            if (zeroCount <= k) maxLength = Math.max(maxLength, right - left + 1);
            else {
                while (nums[left] != 0) left++;
                left++;
                zeroCount--;
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,5,6,8,9};

        System.out.println(longestOnes(nums,4));
    }
}