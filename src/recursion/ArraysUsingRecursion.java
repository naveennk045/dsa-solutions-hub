package recursion;

public class ArraysUsingRecursion {

    public static void main(String[] args) {
        int[] nums={6,9,10,1,2,3,4};
        System.out.println(isSorted(nums,0));
        System.out.println(linearSearch(nums,5,0));
        System.out.println(binarySearch(nums,0,nums.length-1,7));
    }
// binary search in rotated sorted array
    private static boolean binarySearch(int[] nums, int start, int end, int target) {

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

    private static boolean linearSearch(int[] nums, int target,int ind) {
        if(ind== nums.length) return false;
        return nums[ind]==target || linearSearch(nums,target,ind+1);
    }


    private static boolean isSorted(int[] nums,int ind) {
        if (ind == nums.length - 1) return true;
        if (nums[ind] > nums[ind + 1]) return false;

        return isSorted(nums,ind+1);
    }


}