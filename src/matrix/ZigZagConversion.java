package matrix;

import java.util.Arrays;

public class ZigZagConversion {
    public static String convert(String word,int numRows){

        int n = word.length();
        char[][] chars = new char[numRows][n];
        int index = 0;
        int column=0;

        for (char[] row : chars) {
            Arrays.fill(row,'.');
        }
        while (index < n) {
            for (int row = 0; row < numRows && index < n; row++) {
                chars[row][column] = word.charAt(index++);
            }
            column++;

            for (int row = numRows - 2; row >= 1 && index < n; row--) {
                chars[row][column++] = word.charAt(index++);
            }
        }
        StringBuilder ans = new StringBuilder();

        for (char[] row : chars){
            for (char ch : row){
                if(ch!='.') ans.append(ch);
                System.out.print(ch+" ");
            }
            System.out.println();
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("A",1));
    }
}