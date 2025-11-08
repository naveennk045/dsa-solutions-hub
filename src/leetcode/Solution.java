package leetcode;

public class Solution {
    public static String removeDigit(String number, char digit) {

//        int max = Integer.MIN_VALUE;
        String maxNum = "0";
        StringBuilder str = new StringBuilder(number);

        for (int i = 0; i < number.length(); i++) {
            char currChar = str.charAt(i);

            if (currChar == digit) {
                str.deleteCharAt(i);
//                int currNum = Integer.parseInt(str.toString());
//                max = Math.max(currNum, max);
                if(str.toString().compareTo(maxNum) > 0 ){
                    maxNum = str.toString();
                }
                str.insert(i, currChar);
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(removeDigit("1231", '1'));
    }
}
