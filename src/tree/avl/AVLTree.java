package tree.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    private AVLTreeNode root;

    public AVLTreeNode insert(int[] values) {
        int n = values.length;
        if (n == 0) return null;

        // Initialize root. Height is 1 because it's a leaf now.
        root = new AVLTreeNode(values[0]);
        root.height = 1;

        for (int i = 1; i < n; i++) {
            root = insertHelper(values[i], root);
        }
        return root;
    }

    private AVLTreeNode insertHelper(int value, AVLTreeNode root) {

        if (root == null) {
            AVLTreeNode newNode = new AVLTreeNode(value);
            newNode.height = 1;
            return newNode;
        }

        if (root.value > value) {
            root.left = insertHelper(value, root.left);
        } else {
            root.right = insertHelper(value, root.right);
        }

        root.height = calculateHeight(root);
        return root;
    }

    // for testing whether insertion is correct or not
    public void inorderTraversal() {
        inorderTraversalHelper(root);
        System.out.println();
    }

    private void inorderTraversalHelper(AVLTreeNode root) {
        if (root == null) return;

        inorderTraversalHelper(root.left);
        System.out.print(root.value + " ");
        inorderTraversalHelper(root.right);
    }

    private int calculateHeight(AVLTreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    public void display() {
        if (root == null) return;
        Queue<AVLTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                AVLTreeNode currNode = queue.poll();
                if (currNode != null) {
                    System.out.print(currNode.value + "(h:" + currNode.height + ") ");
                    if (currNode.left != null) queue.add(currNode.left);
                    if (currNode.right != null) queue.add(currNode.right);
                }
            }
            System.out.println();
        }
    }


}
