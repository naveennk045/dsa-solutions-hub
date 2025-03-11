//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Solution {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3,7,5},12));
    }
    static ArrayList<Integer> subarraySum(int[] nums, int target) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();

        int left=0;
        int right=0;
        int length=nums.length;
        int sum=0;
        while(right<length){
           sum+=nums[right];
           if(sum>target){
                sum-=nums[left];
                left++;
             }
//            System.out.println(sum);
            if(sum==target){
                list.add(left+1);
                list.add(right+1);
                return list;
            }

            right++;
            System.out.printf("left : %d , right : %d%n",left,right);
        }

        list.add(-1);
        return list;


    }
}