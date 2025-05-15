package slidingwindow.variablewindow;

import java.util.HashMap;


//  https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
public class MaximumLength {
    public static int maximumLength(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        //  Set K
        int k = n % 3 == 0 ? n / 3 : (n / 3) + 1;

        // find the longest substring with repeating characters with less than or equal to K
        String substring = "";
        int maxLength = -1;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            while (map.size() > 1) {
                map.put(chars[left], map.getOrDefault(chars[left], 0) - 1);
                if (map.get(chars[left]) == 0) map.remove(chars[left]);
                left++;
            }
            int length = right - left + 1;
            if (length <= k) {
                if (maxLength < length) {
                    substring = s.substring(left, right + 1);
                    maxLength = length;
                }
            }
        }

        // count the substring occurs thrice
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i >= maxLength - 1) {
                if (s.substring(i - maxLength + 1, i + 1).equals(substring)) count++;
            }
        }

        System.out.println(substring);
        return (count >= 3) ? maxLength : -1;
    }

    public static void main(String[] args) {
        System.out.println(maximumLength("abcccccdddd"));
    }
}