package problems.linkedlist.sorting;

import problems.linkedlist.ListNode;

import java.util.Scanner;

public class BubbleSort {

    public static void sort(ListNode head){
        ListNode temp = head;

        while(temp != null){
            ListNode curr = head;
            boolean isSwapped = false;
            while(curr.next != null){
                if(curr.val > curr.next.val){
                    SwapNodeValues.swap(curr,curr.next);
                    isSwapped = true;
                }
                curr=curr.next;
            }
            if(!isSwapped) return;
            temp=temp.next;
        }
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


        sort(dummy.next);

        ListNode head =dummy.next;

        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
}