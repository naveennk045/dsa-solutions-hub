package dsabootcamp.linkedlist;

class DoublyNode {
    int value;
    DoublyNode prev;
    DoublyNode next;

    public DoublyNode() {
    }

    public DoublyNode(int value) {
        this.value = value;
    }

    public DoublyNode(int value, DoublyNode prev, DoublyNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}

public class DoublyLinkedList {
    private int value;
    private DoublyNode head;
    private DoublyNode tail;
    private int size = 0;

    // add the element at the beginning of the list
    public void addFirst(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }


    // add the element at the end of the list
    public void addLast(int value) {
        if (tail == null) {
            addFirst(value);
            return;
        }

        DoublyNode newNode = new DoublyNode(value);
        newNode.prev = tail;
        tail.next = newNode;
        tail = tail.next;

        size++;
    }

    // add the element at specific position - [ O BASED INDEXING ]
    public void addAtIndex(int value, int index) {
        if (index < 0 || index > size) throw new RuntimeException("Invalid index");
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }

        DoublyNode temp = head;
        DoublyNode newNode = new DoublyNode(value);
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next.prev = newNode;
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;

        size++;

    }

    public void deleteFirst() {
        if (head == null) return;
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteLast() {
        if (tail == null) return;
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    // Delete the element present in specific position
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) throw new RuntimeException("Invalid index");
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size-1) {
            deleteLast();
            return;
        }

        DoublyNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next.next.prev = temp;
        temp.next = temp.next.next;

        size--;

    }


    public void print() {
        DoublyNode temp = head;
        System.out.print("null <--> ");
        while (temp != null) {
            System.out.print(temp.value + " <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printReverse() {
        DoublyNode temp = tail;
        System.out.print("null <--> ");
        while (temp != null) {
            System.out.print(temp.value + " <--> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addAtIndex(6, 2);


        list.print();

        list.deleteAtIndex(2);
        list.deleteFirst();
        list.deleteLast();

        list.print();
        list.printReverse();

    }

}