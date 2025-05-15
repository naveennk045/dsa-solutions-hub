package combinatorics.baseform;

import java.util.ArrayList;
import java.util.List;

// https://docs.google.com/document/d/1R9kP9_caApgv618i7-giqWCWaIfrOfApCDzYiPEoILo/edit?usp=sharing
public class Subset {
    //    for subset order does not matter
    private static void generateSubsets(char[] set, int index, ArrayList<Character> currentSet, List<List<Character>> subsets) {
        if (index == set.length) {
            subsets.add(new ArrayList<>(currentSet));
            return;
        }
        currentSet.add(set[index]);
        generateSubsets(set, index + 1, currentSet, subsets);

        currentSet.removeLast();
        generateSubsets(set, index + 1, currentSet, subsets);

    }

    public static void main(String[] args) {
        char[] set = "abc".toCharArray();
        List<List<Character>> subsets = new ArrayList<>();
        generateSubsets(set, 0, new ArrayList<>(), subsets);
        System.out.println(subsets);
    }

}