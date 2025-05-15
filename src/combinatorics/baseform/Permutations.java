package combinatorics.baseform;

import sorting.Swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutations {

//    Permutations: Order matters, every possible arrangement is considered.

    public static void permutate(int[] nums, int fixedIndex, List<int[]> permutations){
        if(fixedIndex==nums.length){
            permutations.add(nums.clone());
        }

            for (int index = fixedIndex; index <nums.length ; index++) {
                Swap.swap(nums,fixedIndex,index);
                permutate(nums,fixedIndex+1,permutations);
                Swap.swap(nums,fixedIndex,index);
            }
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<int[]> permutations=new ArrayList<>();
        permutate(nums,0,permutations);

        for (int[] permutation : permutations){
            System.out.println(Arrays.toString(permutation));
        }

    }
}