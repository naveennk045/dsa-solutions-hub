package advanced.recursion;

public class TrailingZero {

    public static int trailingZeroesI(int n) {
        /*
         * This is the brute force approach for calculating the trailing zeros
         */
        long factorial = factorial(n);
        int count = 0;
        while (factorial % 10 == 0) {
            count++;
            factorial /= 10;
        }
        return count;
    }

    public static int trailingZeroesII(int n) {
        /*
         * This is the optimized way for finding the trailing zero.Basic pattern behind this is
         * what is the reason for the occurrence of zero at the trailing end.
         */
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroesI(5));
        System.out.println(trailingZeroesII(5));
    }
}
