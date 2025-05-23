package problems.platform.leetcode;

public class CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] frequency = new int[26];

        for (char ch : ransomNote.toCharArray()) {
            frequency[ch - 'a']++;
        }
        for (char ch : magazine.toCharArray()) {
            frequency[ch - 'a']--;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (frequency[ch - 'a'] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aab", "baa"));

    }
}