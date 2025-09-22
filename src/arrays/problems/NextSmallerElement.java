package arrays.problems;


import java.util.Arrays;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums1={8,4,6,2,3};
        int val=0;
        for (int i = 0; i < nums1.length ; i++) {
            val=nextSmallerElement2(nums1,i);
            if(val!=-1){
                nums1[i]=nums1[i]-val;
            }
        }
        System.out.println(Arrays.toString(nums1));


        int[] nums2={13, 7, 6, 12};
        System.out.println(Arrays.toString(nextSmallerElement1(nums2)));


    }
    public static int[] nextSmallerElement1(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = -1; // Default to -1 if no smaller element is found
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    arr[i] = nums[j];
                    break;
                }
            }
        }
        return arr;
    }

    public static int nextSmallerElement2(int[] nums,int ind) {
        for (int i = ind+1; i < nums.length; i++) {
            if (nums[ind] >nums[i]) {
                return nums[i];
            }
        }
        return -1;}
 }