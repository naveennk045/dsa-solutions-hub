package dsabootcamp.linkedlist;

import java.util.Scanner;


public class LinkedList {

    Node head;
    Node tail;

    // add first
    public void addFirst(int value){
        Node newNode = new Node(value);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
    }

    // addLat
    public void addLast(int value){
        if(head==null){
            addFirst(value);
        }else{
            tail.next=new Node(value);
            tail=tail.next;
        }
    }

    // add by position
    public void add(int position,int value){
        if(position==0) {
            addFirst(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position  && temp != null; i++) {
            temp=temp.next;
        }
        if(temp == null || temp.next ==null) {
            addLast(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.next=temp.next;
        temp.next=newNode;
    }

    // delete at beginning
    public void deleteFirst(){
        if(head==null)
            throw new RuntimeException("List is empty");
        head=head.next;
        if(head==null){
            tail=null;
        }
    }

    // delete using positions
    public void delete(int pos){
        if(pos==0) {
            deleteFirst();
            return;
        }
        Node temp=head;
        for (int i = 1; i < pos -1 && temp!=null; i++) {
            temp=temp.next;
        }
        if(temp!=null) temp.next=temp.next.next;
        else{
            deleteLast();
        }
    }
    // delete at end
    public void deleteLast(){
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }


    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" --> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

}

class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the values : ");
        LinkedList list = new LinkedList();
        while(scan.hasNextInt()){
            list.addLast(scan.nextInt());
        }
        list.addLast(11);
        list.addFirst(0);
        list.add(3,4);
        list.print();

        list.deleteFirst();
        list.delete(3);
        list.deleteLast();
        list.print();


    }
}