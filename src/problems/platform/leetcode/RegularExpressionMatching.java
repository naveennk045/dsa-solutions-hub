package problems.platform.leetcode;

public class RegularExpressionMatching {
    //https://leetcode.com/problems/regular-expression-matching/description/
    public static boolean isMatch(String s, String p) {
        int p1 = 0, p2 = 0;

        while (p1 < s.length() && p2 < p.length()) {
            if (p.charAt(p2) == '*') return true;
            if (s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '.') {
                p1++;
                p2++;
            } else return false;
        }
        return p1 == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a."));
    }
}