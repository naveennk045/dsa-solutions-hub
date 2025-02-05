package arrays;

public class MinSubArraySum {
    public static int subArraySum(int[] nums,int target){
        int l=0;
        int r=0;
        int sum=0;
        int min=nums.length+1;
        while(r<nums.length){
            sum+=nums[r];
            if(sum>target){
                sum-=nums[l];
                l++;
            }
            if(sum>=target) min=Math.min(min,r-l+1);
            r++;

            System.out.println(sum);
        }
        if(min==nums.length+1) return 0;
        return min;
    }
    public static void main(String[] args) {
        int[] nums= {5,6,4,2,5};

        System.out.println(subArraySum(nums,7));
    }
}