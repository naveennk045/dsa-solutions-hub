package problems.platform.leetcode;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        for (int i = 0; i <nums.length; i++) {
            int j=i;
            int currCount=0;
            while(j<nums.length && nums[j]==1){
                currCount++;
                j++;
            }
            count=Math.max(currCount,count);
        }
        return count;
    }
    public static void main(String[] args) {

        int[] nums={1,1,0,1,0,1,1,0,1};
        int count=findMaxConsecutiveOnes(nums);
        System.out.println(count);

    }
}