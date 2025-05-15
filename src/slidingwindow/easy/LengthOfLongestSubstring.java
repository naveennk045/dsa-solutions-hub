package slidingwindow.easy;


import java.util.Arrays;
import java.util.HashMap;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstringI(String str) {

        HashMap<Character, Integer> frqMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            frqMap.put(str.charAt(right), frqMap.getOrDefault(str.charAt(right), 0) + 1);

            while (frqMap.get(str.charAt(right)) > 1) {
                if (frqMap.getOrDefault(str.charAt(left), 0) <= 0) {
                    frqMap.remove(str.charAt(left));
                } else {
                    frqMap.put(str.charAt(left), frqMap.getOrDefault(str.charAt(left), 0) - 1);

                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringII(String str) {

        int maxLength = 0;
        int left = 0;
        int right = 0;
        int[] ascii = new int[256];
        Arrays.fill(ascii, -1);
        while (right < str.length()) {

            char ch = str.charAt(right);

            if (ascii[ch] > left && ascii[ch] != -1) {
                left = ascii[ch];
            }

            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
            right++;

            ascii[ch] = right;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstringI(str));
        System.out.println(lengthOfLongestSubstringII(str));

    }
}