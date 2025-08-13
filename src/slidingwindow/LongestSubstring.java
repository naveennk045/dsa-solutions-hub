package slidingwindow;

import java.util.HashMap;

public class LongestSubstring {

    public static int longestSubstring(String s, int k) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        int maxLength = 0;
        int checker = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {

            char incomingChar = s.charAt(right);
            int currCharFreq = freqMap.getOrDefault(incomingChar, 0) + 1;
            freqMap.put(incomingChar, currCharFreq);

            System.out.println(freqMap);
            if (currCharFreq == k) checker++;

            if (checker >= freqMap.size()) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aabbb",3));
    }
}