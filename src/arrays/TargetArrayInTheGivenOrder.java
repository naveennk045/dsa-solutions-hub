package arrays;

//https://leetcode.com/problems/create-target-array-in-the-given-order/description/

import java.util.Arrays;

public class TargetArrayInTheGivenOrder {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target=new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            if (index[i] >= i) {
                target[index[i]]=nums[i];
            } else {
                moveArrayElements(target,index[i],i);
                target[index[i]]=nums[i];
            }

        }
        return target;
    }
    
    public static void moveArrayElements(int[] arr,int start,int end){

        for (int i = end-1; i >=start; i--) {
           arr[i+1]=arr[i];
        }
    }
    public static void main(String[] args) {
        int[] nums={0,1,2,3,4};
        int[] index={0,1,2,2,1};

        System.out.println(Arrays.toString(createTargetArray(nums,index)));

    }
}