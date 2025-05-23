package problems.contest;

import java.util.Scanner;

public class ProductCalculator {
    public static long product(long[] nums, int k) {
        long product = 1;
        long threshold = (long) Math.pow(10, k);
        for (long num : nums) {
            product *= num;
            if (product >= threshold) product = 1;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        long[] nums = new long[size];
        int k = scan.nextInt();
        for (int i = 0; i < size; i++) {
            nums[i] = scan.nextLong();
        }
        System.out.println(product(nums, k));
    }
}