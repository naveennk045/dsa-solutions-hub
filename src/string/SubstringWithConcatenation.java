package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
//        System.out.println(allPermutations);

        List<Integer> indices = new ArrayList<>();

        int  right = words.length * words[0].length();
        for (int left = 0 ; right <= s.length(); left++, right++) {

            String curr = s.substring(left,right);
            System.out.println(curr);
            if(allPermutations.contains(curr)){
                indices.add(left);
            }
        }
        return indices;
    }


    public static void main(String[] args) {
        String[] words = {"word","good","best","good"};
        System.out.println(findSubstringI("wordgoodgoodgoodbestword",words));
    }
}