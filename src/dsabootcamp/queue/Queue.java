package dsabootcamp.queue;

public class Queue {
    int rearPointer = -1;
    int frontPointer = -1;
    int size;
    int[] queue;

    public Queue(int size) {
        this.size = size;
        this.queue = new int[size];
    }

    public void enqueue(int value) {
        if (rearPointer == size - 1) {
            throw new RuntimeException("Overflow...");
        }
        queue[++rearPointer] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[++frontPointer];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[frontPointer + 1];
    }

    public boolean isEmpty() {
        return rearPointer == frontPointer;
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Dequeue: " + q.dequeue()); // 10
        System.out.println("Peek: " + q.peek());       // 20
        System.out.println("Dequeue: " + q.dequeue()); // 20
        System.out.println("Dequeue: " + q.dequeue()); // 30
        System.out.println("Is Empty: " + q.isEmpty()); // true
    }
}