package leetcode.dp;

import java.util.HashMap;

public class FibonacciSeries {
    static HashMap<Integer, Integer> memory = new HashMap<>();

    static {
        memory.put(0, 0);
        memory.put(1, 1);
    }

    /*
    This is the brute force way to calculate the N-th fibonacci number,
    the time complexity is about 2^n which is not good it is exponential
    */
    public static int findNthFib(int n) {
        if (n < 2) return n;
        return findNthFib(n - 1) + findNthFib(n - 2);
    }

    /*
    This is the optimal way, in the brute force approach we calculate the same answer for same numbers again and
    again (sub-problems give the same answer).Now, we are using the concept that is similar how we memorize the content
    like if we see the question like we refer it and answer - Not space optimal
    */
    public static int findNthFibUsingMemoization(int n) {
        if (memory.containsKey(n)) return memory.get(n);
        int currAns = findNthFibUsingMemoization(n - 1) + findNthFibUsingMemoization(n - 2);
        memory.put(n, currAns);
        return currAns;
    }

    /*
    This is another optimal way to solve the overlapping sub-problems using iterative approach
     public static int findNthFibUsingTabulation(int n) {
        if (n < 2) return n;

        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }
    */
    public static int findNthFibUsingTabulation(int n) {
        if (n < 2) return n;

        int f1 = 0, f2 = 1;
        int f = 0;
        for (int i = 2; i < n + 1; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }

    public static void main(String[] args) {

        System.out.println(findNthFib(5));
        System.out.println(findNthFibUsingMemoization(5));
        System.out.println(findNthFibUsingTabulation(5));
    }
}
