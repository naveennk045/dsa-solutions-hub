package string;

import java.util.*;

public class SubstringWithConcatenation {

    private static void generatePermutation(String[] words, String curr, HashSet<String> allPermutations, boolean[] used) {
        if (words[0].length() * words.length == curr.length()) {
            allPermutations.add(curr);

        }
        for (int i = 0; i < words.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            generatePermutation(words, curr + words[i], allPermutations, used);
            used[i] = false;
        }
    }

    // Brute force approach
    public static List<Integer> findSubstringI(String s, String[] words) {
        HashSet<String> allPermutations = new HashSet<>();
        generatePermutation(words, "", allPermutations, new boolean[words.length]);

        List<Integer> indices = new ArrayList<>();
        int right = words.length * words[0].length();

        for (int left = 0; right <= s.length(); left++, right++) {

            String curr = s.substring(left, right);
            System.out.println(curr);
            if (allPermutations.contains(curr)) {
                indices.add(left);
            }
        }
        return indices;
    }

    // Optimized approach
    public static List<Integer> findSubstringII(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return indices;

        Map<String, Integer> wordsFreq = new HashMap<>();
        for (String word : words) {
            wordsFreq.put(word, wordsFreq.getOrDefault(word, 0) + 1);
        }

        int wordSize = words[0].length();
        int totalWords = words.length;
        int windowSize = wordSize * totalWords;

        // Try all possible offsets (0 ... wordSize-1)
        for (int offset = 0; offset < wordSize; offset++) {
            int left = offset, count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordSize <= s.length(); right += wordSize) {
                String word = s.substring(right, right + wordSize);

                if (wordsFreq.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // shrink window if word occurs too often
                    while (window.get(word) > wordsFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordSize);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordSize;
                    }

                    // valid window
                    if (count == totalWords) {
                        indices.add(left);
                    }

                } else {
                    // reset window
                    window.clear();
                    count = 0;
                    left = right + wordSize;
                }
            }
        }

        return indices;
    }



    public static void main(String[] args) {
        String[] words = {"bar","foo","the"};
        System.out.println(findSubstringII("barfoofoobarthefoobarman", words));
    }
}