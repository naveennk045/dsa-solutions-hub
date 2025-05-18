package slidingwindow.grokking.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
    //    https://leetcode.com/problems/repeated-dna-sequences/description/
    public static List<String> findRepeatedDnaSequences(String s) {

        HashMap<String, Integer> frequencyMap = new HashMap<>();
        List<String> repeatedDNASequence = new ArrayList<>();

        int left = 0;
        for (int right = 10; right < s.length() + 1; right++) {

            String substring = s.substring(left, right);
            frequencyMap.put(substring, frequencyMap.getOrDefault(substring, 0) + 1);
            left++;

        }

        for (String DNA : frequencyMap.keySet()) {
            if (frequencyMap.get(DNA) > 1) repeatedDNASequence.add(DNA);
        }
        return repeatedDNASequence;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}