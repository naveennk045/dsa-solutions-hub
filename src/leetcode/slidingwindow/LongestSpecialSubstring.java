package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSpecialSubstring {

    public static int maximumLengthV1(String s) {

        HashMap<String, Integer> freqMap = new HashMap<>();
        HashSet<Character> set;

        for (int i = 0; i < s.length(); i++) {
            set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {

                set.add(s.charAt(j));
                String currSubstring = s.substring(i, j + 1);

                if (set.size() == 1)
                    freqMap.put(currSubstring, freqMap.getOrDefault(currSubstring, 0) + 1);
                    // System.out.println(s.substring(i, j));
            }
        }

        int maxLength = -1;
        for (String substring : freqMap.keySet()) {
            if (freqMap.get(substring) >= 3 && substring.length() > maxLength)
                maxLength = substring.length();
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcdabcddddabcddddccccbbbbaaaa";
        System.out.println(maximumLengthV1(str));
    }
}
