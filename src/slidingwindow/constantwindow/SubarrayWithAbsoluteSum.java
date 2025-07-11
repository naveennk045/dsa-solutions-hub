package slidingwindow.constantwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.TreeMap;


public class SubarrayWithAbsoluteSum {

    public static int findMinIndex(int[] nums, int start, int end) {
        int minInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[start] < nums[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }

    public static int findMaxIndex(int[] nums, int start, int end) {
        int maxInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[start] > nums[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    // Attempted sliding window without using proper data structures (like TreeMap or Deque).
    // Since we manually search for min/max when needed, it results in O(N^2) time complexity,
    // which is actually worse than the brute-force nested loop. Funny but true 😅
    public static int longestSubarrayI(int[] nums, int limit) {
        int maxLength = Integer.MIN_VALUE;
        int minInd = 0, maxInd = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] > nums[maxInd]) {
                maxInd = right;
            }
            if (nums[right] < nums[minInd]) {
                minInd = right;
            }
//            int diff = nums[maxInd] - nums[minInd];
//            System.out.println(diff);
            while (left < right && nums[maxInd] - nums[minInd] > limit) {
                if (minInd == left && maxInd == left) {
                    left++;
                    minInd = findMinIndex(nums, left, right);
                    maxInd = findMaxIndex(nums, left, right);
                } else if (minInd == left) {
                    left++;
                    minInd = findMinIndex(nums, left, right);
                } else if (maxInd == left) {
                    left++;
                    maxInd = findMaxIndex(nums, left, right);
                }
            }
            if (nums[maxInd] - nums[minInd] <= limit) {
                maxLength = Math.max(maxLength, right - left + 1);

            }
            right++;
        }
        return maxLength;

    }

    //  Using Sliding window +  tree map
    public static int longestSubarrayII(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int windowStart = 0, windowEnd = 0;
        int maxWindowSize = Integer.MIN_VALUE;


        while (windowEnd < nums.length) {
            treeMap.put(nums[windowEnd], treeMap.getOrDefault(nums[windowEnd], 0) + 1);
            while ((treeMap.lastKey() - treeMap.firstKey()) > limit) {
                treeMap.put(nums[windowStart], treeMap.getOrDefault(nums[windowStart], 0) - 1);
                if (treeMap.get(nums[windowStart]) <= 0) {
                    treeMap.remove(nums[windowStart]);
                }
                windowStart++;
            }

            maxWindowSize = Math.max(maxWindowSize, windowEnd - windowStart + 1);

            windowEnd++;
        }
        return maxWindowSize;
    }

    //   Using dequeue + Sliding window
    public static int longestSubarrayIII(int[] nums, int limit) {

        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();

        int left =0 ;
        int maxWindowSize=Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {

            while(!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[right]){
                minQueue.pollLast();
            }
            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[right]){
                maxQueue.pollLast();
            }
            minQueue.offerLast(right);
            maxQueue.offerLast(right);

            while (!minQueue.isEmpty() && !maxQueue.isEmpty() &&
                    (nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit)) {

                if (minQueue.peekFirst() == left) minQueue.pollFirst();
                if (!maxQueue.isEmpty() && maxQueue.peekFirst() == left) maxQueue.pollFirst();
                left++;
            }
            maxWindowSize=Math.max(right-left+1,maxWindowSize);
        }
        return maxWindowSize;
    }



    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 4, 7, 2};

        System.out.println(longestSubarrayI(nums, 5));
        System.out.println(longestSubarrayII(nums, 5));
        System.out.println(longestSubarrayIII(nums,5));
        System.out.println(7.0/2);

        Scanner scanner = new Scanner(System.in);
    }
}