package advanced.LinkedList;

import advanced.core.ListNode;


public class ReverseKNodes {


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
