package slidingwindow.grokking.questions;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
//https://leetcode.com/problems/sliding-subarray-beauty/
public class SlidingSubarrayBeauty {
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0)
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i >= k - 1) {
                result[i - k + 1] = getKthSmallest(map, x);
                map.put(nums[i - k + 1], map.getOrDefault(nums[i - k + 1], 0) - 1);
                if (map.get(nums[i - k + 1]) == 0) map.remove(nums[i - k + 1]);
            }
            System.out.println(map);

        }
        return result;
    }

    public static int getKthSmallest(TreeMap<Integer, Integer> map, int k) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (k <= freq) {
                return entry.getKey();
            } else {
                k -= freq;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2)));
    }
}