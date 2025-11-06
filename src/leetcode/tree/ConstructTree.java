package leetcode.tree;


import java.util.HashMap;

public class ConstructTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1 && postorder.length == 1) return new TreeNode(inorder[0]);

        HashMap<Integer, Integer> inorderIndices = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndices.put(inorder[i], i);
        }
        return buildTreeUtils(inorder, postorder, postorder.length - 1, 0, inorder.length - 1, inorderIndices);
    }

    public TreeNode buildTreeUtils(int[] inorder, int[] postOrder, int idx, int startIdx, int endIdx,
                                   HashMap<Integer, Integer> inorderIndices) {

        if (startIdx > endIdx) return null;

        int rootValue = postOrder[idx];
        TreeNode root = new TreeNode(rootValue);

        int pivotIndex = inorderIndices.getOrDefault(rootValue, -1);
        if (pivotIndex == -1) return null;

        root.left = buildTreeUtils(inorder, postOrder, idx - 1, startIdx, pivotIndex - 1, inorderIndices);
        root.right = buildTreeUtils(inorder, postOrder, idx - 1, pivotIndex + 1, endIdx, inorderIndices);

        return root;
    }

    public static void main(String[] args) {

    }
}
