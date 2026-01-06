package training;

import java.util.Set;
import java.util.TreeSet;

public class EncryptedFile {

    public static void generatePermutationsWithDuplicates(char[] chars, int k, String currPerm, Set<String> permutations) {


        if (currPerm.length() == k) {
            String original = new String(chars);
            if(currPerm.compareTo(original) > 0){
                permutations.add(currPerm);
            }
            return;
        }

        for (char aChar : chars) {

            generatePermutationsWithDuplicates(chars, k, currPerm + aChar, permutations);
        }

    }

    static void main() {
        Set<String> allPermutations = new TreeSet<>();
        generatePermutationsWithDuplicates("abc".toCharArray(), 3,"", allPermutations);
        for(String permutation : allPermutations){
            System.out.println(permutation);
            return;
        }
    }
}
