package tree.leetcode;

import tree.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        // Build a sample binary tree
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Call
        System.out.println(hasPathSum(root,22));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        targetSum = (int) root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
