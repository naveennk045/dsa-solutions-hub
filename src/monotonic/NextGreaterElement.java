package monotonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElementI(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> greaterElementHolder = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) greaterElementHolder.put(nums2[i], -1);
            else greaterElementHolder.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = greaterElementHolder.getOrDefault(nums1[i], -1);
        }
        return nums1;

    }

    public static int[] nextGreaterElementsII(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            newNums[i % n] = nums[i % n];
        }
        System.out.println(Arrays.toString(newNums));
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};

        // Using assert for validation
        assert Arrays.equals(
                nextGreaterElementsII(nums),
                new int[]{2, 3, 4, -1, 4}
        ) : "❌ Testcase not passed";

        System.out.println("✅ Test Passed!");
    }
}
