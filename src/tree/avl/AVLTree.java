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
        root.height = 0;

        for (int i = 1; i < n; i++) {
            root = insertHelper(values[i], root);
        }
        return root;
    }

    private AVLTreeNode insertHelper(int value, AVLTreeNode root) {

        if (root == null) {
            AVLTreeNode newNode = new AVLTreeNode(value);
            newNode.height = 0;
            return newNode;
        }

        if (root.value > value) {
            root.left = insertHelper(value, root.left);
        } else {
            root.right = insertHelper(value, root.right);
        }
        root.height = calculateHeight(root);

        return rotate(root);
    }

    private AVLTreeNode rotate(AVLTreeNode root) {
        int balanceFactor = calculateBalanceFactor(root);

        // Case 1 : for leaf heavy
        if (balanceFactor > 1) {
            // Left - Left case :
            if (calculateBalanceFactor(root.left) >= 0) {
                return rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

        }
        // Case 2 : for right heavy
        else if (balanceFactor < -1) {
            if (calculateBalanceFactor(root.right) <= 0) {
                return leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;

    }

    private AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = calculateHeight(x);
        y.height = calculateHeight(y);

        return y;
    }

    private AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = calculateHeight(y);
        x.height = calculateHeight(x);

        return x;
    }

    private int calculateBalanceFactor(AVLTreeNode root) {
        if (root == null) return 0;

        int leftHeight = root.left == null ? -1 : root.left.height;
        int rightHeight = root.right == null ? -1 : root.right.height;
        return leftHeight - rightHeight;

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
        if (node == null) return -1;
        int leftHeight = (node.left != null) ? node.left.height : -1;
        int rightHeight = (node.right != null) ? node.right.height : -1;
        return 1 + Math.max(leftHeight, rightHeight);
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
