package problems.companywise.adobe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LexicographicallyLargest {

    public static long gcd(long n1, long n2) {
        if (n2 == 0) return n1;

        return gcd(n2, n1 % n2);
    }

    public static long calculateGcd(List<Long> list) {
        long GCD = 0;
        for (Long aLong : list) {
            GCD = gcd(aLong, GCD);
        }
        return GCD;
    }

    //  optimized approach
    public static void generateCombinationsI(long[] nums, long[] ans, int idx, List<Long> current) {
        if (idx == nums.length) {
            long gcd = calculateGcd(current);
            int size = current.size() - 1;
            if (size < 0) return;
            ans[current.size() - 1] = Math.max(gcd, ans[current.size() - 1]);
            return;
        }
        current.add(nums[idx]);
        generateCombinationsI(nums, ans, idx + 1, current);
        current.removeLast();
        generateCombinationsI(nums, ans, idx + 1, current);

    }

    public static void generateCombinations(long[] nums, int idx, int r, List<Long> current, List<List<Long>> combinations) {
        if (r == current.size()) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        if (idx == nums.length) return;
        current.add(nums[idx]);
        generateCombinations(nums, idx + 1, r, current, combinations);
        current.removeLast();
        generateCombinations(nums, idx + 1, r, current, combinations);

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        long[] nums = new long[n];
        long[] ans = new long[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        generateCombinationsI(nums, ans, 0, new ArrayList<>());

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(ans[i] + " ");
        }

    }

}