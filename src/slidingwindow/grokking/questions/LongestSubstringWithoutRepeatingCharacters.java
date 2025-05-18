package slidingwindow.grokking.questions;

public class LongestSubstringWithoutRepeatingCharacters {
    //    https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubstring(String str) {
        int[] freqArray = new int[256];
        int maxLen = Integer.MIN_VALUE;
        for (int right = 0, left = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            freqArray[rightChar]++;
            while (freqArray[rightChar] > 1) {
                freqArray[str.charAt(left)]--;
                left++;
            }
            System.out.println(str.substring(left, right + 1));

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}