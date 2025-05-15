package slidingwindow.grokking.questions;

public class MinimumWindowSubsequence {

    public static String minWindow(String S, String T) {
        int[] tFrequency = new int[128];

        for (char ch : T.toCharArray()) {
            tFrequency[ch]++;
        }

        int[] minWindow = {0, Integer.MAX_VALUE};
        char[] sourceArray = S.toCharArray();
        int count = 0, total = T.length();

        for (int right = 0, left = 0; right < S.length(); right++) {

            if (tFrequency[sourceArray[right]]-- > 0)
                count++;

            while (count == total) {
                if (!isSubsequence(S.substring(left, right + 1), T)) break;
                if (right - left < minWindow[1] - minWindow[0]) {
                    minWindow[0] = left;
                    minWindow[1] = right;
                }
                if (tFrequency[sourceArray[left]] == 0)
                    count--;

                tFrequency[sourceArray[left]]++;
                left++;
            }
        }
        return minWindow[1] == Integer.MAX_VALUE ? "" : S.substring(minWindow[0], minWindow[1] + 1);
    }

    public static boolean isSubsequence(String source, String target) {

        int s = 0, t = 0;
        while (s < source.length() && t < target.length()) {
            if (source.charAt(s) == target.charAt(t)) t++;
            s++;
        }
        System.out.println(source + " " + target);
        return t == target.length();
    }

    public static void main(String[] args) {
        System.out.println(minWindow("forever", "ove"));
    }
}