package combinatorics.baseform;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

//    Combinations: Order doesn’t matter, only selection of elements.

    public static void combine(int[] nums, List<Integer> current, int index, int r, List<List<Integer>> combinations) {
        if (current.size() == r) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            combine(nums, current, i + 1, r, combinations);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> combinations = new ArrayList<>();

        combine(nums, new ArrayList<>(), 0, 4, combinations);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}