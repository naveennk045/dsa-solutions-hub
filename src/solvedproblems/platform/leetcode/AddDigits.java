package solvedproblems.platform.leetcode;


public class AddDigits {
    public static int addDigits(int num) {
        if (num < 10)
            return num;
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += (num % 10);
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}