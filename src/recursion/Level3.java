package recursion;

import sorting.Swap;

import java.util.ArrayList;
import java.util.Arrays;

public class Level3 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 9, 3, 2, 0, 2, 3};
//        System.out.println(isSorted(nums,0));
//        System.out.println(linearSearch(nums,5,0));
//        System.out.println(binarySearch(nums,0,nums.length-1,7));
//        bubbleSort(nums,0,nums.length-1);
//        selectionSort(nums,0,nums.length,0);
//        System.out.println(Arrays.toString(nums));
//        nums = mergeSort(nums);
//        System.out.println(Arrays.toString(nums));
        ArrayList<String> list=subSequence("geeks","");
        System.out.println(list);

//        int[] nums1={1,2,3};

//        System.out.println(subSetLoop(nums1));

    }

    public static ArrayList<ArrayList<Integer>> subSetLoop(int[] nums){
        ArrayList<ArrayList<Integer>> finalSet=new ArrayList<>();

        finalSet.add(new ArrayList<>());

        for(int num : nums){
            int size=finalSet.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> temp=new ArrayList<>(finalSet.get(i));
                temp.add(num);
//                System.out.println(temp);
                finalSet.add(temp);
                System.out.println(finalSet);
            }
        }
        return finalSet;
    }

    public static ArrayList<String> subSequence(String str,String res){
        if(str.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(res);
            return list;
        }

        char ch=str.charAt(0);

        ArrayList<String> left= subSequence(str.substring(1),res+ch);
        ArrayList<String> right=subSequence(str.substring(1),res);

        left.addAll(right);

        return left;
    }

    //  binary search in rotated sorted array
    public static boolean binarySearch(int[] nums, int start, int end, int target) {

        if(start>end) return false;

        int mid=start+(end-start)/2;

        if(nums[mid] == target) return true;

        if(nums[start]<=nums[mid]){
            if(target>=nums[start] && target<nums[mid]) return binarySearch(nums,start,mid-1,target);
            return binarySearch(nums,mid+1,end,target);
        }
        if(target>nums[mid] && target<=nums[end]) return binarySearch(nums,mid+1,end,target);
        return binarySearch(nums,start,mid-1,target);
    }

    public static boolean linearSearch(int[] nums, int target, int ind) {
        if(ind== nums.length) return false;
        return nums[ind]==target || linearSearch(nums,target,ind+1);
    }

    public static void bubbleSort(int[] nums, int i, int j) {
        if (j == 0) return;

        if (i < j) {
            if (nums[i] > nums[i + 1]) {
                Swap.swap(nums, i, i + 1);
                bubbleSort(nums, i + 1, j);
            } else {
                bubbleSort(nums, i + 1, j);
            }
        }
        bubbleSort(nums, 0, j - 1);

    }

    public static void selectionSort(int[] nums, int i, int j, int maXInd) {
        if (j < 1) return;
        System.out.printf("i : %d , j : %d%n", i, j);
        if (i < j) {
            if (nums[maXInd] < nums[i]) {
                selectionSort(nums, i + 1, j, i);
            } else {
                selectionSort(nums, i + 1, j, maXInd);
            }
        }
        if (i >= j) {
            Swap.swap(nums, j - 1, maXInd);
            selectionSort(nums, 0, j - 1, 0);
        }
    }

    public static int[] mergeSort(int[] nums) {
        if (nums.length == 1) return nums;
        int mid = nums.length / 2;
        int[] leftNums = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] rightNums = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(leftNums, rightNums);
    }

    private static int[] merge(int[] leftNums, int[] rightNums) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] mergedArray = new int[leftNums.length + rightNums.length];

        while (i < leftNums.length && j < rightNums.length) {
            if (leftNums[i] < rightNums[j]) {
                mergedArray[k++] = leftNums[i++];
            } else {
                mergedArray[k++] = rightNums[j++];
            }
        }
        while (i < leftNums.length) {
            mergedArray[k++] = leftNums[i++];
        }
        while (j < rightNums.length) {
            mergedArray[k++] = rightNums[j++];
        }
        return mergedArray;
    }

    public static boolean isSorted(int[] nums, int ind) {
        if (ind == nums.length - 1) return true;
        if (nums[ind] > nums[ind + 1]) return false;

        return isSorted(nums,ind+1);
    }


}