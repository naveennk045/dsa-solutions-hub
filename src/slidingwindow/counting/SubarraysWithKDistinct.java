package slidingwindow.twopointers.setone;

import java.util.HashMap;

public class SubarraysWithKDistinct {

    public static int subarraysWithKDistinct(int[] nums, int k) {

        return countAtMostK(nums, k) - countAtMostK(nums, k - 1);
    }

    private static int countAtMostK(int[] nums, int k) {
        int left = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                if (map.getOrDefault(nums[left], 0) <= 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};

        System.out.println(subarraysWithKDistinct(nums, 2));
    }
}