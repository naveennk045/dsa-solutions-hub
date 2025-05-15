package solvedproblems.platform.leetcode;

import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/summary-ranges/

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String>  list=new ArrayList<>();
        if(nums.length==0) {
            return list;
        }
        if(nums.length==1){
            list.add(""+nums[0]);
            return list;
        }
        int start=nums[0];
        int end=0;

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1!=nums[i+1]){
                end=nums[i];
                if(start==end){
                    list.add(""+start);
                }else{
                    String val=String.format("%d->%d",start,end);
                    // System.out.println(val);
                    list.add(val);
                }
                start=nums[i+1];
            }
        }
        end=nums[nums.length-1];

        if(start==end){
            list.add(""+start);
        }else{
            list.add(String.format("%d->%d",start,end));
        }

        return list;

    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}