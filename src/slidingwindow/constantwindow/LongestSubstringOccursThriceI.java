package slidingwindow.constantwindow;

import java.util.HashMap;
import java.util.Stack;

public class LongestSubstringOccursThriceI {
    public static int maximumLength(String s) {

        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();

        for (int start = 0; start < n; start++) {

            int end = start;
            while (end < n && s.charAt(start) == s.charAt(end)) {
                end++;
            }

            int length = end - start;

            for (int i = 1; i <= length; i++) {
                for (int j = 0; j <= length - i; j++) {

                    String substring = s.substring(j + start, start + j + i);
                    map.put(substring, map.getOrDefault(substring, 0) + 1);
                    System.out.println(substring);
                }
            }
            System.out.println("du..dudu");
            start=end-1;
        }
        System.out.println(map);
        int maxLength = -1;
        for (String key : map.keySet()) {
            if (map.get(key) >= 3 && key.length() > maxLength) {
                maxLength = key.length();
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maximumLength("\"abcccccdddd\""));
    }
}