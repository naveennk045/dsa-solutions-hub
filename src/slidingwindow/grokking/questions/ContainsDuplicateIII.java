package slidingwindow.grokking.questions;

import java.util.HashMap;

public class ContainsDuplicateIII {
//  https://leetcode.com/problems/contains-duplicate-iii/
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=indexDiff){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,1},3,0));
    }
}