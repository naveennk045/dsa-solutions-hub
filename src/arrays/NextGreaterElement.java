package arrays;

import java.util.Arrays;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        int[] array= nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(array));

    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    for (int k = j; k < nums2.length ; k++) {
                        if(j==nums2.length-1) {
                            nums1[i]=-1;
                        }
                        if(nums2[j]<nums2[k]){
                            nums1[i]=nums2[k];
                            break;
                        }
                        else{
                            nums1[i]=-1;
                        }
                    }
                    break;}


            }

        }
        return nums1; }

}