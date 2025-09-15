package tree.avl;

public class Main {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        int[] values = {20,10,30,60,40,50};
        AVLTreeNode root =  avlTree.insert(values);
        avlTree.inorderTraversal();
        avlTree.display();
    }
}
