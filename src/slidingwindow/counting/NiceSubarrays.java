package slidingwindow.counting;

public class NiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {

        return countLessThanKOddElements(nums,k)-countLessThanKOddElements(nums,k-1);
    }

    public static int countLessThanKOddElements(int[] nums , int k){
        int n=nums.length , left=0,count=0,oddCount=0;
        for (int right = 0; right < n; right++) {
            oddCount+=(nums[right]%2==0) ? 0 :1;

            while(oddCount>k){
                oddCount-=(nums[left]%2==0) ? 0 :1;
                left++;
            }

            count+=right-left+1;

        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums,2));
    }
}