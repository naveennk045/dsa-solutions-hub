package recursion;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueue {

    public static void insert(Queue<Integer> queue, int val) {
        if (queue.isEmpty() || queue.peek() <= val) {
            queue.add(val);
            return;
        }
        int poppedVal = queue.poll();
        insert(queue, val);
        queue.add(poppedVal);
    }

    public static void sort(Queue<Integer> queue) {
        if (queue.isEmpty()) return;

        int poppedVal = queue.poll();

        sort(queue);

        insert(queue, poppedVal);
//        System.out.println(poppedVal);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(8);
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(1);
        sort(queue);
        System.out.println(queue);
    }
}