package linkedlist;

import java.util.Scanner;
import java.util.Stack;


public class Solution {

    static Scanner scan=new Scanner(System.in);

    public static ListNode rotateRight(ListNode head, int k) {

    return null;
    }
//    to display a list
    public static void display(ListNode head){
        ListNode temp=head;

        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
//    get an input from the user and add first
    public static ListNode addFirst() {
        ListNode head = new ListNode();
        ListNode temp = head;
        int size = scan.nextInt();
        for (int i = 0; i < size; i++) {
            int curr = scan.nextInt();
            temp.val = curr;
            ListNode newNode = new ListNode();
            if (i < size - 1) {
                temp.next = newNode;
                temp = temp.next;
            }
        }
        return head;
    }

//    get an input from the user and add last
    public static ListNode addLast() {
        ListNode head = new ListNode();

        int size = scan.nextInt();
        for (int i = 0; i < size; i++) {
            int curr = scan.nextInt();
            head.val = curr;
            ListNode newNode = new ListNode();
            if(i<size-1){
                newNode.next = head;
                head = newNode;
            }
        }
        return head;
    }

    public static ListNode reverse(ListNode head){
        return null;
    }


    public static void main(String[] args) {

        display(addFirst());
        display(addLast());
    }
}