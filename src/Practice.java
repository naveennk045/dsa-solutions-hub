// You are using Java

import java.util.*;

public class Practice{
    public static int[] sort(int[] nums){
        if(nums.length==1) return nums;
        int mid=nums.length/2;

       int[] left= sort(Arrays.copyOfRange(nums,0,mid));
       int[] right=sort(Arrays.copyOfRange(nums,mid,nums.length));

        return merge(left,right);


    }


    private static int[] merge(int[] left, int[] right) {
        int i=0;
        int j=0;
        int k=0;
        int[] arr=new int[left.length+ right.length];


        while(i < left.length && j< right.length){
            if(left[i]<right[j]){
                arr[k++]=left[i++];
            }else {
                arr[k++]=right[j++];
            }
        }
        while (i< left.length){
            arr[k++]=left[i++];
        }
        while (i< right.length){
            arr[k++]=right[i++];
        }
        return arr;
    }

    public static void main(String[] args){

    }
}