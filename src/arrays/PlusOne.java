package arrays;

import java.util.Arrays;

public class PlusOne {

    public static int toInteger(int[] numberArray){
        int number=0;

        for(int digit:numberArray){
            number=number*10+digit;
        }
        return number;
    }

    public static int[] plusOneArray(int length,int number){
        if((number%10+1)>=10){
            length+=1;
        }

        int [] numberArray=new int[length];
        number+=1;
        length-=1;
        while(number!=0){
            int tempDigit=number%10;
            numberArray[length]=tempDigit;
            number/=10;
            length--;
        }
        return numberArray;
    }

    public static void main(String[] args) {

        int[] nums={8,9,9,9};
        if(nums[nums.length-1] +1>=10){
            int number= toInteger(nums);
            System.out.println(number);
            int[] numberArray=plusOneArray(nums.length,number);
            System.out.println(Arrays.toString(numberArray));
        }
        else{
            nums[nums.length-1]+=1;
            System.out.println(Arrays.toString(nums));
        }

    }
}