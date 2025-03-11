package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.geeksforgeeks.org/sum-triangle-from-array/

public class SumOfTriangle {

    public static List<int[]> sumOfTriangle(int[] nums,List<int[]> list){
        list.add(nums);

        int[] currNums=new int[nums.length-1];

        if(nums.length==1){
             return list;
        }
        for(int i=0;i<nums.length-1;i++){
            currNums[i]=nums[i]+nums[i+1];
        }
        return sumOfTriangle(currNums,list);

    }
    public static void main(String[] args) {
        List<int[]> list= (sumOfTriangle(new int[]{1,2,3,4,5},new ArrayList<>()));
        for(int[] nums : list){
            System.out.println(Arrays.toString(nums));
        }
    }
}