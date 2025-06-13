package problems.linkedlist.sorting;

import problems.linkedlist.ListNode;

import java.util.Scanner;

public class MergeSort {
    public static ListNode sort(ListNode head ){
        if(head == null || head.next == null ) return head;

        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;

//        System.out.println(mid.val);

        // to break the list into two halves
        mid.next = null;

        ListNode leftList = sort(head);
        ListNode rightList=sort(rightHead);

        return merge(leftList,rightList);
    }

    public static ListNode merge(ListNode list1 , ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2!= null){
            if(list1.val < list2.val){
                current.next=list1;
                list1=list1.next;
            }else{
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }

        if(list1 != null) current.next = list1;
        if(list2 != null) current.next = list2;

        return dummy.next;
    }

    public static ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next ;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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