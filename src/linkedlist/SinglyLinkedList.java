package linkedlist;

public class SinglyLinkedList {

    private int size;
    private Node head;
    private Node tail;

    public SinglyLinkedList() {
        this.size = 0;
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
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

    public int getSize() {
        return size;
    }

    public void add(int data, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node temp = getNode(index - 1);
            Node newNode = new Node(data, temp.next);
            temp.next = newNode;
            size++;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(int data) {
        if (tail == null) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }


    public int deleteFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        if (size == 1) {
            return deleteFirst();
        }
        Node secondLast = getNode(size - 2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return value;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bounds");
        }
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node previousNode = getNode(index - 1);
        int value = previousNode.next.value;
        previousNode.next = previousNode.next.next;
        size--;
        return value;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    public void display() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        SinglyLinkedList list=new SinglyLinkedList();

        list.addFirst(4);

        list.addLast(5);
        list.addLast(9);
        list.addLast(7);

        list.add(0,3);

        System.out.println(list.getSize());
        list.display();


        list.delete(3);
        list.display();

        System.out.println(list.deleteFirst());
        list.display();


        System.out.println(list.deleteLast());
        list.display();

    }
    }