package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Basics {
    public static int majorityElement(int[] nums){
        for(int i=0;i< nums.length;i++ ){
            int count=0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]==nums[j]) count++;
            }
            if(nums.length/2<count){
                return nums[i];
            }
        }
        return 0;
    }

    public static void countEvenAndOdd(int[] nums){
        int oddCount=0;
        int evenCount=0;
        for(int num:nums) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }
        System.out.println("Odd number Count :"+ oddCount);
        System.out.println("Even number Count : "+evenCount);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Length of an array : ");
        int n= scan.nextInt();
        int [] nums=new int[n];
        for (int i=0;i< nums.length;i++){
            nums[i]= scan.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        countEvenAndOdd(nums);
        System.out.println("Majority Elements : "+majorityElement(nums));
        StringBuilder sb1=new StringBuilder("ss");
        StringBuilder sb2=new StringBuilder("ss");
        System.out.println(sb1.toString().equals(sb2.toString()));

    }
}