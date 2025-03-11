package arrays;

import sorting.Swap;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums={1,0,2,3,0,4,5,0};
        int i=0;
        int j=0;
       while(j< nums.length){
           if(nums[j]!=0){
               Swap.swap(nums,i,j);
               i++;
               j++;
           }else{
               j++;
           }

       }
        System.out.println(Arrays.toString(nums));
    }
}