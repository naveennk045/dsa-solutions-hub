package arrays.problems;

import java.util.Arrays;
import java.util.HashMap;

public class LongestHarmonicSubsequence {

    // Approach on 1 is o(n*log n) , I have used sorting and then sliding window approach
    public static int findLHSI(int[] nums) {

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int j = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] - nums[j] > 1) j++;
            if (nums[i] - nums[j] == 1) maxLength = Math.max(maxLength, i - j + 1);

        }
        return maxLength;
    }

    // approach 2 is O (log n), I have used hashmap frequency based approach
    public static int findLHSII(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        System.out.println(freqMap);
        int maxLength = 0;

        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {

                int currLength = freqMap.get(key) + freqMap.get(key + 1);
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHSI(nums));
        System.out.println(findLHSII(nums));

    }
}
