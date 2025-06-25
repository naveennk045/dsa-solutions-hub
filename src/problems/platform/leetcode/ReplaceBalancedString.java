package problems.platform.leetcode;

public class ReplaceBalancedString {
    public static int balancedString(String s) {
        int strLength = s.length();
        int minLength = strLength;
        String characters = "QWER";
        int[] count = new int[4];
        for (char ch : s.toCharArray()) {
            count[characters.indexOf(ch)]++;
        }
        int expectedCount = s.length() / 4;
        if (count[0] == expectedCount && count[1] == expectedCount && count[2] == expectedCount && count[3] == expectedCount)
            return 0;

        for (int right = 0, left = 0; right < strLength; right++) {
            count[characters.indexOf(s.charAt(right))]--;

            while (left <= right && count[0] <= expectedCount && count[1] <= expectedCount && count[2] <= expectedCount && count[3] <= expectedCount) {
                count[characters.indexOf(s.charAt(left))]++;
                minLength = Math.min(minLength, right - left + 1);
                left++;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        String s = "QQEERRWWQQ";
        System.out.println(balancedString(s));
    }
}