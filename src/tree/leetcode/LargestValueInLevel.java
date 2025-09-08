package tree.leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInLevel {
    public static void main(String[] args) {

    }

    public static List<Integer> largestValues(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        int currentLevel = 0;
        queue.add(root);

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            int maxValueAtLevel = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize && !queue.isEmpty(); i++) {
                TreeNode currentRoot = queue.poll();

                if (currentRoot.left != null) queue.add(currentRoot.left);
                if (currentRoot.right != null) queue.add(currentRoot.right);

                maxValueAtLevel = Math.max((int) currentRoot.val, maxValueAtLevel);
            }
            result.add(maxValueAtLevel);
        }
        return result;
    }
}
