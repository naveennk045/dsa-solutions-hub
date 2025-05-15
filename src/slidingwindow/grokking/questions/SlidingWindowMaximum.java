package slidingwindow.grokking.questions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
    /*    there are many ways to find the sliding window maximum microsoft using
            priority queue ( heap )
            Normal sliding window and update the max based on the outgoing and incoming element
            Monotonic queue    
    */

        Deque<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int left = 0;
        int[] result = new int[n - k + 1];

        for (int right = 0; right < n; right++) {

            // To keep the maximum value in last
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.offerLast(right);

            if (!queue.isEmpty() && queue.peekFirst() < left) queue.pollFirst();
            System.out.println(queue);

            if (!queue.isEmpty() && right >= k - 1) {
                result[left++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}