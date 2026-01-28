package zoho.prep;

public class ExcelSheetColumnFinding {

    public static int titleToNumber(String columnTitle) {

        int n = columnTitle.length() - 1;
        int number = 0;

        for (int i = 0; i < columnTitle.length(); i++, n--){
            number += (int) Math.pow(26, n) * (1 + (columnTitle.charAt(i) - 'A'));
        }
        return number;
    }

    public static String convertToTitle(int columnNumber) {

        StringBuilder title = new StringBuilder();
        while (columnNumber > 0) {

            columnNumber--;
            int rem = columnNumber % 26;
            columnNumber /= 26;

            title.append((char) ('A' + rem));
            System.out.println(rem + " - " + columnNumber);

        }
        return title.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
