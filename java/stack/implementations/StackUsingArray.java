package stack.implementations;

import java.util.EmptyStackException;
import java.util.Arrays;

//  You can use "Array List" also.
public class StackUsingArray implements StackUtils {

    private static final int INITIAL_CAPACITY = 10;
    private int[] data;
    private int top = -1;

    public StackUsingArray() {
        data = new int[INITIAL_CAPACITY];
    }

    public void push(int value) {
        if (isFull()) {
            resize(); // Automatically grow instead of throwing exception
        }
        data[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = data[top];
        top--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    private void resize() {
        // Create a new array with double the size
        int newCapacity = data.length * 2;
        System.out.println("Resizing stack to: " + newCapacity);

        // Copy old data to new array
        data = Arrays.copyOf(data, newCapacity);
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }
}