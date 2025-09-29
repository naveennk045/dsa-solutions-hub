package linkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    private class Node {
        int value;
        Node previous;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    public Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bounds");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node find(int data) {
        Node tempNode = head;

        while (tempNode != null) {
            if (data == tempNode.value) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;
    }
    

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.previous = null;
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;


        if (tail == null) {
            tail = head;
        }
        size++;
    }


    public void addLast(int data) {

        if (size == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.previous = tail;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;

        size++;

    }

    public void add(int index, int data) {

        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bounds");
        }

        if (index == 0) { // Adding at the head
            addFirst(data);
            return;
        }
        if (index == size) { // Adding at the tail
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node previousNode = getNode(index - 1);
        Node nextNode = previousNode.next;

        newNode.next = nextNode;
        newNode.previous = previousNode;

        previousNode.next = newNode;
        nextNode.previous = newNode;

        size++;
    }

    public void display() {

        Node tempNode = head;

        System.out.print("null" + " <-> ");
        while (tempNode != null) {
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");

    }

    public void displayReverse() {

        Node tempNode = tail;

        System.out.print("null" + " <-> ");
        while (tempNode != null) {
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.previous;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {

        DoublyLinkedList dList = new DoublyLinkedList();

        dList.addFirst(56);
        dList.addFirst(57);
        dList.addFirst(58);

        dList.display();
        dList.displayReverse();

        dList.addLast(55);
        dList.addLast(54);

        dList.display();

        dList.add(3, 57);
        dList.display();


    }


}