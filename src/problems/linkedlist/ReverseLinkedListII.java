package problems.linkedlist;

import java.util.Scanner;

public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeLeft = dummy;
        for (int i = 1; i < left; i++) {
            beforeLeft = beforeLeft.next;
        }

        // reverse
        ListNode previous = beforeLeft;
        ListNode current = beforeLeft.next;
        ListNode next;
        for (int i = 0; i < right - left + 1 && current != null; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        if (beforeLeft.next != null) {
            beforeLeft.next.next = current;
        }
        beforeLeft.next = previous;

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers to build the linked list (non-integer to stop):");

        ListNode dummy = new ListNode(0);  // dummy node to simplify appending
        ListNode current = dummy;

        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }


        ListNode head = reverseBetween(dummy.next, 3, 5);

        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }

    }
}