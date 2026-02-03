package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BuildingWithOceanView {

    /*
      ------------------------------------------------------------
      Approach 1: Brute Force
      ------------------------------------------------------------
      For each building, check all buildings to its right.
      If any building to the right is taller or equal, current building
      cannot see the ocean.

      Time Complexity: O(n^2) in the worst case
      Auxiliary Space: O(1)
      Output Space: O(n)
      ------------------------------------------------------------
     */
    public static ArrayList<Integer> findBuildingsWithOceanviewI(int[] heights) {

        ArrayList<Integer> buildingsWithOceanview = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            boolean hasView = true;

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    hasView = false;
                    break;
                }
            }

            if (hasView) {
                buildingsWithOceanview.add(i);
            }
        }

        return buildingsWithOceanview;
    }

    /*
       ------------------------------------------------------------
       Approach 2: Optimized Right-to-Left Traversal
       ------------------------------------------------------------
       Idea:
       Start from the rightmost building (ocean side) and keep track
       of the maximum height seen so far.

       If the current building is taller than all buildings to its right,
       it can see the ocean.

       We collect valid indices in reverse order and reverse the list
       at the end to maintain increasing index order.

       Time Complexity: O(n)
       Auxiliary Space: O(1)
       Output Space: O(n)

       Note:
       - Inserting at index 0 in ArrayList causes shifting (O(n) per insert).
       - Reversing once at the end is more efficient.
       ------------------------------------------------------------
     */
    public static ArrayList<Integer> findBuildingsWithOceanviewII(int[] heights) {

        int n = heights.length;
        ArrayList<Integer> buildingsWithOceanview = new ArrayList<>();

        int maxHeight = heights[n - 1];
        buildingsWithOceanview.add(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                buildingsWithOceanview.add(i);
            }
        }

        // Reverse to return indices in increasing order
        Collections.reverse(buildingsWithOceanview);
        return buildingsWithOceanview;
    }

    /*
     ------------------------------------------------------------
     Approach 3: Monotonic Stack
     ------------------------------------------------------------
     Maintain a monotonic decreasing stack of indices.

     While traversing from left to right:
     - Remove buildings from the stack that are shorter or equal
       to the current building, as they lose their ocean view.
     - Push the current building index onto the stack.

     At the end, the stack contains all buildings that can see the ocean.

     Time Complexity: O(n) (each index is pushed and popped at most once)
     Auxiliary Space: O(n) (stack can store up to n indices)
     Output Space: O(n)
     ------------------------------------------------------------
     */
    public static ArrayList<Integer> findBuildingsWithOceanviewIII(int[] heights) {

        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }

        return new ArrayList<>(stack);
    }


    public static void main(String[] args) {
        int[] heights = {4, 2, 3, 1};

        System.out.println(findBuildingsWithOceanviewI(heights));
        System.out.println(findBuildingsWithOceanviewII(heights));
        System.out.println(findBuildingsWithOceanviewIII(heights));
    }
}
