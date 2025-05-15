package slidingwindow.easy;

//https://leetcode.com/problems/max-consecutive-ones-iii/description/
//https://www.geeksforgeeks.org/problems/maximize-number-of-1s0905/0

public class MaximumConsecutiveOnesIII {
    public static int consecutiveSubsegments(char[] nums,int k){
        int max=0;
        int start=0,end=0,zeroCount=0;

        while(end< nums.length){
            if(nums[end]=='0') zeroCount++;

            if(zeroCount<=k){
                max=Math.max(end-start,max);
            }
            else{
                zeroCount=0;
                start=end;
            }
            end++;
        }
        return max;
    }

    //  Brute-force approach
    public static int maxConsecutiveOnesI(int[] nums,int k){
        int maxLength=-1;

        for (int i = 0; i < nums.length; i++) {
            int zeroCount=0;
            for (int j=i;j<nums.length;j++){
                if(nums[j]==0) zeroCount++;
                if(zeroCount<=k){
                    maxLength=Math.max(maxLength,j-i+1);
                }else break;
            }
        }
        return maxLength;
    }

    public static int maxConsecutiveOnesII(int[] nums,int k){
        int left=0 , right=0 , zeroCount=0;
        int maxLength=-1;
        while (right < nums.length){
            if(nums[right]==0) zeroCount++;
            if(zeroCount<=k) maxLength=Math.max(maxLength,right-left+1);
            else{
                while(nums[left]!=0)left++;
                left++;
                zeroCount--;
            }
            right++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums={1,0,1,0,1,1,0,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,1};
        System.out.println(maxConsecutiveOnesI(nums,5));
        System.out.println(maxConsecutiveOnesII(nums,5));

    }
}