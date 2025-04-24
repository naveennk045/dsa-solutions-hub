import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T-- > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] girls = new int[n];
            for (int i = 0; i < n; i++) {
                girls[i] = scan.nextInt();
            }
            int sum = 0, maxSum = 0;

            for (int i = 0; i < n; i++) {
                sum += girls[i];
                if (i >= k - 1) {
                    maxSum = Math.max(maxSum, sum);
                    sum -= girls[i - k + 1];
                }
            }
            System.out.println(maxSum);
        }

    }
}