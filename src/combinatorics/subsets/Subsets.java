package combinatorics.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void generateSubset(int[] nums, int
            index, List<Integer> current, List<List<Integer>> subsets) {

        if (index == nums.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);

        generateSubset(nums, index + 1, current, subsets);

        current.removeLast();
        generateSubset(nums, index + 1, current, subsets);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubset(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    public static void main(String[] args) {

    }
}