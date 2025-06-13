package combinatorics;
import java.util.*;

public class MultiSet{
    public static List<List<Integer>> generateMultiComb(int[] unique, int maxRepeat) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(unique, 0, new ArrayList<>(), result, maxRepeat);
        return result;
    }

    private static void backtrack(int[] unique, int index, List<Integer> current, List<List<Integer>> result, int maxRepeat) {
        if (index == unique.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // for each count of current element (0 to maxRepeat)
        for (int count = 0; count <= maxRepeat; count++) {
            // Add the element count times
            for (int i = 0; i < count; i++) {
                current.add(unique[index]);
            }

            // Recurse to next element
            backtrack(unique, index + 1, current, result, maxRepeat);

            // Backtrack: remove the added elements
            for (int i = 0; i < count; i++) {
                current.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2};
        int maxRepeat = 2; // you can change this as needed
        List<List<Integer>> result = generateMultiComb(input, maxRepeat);

        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}