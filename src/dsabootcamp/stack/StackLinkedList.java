package dsabootcamp.stack;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class StackLinkedList {
    Node head;
    int size;

    public StackLinkedList(int size) {
        this.size = size;
    }

    void push(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    int pop() {
        int poppedVal = head.val;
        head = head.next;
        return poppedVal;
    }

    int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return head.val;
    }

    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}