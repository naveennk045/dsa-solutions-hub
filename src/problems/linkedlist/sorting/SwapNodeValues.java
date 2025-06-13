package problems.linkedlist.sorting;

import problems.linkedlist.ListNode;

public class SwapNodeValues {
    public static void swap(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}