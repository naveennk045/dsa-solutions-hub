package recursion;

public class DecimalToBinary {

    public static String decimalToBinary(int num) {
        if (num == 0) return "";
        return decimalToBinary(num / 2) + (num % 2);
    }

    public static void main(String[] args) {
        int num = 7;
        String binary = decimalToBinary(num);
        System.out.println(binary.isEmpty() ? "0" : binary);
    }
}