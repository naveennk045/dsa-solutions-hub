package slidingwindow.counting;

public class CountSubarrays {

//    https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition
    public static int countSubarrays(int[] nums) {

        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(i>=2){
                if(nums[i-1]/2==nums[i-2]+nums[i] && nums[i-1]%2==0) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,4,1};
        System.out.println(countSubarrays(nums));
    }
}