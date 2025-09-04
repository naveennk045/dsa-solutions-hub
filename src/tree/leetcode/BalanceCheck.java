package tree.leetcode;

import tree.TreeNode;

@SuppressWarnings("ALL")
public class BalanceCheck {
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

        // Call Solution
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        return isBalanceHelper(root) != -1;
    }

    private static int isBalanceHelper(TreeNode root) {

        if (root == null) return 0;

        int leftHeight = isBalanceHelper(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = isBalanceHelper(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }
}
