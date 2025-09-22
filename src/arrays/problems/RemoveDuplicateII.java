package arrays.problems;


import java.util.*;

//    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class RemoveDuplicateII {


    public static void removeDuplicates(int[] nums){
        HashMap<Integer,Integer> frequencyMap=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i],0)+1 );
        }
        
        int j=0;
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            System.out.println(entry.getValue());
            for (int i = 0; i < entry.getValue(); i++) {
                if(i<2 ) {
                    nums[j++]= entry.getKey();
                }
            }
        }

        System.out.println(j);
        System.out.println(frequencyMap);
    }

    public static void main(String[] args) {
        int[] nums={-3,-1,0,0,0,3,3};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}