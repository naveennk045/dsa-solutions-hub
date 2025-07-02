package problems.platform.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
The Longest Bitonic Subarray (LBS) problem is to find a contiguous subarray of a given sequence in which the subarray’s elements are first sorted in increasing order, then in decreasing order, and the subarray is as long as possible.

Input : [3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4]
Output: [4, 5, 9, 10, 8, 5, 3]

In case the multiple bitonic subarrays of maximum length exists, the solution can return any one of them.

Input : [-5, -1, 0, 2, 1, 6, 5, 4, 2]
Output: [-5, -1, 0, 2, 1] or [1, 6, 5, 4, 2]

        */
public class LongestBitonicSubarray {
    public static int findSequence(List<Integer> nums, int start) {
        int size = nums.size();

        while (start + 1 < size && nums.get(start) < nums.get(start + 1)) start++;
        while (start + 1 < size && nums.get(start) > nums.get(start + 1)) start++;

        return start;
    }

    public static List<Integer> findBitonicSubarray(List<Integer> nums) {
        List<Integer> ans = new ArrayList<>();

        for (int start = 0; start < nums.size() - 1; start++) {
            int end = findSequence(nums, start);

            if (ans.size() <= end - start + 1) {
                ans.clear();
                for (int i = start; i < nums.size() && i <= end; i++) {
                    ans.add(nums.get(i));
                }
            }
//            System.out.println(ans);
            start = end - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-5);
        list.add(-1);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(2);

        System.out.println(findBitonicSubarray(list));
    }
}