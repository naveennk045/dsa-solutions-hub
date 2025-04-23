package slidingwindow.counting;

import java.util.Arrays;
import java.util.HashSet;



public class CountCompleteSubarrays {
    public static int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
       return  countAtMostK(nums,set.size())-countAtMostK(nums,set.size()-1);

    }

    private static int countAtMostK(int[] nums, int k) {
        int[] frequencyMap = new int[2001];
        int distinctCount=0 , globalCount=0 ,left=0;
        for (int right = 0; right < nums.length; right++) {
            distinctCount+=(frequencyMap[nums[right]]==0) ? 1 : 0;
            frequencyMap[nums[right]]++;


            while(distinctCount>k){
                frequencyMap[nums[left]]--;
                distinctCount-=(frequencyMap[nums[left]]==0) ? 1 : 0;
                left++;
            }
            globalCount+=right-left+1;

        }
        return globalCount;
    }




    public static void main(String[] args) {
        int[] nums = {5,5,5,5};
        System.out.println(countCompleteSubarrays(nums));
    }
}