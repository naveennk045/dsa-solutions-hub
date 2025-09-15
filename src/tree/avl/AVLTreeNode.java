package tree.avl;

public class AVLTreeNode {
    public int value;
    public AVLTreeNode left;
    public AVLTreeNode right;
    public int height;


    public AVLTreeNode(int value, AVLTreeNode left, AVLTreeNode right, int height) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    public AVLTreeNode(int value, int height) {
        this.value = value;
        this.height = height;
    }

    public AVLTreeNode(int value) {
        this.value = value;
    }


}
