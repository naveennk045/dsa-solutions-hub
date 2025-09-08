package string;

public class ExcelColumnName {
    public static String numberToExcelColumn(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int remainder = n % 26;
            if (remainder == 0) {
                result.append('Z');
                n = (n / 26) - 1;
            } else {
                result.append((char) ('A' + remainder - 1));
                n = n / 26;
            }
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(numberToExcelColumn(956)); // AJT
        System.out.println(numberToExcelColumn(26));  // Z
        System.out.println(numberToExcelColumn(52));  // AZ
    }
}
