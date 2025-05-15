package combinatorics.baseform;

import java.util.ArrayList;
import java.util.List;

public class subsequence {


    //    for subsequence order matters
    private static void generateSubsequence(String str, String currentSequence, int index, List<String> subsequences) {
        if (str.length() == index) {
            subsequences.add(currentSequence);
            return;
        }
//        Include the current character
        generateSubsequence(str, currentSequence + str.charAt(index), index + 1, subsequences);

//        Exclude the current character
        generateSubsequence(str, currentSequence, index + 1, subsequences);
    }


    public static void main(String[] args) {
        String str = "abc";
        List<String> subsequences = new ArrayList<>();
        generateSubsequence(str, "", 0, subsequences);
        System.out.println(subsequences);
    }
}