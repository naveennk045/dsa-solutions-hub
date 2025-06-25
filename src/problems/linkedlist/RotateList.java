package problems.linkedlist;


import java.util.Scanner;

public class RotateList {

    // to get a size of the list
    public static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    // to reverse the list
    public static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    // to get Node using index
    public static ListNode getNode(ListNode head, int index) {
        if (head == null) return null;
        if (index == 0) return head;
        for (int i = 0; i < index - 1; i++) {
            head = head.next;
        }
        return head;
    }

    // to rotate a List
    public static ListNode rotateRight(ListNode head, int k) {

        int size = getSize(head);
        k = k % size;

        // reverse fully
        head = reverse(head);

        ListNode node = getNode(head, k);
        ListNode secondHead = reverse(node.next);
        node.next = null;
        head = reverse(head);

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = secondHead;
        return head;
    }

    public static ListNode rotateRightI(ListNode head, int k) {
        if (head == null) return null;

        int size = getSize(head);

        k = k % size;

        ListNode node = getNode(head, size - k);
        System.out.println(node.val);

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head = node.next;
        node.next = null;
        return head;
    }


    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
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

        ListNode head = dummy.next;

//        int size = getSize(head);
//        head = reverse(head);
//
//        System.out.println(size);
//        System.out.println(getNode(head,2).val);

        head = rotateRightI(head, 2);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}