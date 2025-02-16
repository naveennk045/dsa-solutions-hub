package numberconcepts;

import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Integer.*;

public class BinaryDecimal {
    public static String decimalToBinary(int num){
        StringBuilder binaryValue=new StringBuilder();
        while(num>0){
            int reminder =num%2;
            binaryValue.append(reminder);
            num/=2;
        }
        return binaryValue.reverse().toString();
    }
    public static int binaryToDecimal(String binaryValue){
        int decimal=0;
        int power=binaryValue.length()-1;
        for (int i = 0; i <binaryValue.length();i++ ) {
            int bit=binaryValue.charAt(i)-'0';
//            System.out.println(bit);
            decimal+= bit*(int) Math.pow(2,power--);
        }
        return decimal;
    }

    public static void main(String[] args) {
        String binary=decimalToBinary(202);
        System.out.print(binary+" = ");
        int decimal=binaryToDecimal(binary);
        System.out.println(decimal);
        int[] nums={9,8,7,6,2,4,3,1};
        for(int i=0;i<nums.length;i++){
            int key=nums[i];
            int j=i-1;
            while(j>=0 && nums[j]>key){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=key;
        }
        System.out.println(Arrays.toString(nums));
        ArrayList<Integer> arr=new ArrayList<>();
    }
}