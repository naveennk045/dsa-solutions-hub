package stack.implementations;

import java.util.EmptyStackException;

public class StackUsingLinkedList implements StackUtils {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node top;
    private int size;

    public StackUsingLinkedList() {
        top = null;
        size = 0;
    }

    @Override
    public void push(int value) {
        Node newValue = new Node(value);
        newValue.next = top;
        top = newValue;
        size++;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}