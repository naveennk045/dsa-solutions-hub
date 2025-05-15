package slidingwindow.grokking.questions;

public class LongestRepeatingCharacterReplacement {
    //    https://leetcode.com/problems/longest-repeating-character-replacement/
    public static int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int n = s.length();
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);
            count[ch - 'A']++;
            maxCount = Math.max(maxCount, count[ch - 'A']);

            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AAABAESCS", 3));
    }
}