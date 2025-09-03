package tree;

public class TreeNode <T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
                this.val = value;
                this.left = left;
                this.right = right;
        }

        public TreeNode(T value) {
                this.val = value;
        }
}
