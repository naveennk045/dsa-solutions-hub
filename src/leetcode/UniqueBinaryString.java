package leetcode;


import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/find-unique-binary-string/

public class UniqueBinaryString {
    public static String findDifferentBinaryStringII(String[] nums) {


        return " ";
    }
//    Cantor's Diagonal Argument
    public static String findDifferentBinaryStringIII(String[] nums) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i].charAt(i)=='0'){
                sb.append(1);
            }else{
                sb.append(0);
            }
        }
        return sb.toString();
    }


//    brute force approach
    public static String findDifferentBinaryStringI(String[] nums) {
        HashSet<String> set=new HashSet<>();
        int n= nums.length;

        set.addAll(Arrays.asList(nums));

        for (int i = 0; i < Math.pow(2,n); i++) {
            String binary=Integer.toBinaryString(i);
            while(binary.length()<n){
                binary="0"+binary;
            }

            if(!set.contains(binary)){
                return binary;
            }
        }
        return " ";
    }
    public static void main(String[] args) {

    }
}