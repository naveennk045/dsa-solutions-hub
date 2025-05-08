package level1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/keyboard-row/description/
public class KeyBoardRow {

    public static String[] findWords(String[] words) {
        int[] rows = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

        List<String> typedWords = new ArrayList<>();
        for (String word : words) {
            boolean isTyped = true;

            for (int i = 1; i < word.length(); i++) {
                char ch1 = word.charAt(i);
                char ch2 = word.charAt(i - 1);

                if (ch1 >= 'A' && ch1 <= 'Z') {
                    ch1 = (char) (ch1 + 32);
                }
                if (ch2 >= 'A' && ch2 <= 'Z') {
                    ch2 = (char) (ch2 + 32);
                }
                if (rows[ch1 - 'a'] != rows[ch2 - 'a']) {
                    isTyped = false;
                    break;
                }
            }
            if (isTyped) typedWords.add(word);
        }

        String[] ans = new String[typedWords.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = typedWords.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}