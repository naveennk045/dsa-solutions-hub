package recursion;

public class ArraysUsingRecursion {

    public static void main(String[] args) {
        int[] nums={1,2,6,4,6,9,10};
        System.out.println(isSorted(nums,0));
        System.out.println(linearSearch(nums,5,0));
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