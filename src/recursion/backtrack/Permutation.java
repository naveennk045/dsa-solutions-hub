package recursion.backtrack;

import sorting.Swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void generatePermutation(int[] nums, int idx, List<int[]> permutation) {
        if (idx == nums.length) {
            permutation.add(Arrays.copyOf(nums, nums.length));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            Swap.swap(nums, i, idx);
            generatePermutation(nums, idx + 1, permutation);
            Swap.swap(nums, i, idx);
        }
    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int[] nums = {1, 2, 3};
        generatePermutation(nums, 0, list);
        for (int[] permutation : list) {
            System.out.println(Arrays.toString(permutation));
        }
    }
}