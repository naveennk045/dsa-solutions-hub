package tree;

public class TreeNode <T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
                this.value = value;
                this.left = left;
                this.right = right;
        }

        public TreeNode(T value) {
                this.value = value;
        }
}