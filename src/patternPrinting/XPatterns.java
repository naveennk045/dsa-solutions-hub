package patternPrinting;

public class XPatterns {


    public static void main(String[] args) {



        String str = "PROGRAM";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == ++j || j == n - i - 1) {
                    System.out.print(str.charAt(i) + " ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}