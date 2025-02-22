public class Main {
    public static void main(String[] args) {
        char[] set = {'a', 'b'};
        int k = 3;
        int n = set.length;
        int total = (int) Math.pow(n, k);  // Total combinations = n^k

        // Iterate through all numbers from 0 to total - 1
        for (int i = 0; i < total; i++) {
            int num = i;
            String combination = "";
            // Convert number to base-n representation to form the combination
            for (int j = 0; j < k; j++) {
                // Get the current digit (using modulo to find the index)
                combination = set[num % n] + combination;
                num /= n;  // Move to the next digit
            System.out.println(combination);
            }
        }
    }
}