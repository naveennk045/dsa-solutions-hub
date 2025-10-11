package hackerrank;


import java.util.Arrays;
import java.util.List;

public class InsertionSortShiftCount {

    /*
     * This is the brute force approach I have used to solve this problem
     */
    public static int countShiftsI(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int key = nums[i];

            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
                count++;
            }

            nums[j + 1] = key;
        }
        return count;
    }

    /*
     * This is the optimized approach, using the merge sort
     */
    public static int countShiftUtils(List<Integer> nums, int low, int high) {

        int count = 0;
        if (low >= high ) return count;

        int mid = low + (high - low) / 2;
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums.toArray(),low,mid)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums.toArray(),mid,high+1)));
        countShiftUtils(nums, low, mid);
        countShiftUtils(nums, mid+1, high);

//        count += m
        return 0;
    }

//    public static int merge(List<Integer> nums, int low, int mid, int high) {
//
//    }

    public static void main(String[] args) {
        Integer[] nums = {2, 1, 3, 1, 2};
        countShiftUtils(Arrays.asList(nums),0,nums.length-1);


    }
}
