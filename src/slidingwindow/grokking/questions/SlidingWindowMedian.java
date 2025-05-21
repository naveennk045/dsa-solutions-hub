package slidingwindow.grokking.questions;

import java.util.*;

//https://leetcode.com/problems/sliding-window-median/
public class SlidingWindowMedian {
    // using min and max heap
    public static double[] medianSlidingWindowII(int[] nums, int k) {

        int n = nums.length;
        double[] medians = new double[n - k + 1];

        PriorityQueue<Integer> smallHalf = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        PriorityQueue<Integer> largeHalf = new PriorityQueue<>(); // min heap
        HashMap<Integer, Integer> tracker = new HashMap<>();

        for (int i = 0; i < k; i++) {
            smallHalf.offer(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            largeHalf.offer(smallHalf.poll());
        }

        int balance = 0;
        int index = 0;

        for (int i = k; i < n; i++) {

            medians[index++] = getMedian(smallHalf, largeHalf, k);

            int incomingValue = nums[i];
            int outgoingValue = nums[i - k];

            // for lazy removal
            tracker.put(outgoingValue, tracker.getOrDefault(outgoingValue, 0) + 1);
            balance += (!smallHalf.isEmpty() && outgoingValue <= smallHalf.peek()) ? -1 : 1;

            // Adding the element
            if (!smallHalf.isEmpty() && incomingValue > smallHalf.peek()) {
                largeHalf.offer(incomingValue);
                balance--;
            } else {
                smallHalf.offer(incomingValue);
                balance++;
            }

            // balancing the heaps
            if (balance < 0) {
                smallHalf.offer(largeHalf.poll());
            } else if (balance > 0) {
                largeHalf.offer(smallHalf.poll());
            }
            balance = 0;
            lazyRemoval(smallHalf, tracker);
            lazyRemoval(largeHalf, tracker);
        }
        medians[index] = getMedian(smallHalf, largeHalf, k);

        return medians;
    }

    private static void lazyRemoval(PriorityQueue<Integer> heap, HashMap<Integer, Integer> tracker) {
        while (!heap.isEmpty() && tracker.getOrDefault(heap.peek(), 0) > 0) {
            tracker.put(heap.peek(), tracker.getOrDefault(heap.peek(), 0) - 1);
            heap.poll();
        }
    }
    private static double getMedian(PriorityQueue<Integer> smallHalf, PriorityQueue<Integer> largeHalf, int k) {
        if (!smallHalf.isEmpty() && !largeHalf.isEmpty()) {
            if (k % 2 == 0)
                return ((double) smallHalf.peek() + largeHalf.peek()) / 2.0;
            return smallHalf.peek();
        }
        return 0.0;
    }

    // Using treemap
    public static double[] medianSlidingWindowI(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {

            // adding the element
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i >= k - 1) {
                // getting a median
                result[i - k + 1] = getMedian(map, k);

                // removing the outgoing element
                int out = nums[i - k + 1];
                map.put(out, map.getOrDefault(out, 0) - 1);
                if (map.get(out) == 0) map.remove(out);
            }

        }
        return result;
    }

    public static double getMedian(TreeMap<Integer, Integer> map, int k) {
        int count = 0;
        int m1 = -1, m2 = -1;
        boolean isEven = k % 2 == 0;
        int mid1 = k / 2;
        int mid2 = mid1 + 1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                count++;

                if (count == mid1) m1 = val;
                if (count == mid2) {
                    m2 = val;
                    if (isEven) return (m1 + m2) / 2.0;
                    else return m2;
                }
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        double[] result = medianSlidingWindowI(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4);
        System.out.println(Arrays.toString(result));
        double[] result1 = medianSlidingWindowII(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4);
        System.out.println(Arrays.toString(result1));

    }
}