package slidingwindow.easy;

import java.util.HashMap;

public class MentalModelForSlidingWindow {

    //    Fixed window
    public static int findMaxSum(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currSum = 0;
        k = k - 1; // for working with index.

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (i >= k) {
                maxValue = Math.max(maxValue, currSum);
                currSum -= nums[i - k];
            }
        }
        return maxValue;
    }

    //    Dynamic window
    public static int findSmallestSubarray(int[] nums, int targetSum) {
        int minLength = Integer.MAX_VALUE;
        int currSum = 0;
        int windowStart = 0;


        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currSum += nums[windowEnd];
            while (currSum >= targetSum) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                currSum -= nums[windowStart++];
            }
        }
        return minLength;
    }


//  Dynamic window + Auxiliary space
    public static int longestSubstring(String str, int k) {
        HashMap<Character, Integer> frqMap = new HashMap<>();

        int maxWindowSize = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowEnd = 0;

        while (windowEnd < str.length()) {
            char incomingChar = str.charAt(windowEnd);
            frqMap.put(incomingChar, frqMap.getOrDefault(incomingChar, 0) + 1);

            while (frqMap.size() > k) {
                char outgoingChar = str.charAt(windowStart);
                frqMap.put(outgoingChar, frqMap.getOrDefault(outgoingChar, 0) - 1);
                if (frqMap.get(outgoingChar) <= 0) {
                    frqMap.remove(outgoingChar);
                }
                windowStart++;
            }


            if (frqMap.size() == k) {
                maxWindowSize = Math.max(maxWindowSize, windowEnd - windowStart + 1);
            }
            windowEnd++;
        }
        return maxWindowSize != Integer.MIN_VALUE ? maxWindowSize : 0;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(findMaxSum(nums, 3));
        System.out.println(findSmallestSubarray(nums, 8));

        String str = "AAAHHIBC";
        System.out.println(longestSubstring(str, 2));
    }
}