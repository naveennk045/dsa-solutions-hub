package advanced.recursion;

import advanced.core.ListNode;
import advanced.core.TreeNode;

public class ConstructTree {

    public static TreeNode sortedListToBST(ListNode head) {
        return constructTree(head, null);
    }

    public static TreeNode constructTree(ListNode start, ListNode end) {
        if (start == end) return null;

        ListNode middle = findMiddleNode(start, end);
        TreeNode root = new TreeNode(middle.val);

        root.left = constructTree(start, middle);
        root.right = constructTree(middle.next, end);

        return root;
    }

    public static ListNode findMiddleNode(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
