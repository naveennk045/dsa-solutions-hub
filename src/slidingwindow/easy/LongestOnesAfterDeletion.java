package slidingwindow.easy;

public class LongestOnesAfterDeletion {
    public static int longestSubarray(int[] nums) {
        int size = nums.length;
        int left = 0, right = 0;
        int zeroCount = 0, maxSize = -1;

        while (right < size) {

            if (nums[right] == 0) zeroCount++;

            while(zeroCount>1){
                if(nums[left]==0) zeroCount--;
                left++;
            }

            maxSize = Math.max(maxSize, right - left );

            right++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(nums));
    }
}