package zoho.prep;

public class LongestRepeatingCharacter {


    public static int characterReplacement(String s, int k) {

        int maxFreq = 0;
        int[] freq = new int[256];
        int maxLength = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            freq[currChar]++;
            maxFreq = Math.max(freq[currChar], maxFreq);

            while ((right - left + 1) - maxFreq > k) {
                char outChar = s.charAt(left);
                freq[outChar]--;
                maxFreq = Math.max(freq[outChar], maxFreq);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
