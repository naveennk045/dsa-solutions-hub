package sorting;


import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] nums={4,3,2,1,0,2,6};
        sort(nums,0,nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int start, int end) {
           if(end-start==1) return;

           int mid=start+(end-start)/2;

           sort(nums,start,mid);
           sort(nums,mid,end);

//           System.out.println(Arrays.toString(nums));

           merge(nums,start,mid,end);



    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int[] mergedArray=new int[end-start];

        int i=start;
        int j=mid;
        int k=0;

        while(i<mid && j<end){
            if(nums[i]<nums[j]){
                mergedArray[k++]=nums[i++];
            }else{
                mergedArray[k++]=nums[j++];
            }
        }
        while(i<mid){
            mergedArray[k++]=nums[i++];
        }
        while(j<end){
            mergedArray[k++]=nums[j++];
        }

        System.out.println(Arrays.toString(mergedArray));

        for(int l =0;l< mergedArray.length;l++){
            nums[l+start]=mergedArray[l];
        }

    }
}