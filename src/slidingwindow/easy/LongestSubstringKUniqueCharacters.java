package slidingwindow.easy;

import java.util.*;

public class LongestSubstringKUniqueCharacters {

    public static int longestKSubstring(String s, int k) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0, maxLength = -1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                if (freqMap.get(leftChar) == 1) {
                    freqMap.remove(leftChar);
                } else {
                    freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                }
                left++;
            }

            if (freqMap.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str="smcmcscandmcbwebsd";
        int k=3;
        System.out.println(longestKSubstring(str,k));
    }
}