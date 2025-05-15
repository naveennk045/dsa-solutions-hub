package slidingwindow.grokking.questions;

//https://leetcode.com/problems/minimum-window-substring/description/

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {


        HashMap<Character, Integer> targetFrequency = new HashMap<>();
        HashMap<Character, Integer> windowFrequency = new HashMap<>();

        int minLength = Integer.MAX_VALUE;

        for (char ch : t.toCharArray()) {
            targetFrequency.put(ch, targetFrequency.getOrDefault(ch, 0) + 1);
        }
        int need = targetFrequency.size();
        int have = 0;
        int left = 0;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowFrequency.put(rightChar, windowFrequency.getOrDefault(rightChar, 0) + 1);

            if (targetFrequency.containsKey(rightChar) && windowFrequency.get(rightChar).intValue() == targetFrequency.get(rightChar).intValue())
                have++;

            while (have == need) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                windowFrequency.put(leftChar, windowFrequency.getOrDefault(leftChar, 0) - 1);

                if (targetFrequency.containsKey(leftChar) && windowFrequency.get(leftChar) < targetFrequency.get(leftChar))
                    have--;

                left++;
            }
        }
        System.out.println(minLength);

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);


    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}