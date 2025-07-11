package recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {


    public static void generateCombinationsI(int[] nums, int idx, int r, List<Integer> current, List<List<Integer>> combinations) {
        if (r == current.size()) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        if (idx == nums.length) return;

        current.add(nums[idx]);
        generateCombinationsI(nums, idx, r, current, combinations);
        current.removeLast();
        generateCombinationsI(nums, idx + 1, r, current, combinations);

/*
        for (int i = idx; i < nums.length; i++) {
            current.add(nums[i]);
            // if repetition allowed means [ do not increment the idx ]
            generateCombinationsI(nums, i+1 , r, current, combinations);
            current.removeLast();
        }
*/
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[] nums = {1, 2, 3};
        generateCombinationsI(nums, 0, 2, new ArrayList<>(), list);
        System.out.println(list);
    }
}