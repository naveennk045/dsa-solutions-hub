package string;

import java.util.Arrays;

//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n1=num1.length();
        int n2=num2.length();
        int[] digits=new int[n1+n2];
        for(int i = n2-1; i >= 0; i--){
            int carry=0;
            for (int j = n1-1; j >= 0 ; j--) {
                int pos=i+j+1;
                int mul=(num2.charAt(i)-'0') *( num1.charAt(j)-'0')+carry+digits[pos];
                digits[pos]=mul%10;
                carry=mul/10;
            }
            digits[i]+=carry;
            System.out.println(Arrays.toString(digits));
        }
        StringBuilder result=new StringBuilder();
        for (int digit : digits) {
            if (result.isEmpty() && digit == 0) {
                continue;
            }
            result.append(digit);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("0","896"));

    }
}