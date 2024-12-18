package LinkedList;

public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Constructor to initialize an empty list
    public CustomLinkedList() {
        this.size = 0;
    }

    // Add a node at the beginning
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // Add a node after the target node
    public void add(T target, T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> previousNode = find(target);

        if (previousNode == null) {
            System.out.println("Target node not found");
            return;
        }

        newNode.next = previousNode.next;
        previousNode.next = newNode;
        if (previousNode == tail) {
            tail = newNode;
        }
        size++;
    }

    // Add a node at the end
    public void addLast(T data) {
        if (size == 0) {
            addFirst(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // Remove a specific node
    public void remove(T data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.value.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.value.equals(data)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                size--;
                return;
            }
            current = current.next;
        }

        System.out.println("Node with value " + data + " not found.");
    }

    // Find a node by its value
    public Node<T> find(T data) {
        Node<T> tempNode = head;

        while (tempNode != null) {
            if (tempNode.value.equals(data)) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    // Display the list
    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Get the size of the list
    public int getSize() {
        return size;
    }

    // Clear the list (empty the list)
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

}