package dsabootcamp.linkedlist;

class Node {
    int value;
    Node next;

    public Node() {

    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}


public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;


    // add elements at beginning
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        size++;
    }

    // add elements at last
    public void addLast(int value) {
        if (tail == null) {
            addFirst(value);
        } else {
            tail.next = new Node(value);
            tail = tail.next;
            size++;
        }
    }

    // add elements at the given position (0-based indexing) -
    public void add(int value, int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Position cannot be negative");
        }

        if (pos == 0) {
            addFirst(value);
            return;
        }

        if (pos >= size) {
            addLast(value);
            return;
        }

        Node tempNode = head;
        for (int i = 0; i < pos - 1; i++) {
            tempNode = tempNode.next;
        }

        Node newNode = new Node(value);
        newNode.next = tempNode.next;
        tempNode.next = newNode;

        size++;
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
        Node temp=head;
        for (int i = 0; i < pos-1 && temp!=null; i++) {
            temp=temp.next;
        }
        if(temp!=null) temp.next=temp.next.next;
    }
    // delete at end
    public void deleteLast(){
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }

    // to print elements
    public void print() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
        }
        System.out.println(); // Add newline for better formatting
    }

    // to print elements in reverse order
    public static void reversePrint(Node node) {
        // base case
        if (node == null) {
            return;
        }
        reversePrint(node.next);
        // printing in backtracking
        System.out.print(node.value + " ");
    }

    // reverse the elements
    public static Node reverse(Node head) {
        Node previous = null, next = null, current = head;

        while (current != null) {
            next = current.next;
            current.next = previous; // reverse link
            previous = current;
            current = next;
        }

        return previous;
    }

    // Instance method to reverse the list - NEW
    public void reverseList() {
        if (head == null) return;

        tail = head;
        head = reverse(head);
    }

    // getters
    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    // utility functions

    // find minimum element
    public int min() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        Node tempNode = head;
        int min = tempNode.value;
        while (tempNode != null) {
            min = Math.min(min, tempNode.value);
            tempNode = tempNode.next;
        }
        return min;
    }

    // find maximum element
    public int max() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        Node tempNode = head;
        int max = tempNode.value;
        while (tempNode != null) {
            max = Math.max(max, tempNode.value);
            tempNode = tempNode.next;
        }
        return max;
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(5);
        list1.addFirst(0);

        list1.add(4, 4);

        System.out.print("Original list: ");
        list1.print();

        System.out.println("Size: " + list1.getSize());
        System.out.println("Minimum element: " + list1.min());
        System.out.println("Maximum element: " + list1.max());

        System.out.print("Reverse print: ");
        reversePrint(list1.getHead());
        System.out.println();

        System.out.print("List before reverse print: ");
        list1.print();

//        list1.reverseList();
//        System.out.print("List after reversing: ");
//        list1.print();

        System.out.print("List after deleting: ");
        list1.deleteFirst();
        list1.print();

        list1.delete(2);
        list1.print();

        list1.deleteLast();
        list1.print();
    }
}