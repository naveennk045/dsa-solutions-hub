package arrays.problems;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strArr={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strArr));


        }
    public static String longestCommonPrefix(String[] strArr) {
        StringBuilder result =new StringBuilder();

        Arrays.sort(strArr);

        char[] start=strArr[0].toCharArray();
        char[] end=strArr[strArr.length-1].toCharArray();

        for (int i = 0; i < start.length; i++) {
            if(start[i]!=end[i]){
                break;
            }
            result.append(start[i]);
        }

        return result.toString();}
}