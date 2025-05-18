package sandbox;

public class Factorial {
    public static void main(String[] args) {
        int number = 20;
        int[] result = factorial(number);

        System.out.print("Factorial of " + number + " is: ");
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }

    public static int[] factorial(int n) {
        int[] result = new int[1000];
        result[0] = 1;
        int resultSize = 1;

        for (int x = 2; x <= n; x++) {
            int carry = 0;
            for (int i = 0; i < resultSize; i++) {
                int product = result[i] * x + carry;
                result[i] = product % 10;
                carry = product / 10;
            }
            while (carry > 0) {
                result[resultSize] = carry % 10;
                carry /= 10;
                resultSize++;
            }
        }

        int[] finalResult = new int[resultSize];
        System.arraycopy(result, 0, finalResult, 0, resultSize);
        return finalResult;
    }
}