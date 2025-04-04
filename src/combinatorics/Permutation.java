package combinatorics;

import java.util.Arrays;

public class Permutation {
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void permute(int[] nums,int fi){

        if (fi==nums.length-1){
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = fi; i < nums.length; i++) {
            swap(nums,i,fi);
            System.out.printf("fi : %d i : %d%n",fi,i);
            permute(nums,fi+1);

            swap(nums,i,fi);
        }

    }
    public static void main(String[] args) {
        permute(new int[]{1,2,3},0);
    }
}