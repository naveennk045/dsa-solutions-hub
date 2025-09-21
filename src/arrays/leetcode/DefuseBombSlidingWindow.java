package arrays.leetcode;

import java.util.Arrays;

public class DefuseBombSlidingWindow {

    public static int[] decrypt(int[] code, int k) {
        // Doubling the array
        int n = code.length;
        int[] doubleCode = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            doubleCode[i] = code[i % n];
        }
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        if (k > 0) {
            int sum = 0;
            int left = 1;
            int right = left + k;

            for (int i = 1; i <= k; i++) {
                sum += doubleCode[i];
            }
            int count = 0;
            for (; count < n; left++, right++,count++) {
                code[left - 1] = sum;
                sum -= doubleCode[left];
                sum += doubleCode[right];
            }
            return code;
        }

        int sum = 0;
        int left = 2 * n + k;
        int right = 2 * n ;

        for (int i = left; i < right; i++) {
            sum += doubleCode[i];
        }

        int count = 0;
        for (; count < n; left++, right++, count++) {
            if (left == 2 * n) left = 0;
            if (right == 2 * n) right = 0;

            code[(right) % n] = sum;
            sum += doubleCode[right];
            sum -= doubleCode[left];
        }
        return code;
    }

    public static void main(String[] args) {
        int[] code = {2, 4, 9, 3};
        int k = -2;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }
}
