package solvedproblems.platform.leetcode;

//https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/

import java.util.HashMap;
import java.util.Map;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public static int maxDifference(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int count=map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), count);
        }

        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();

            if (count % 2 == 0)
                minEven=Math.min(count,minEven);
            else
                maxOdd=Math.max(count,maxOdd);
        }
        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        String str="aaaaaaaaaacccccccddddddeeeeeeeeeeeww";
        System.out.println("The max difference : "+maxDifference(str));
    }
}