package slidingwindow.twopointers;

public class MaxVowelsInWindow {
    public static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public static int maxVowels(String s, int k) {
        int n = s.length();
        int windowCount = 0, maxCount = 0;

        for (int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) windowCount++;
        }
        maxCount = windowCount;

        for (int right = k; right <n ; right++) {
            int left = right-k;

            if (isVowel(s.charAt(left))) windowCount--;
            if (isVowel(s.charAt(right))) windowCount++;

            maxCount = Math.max(windowCount,maxCount);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        String str="abciiidef";
        int k=3;

        System.out.println(maxVowels(str,k));
    }
}