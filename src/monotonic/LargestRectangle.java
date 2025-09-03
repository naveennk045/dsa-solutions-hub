package monotonic;

<<<<<<< Updated upstream
import java.util.Stack;

public class LargestRectangle {

    public static int largestRectangleArea(int[] heights) {
=======

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
>>>>>>> Stashed changes
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
<<<<<<< Updated upstream
            int h = (i == n ? 0 : heights[i]); // process all by adding a dummy 0 at end
=======
            int h = (i == n ? 0 : heights[i]);
>>>>>>> Stashed changes
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
<<<<<<< Updated upstream

    public static void main(String[] args) {

    }
=======
>>>>>>> Stashed changes
}
