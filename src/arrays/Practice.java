package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {

    public static void sumOfElements(int[] nums){
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
        }
        System.out.println(sum);

    }


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt() ;
        int[] nums=new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        sumOfElements(nums);
        int min=nums[0];
        for(int i=1;i<n;i++){
            if(min>nums[i]){
                min=nums[i];
            }

        }
        System.out.println(min);
        int[] arr={5,6,7,8,9};
        System.out.println(arr[3]);
    }

}