package tree;


import java.util.LinkedList;
import java.util.Queue;

public class TraversalAlgorithms {
    /*
                  1
                /   \
                2     3
                / \   /
                4   5 6
     */

    // left - root - right
    public static void inOrder(TreeNode<Integer> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    // root - left - right
    public static void preOrder(TreeNode<Integer> root) {
        if (root == null) return;

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //  left - right - root
    public static void postOrder(TreeNode<Integer> root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");


    }

    public static void levelOrder(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.value + " ");

            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);

        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);


        System.out.println("Inorder : ");
        inOrder(root);
        System.out.println();

        System.out.println("Pre Order : ");
        preOrder(root);
        System.out.println();

        System.out.println("Post Order : ");
        postOrder(root);
        System.out.println();

        System.out.println("Level Order : ");
        levelOrder(root);
    }
}