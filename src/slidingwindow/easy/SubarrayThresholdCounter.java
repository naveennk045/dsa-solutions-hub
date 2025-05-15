package slidingwindow.easy;

// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

public class SubarrayThresholdCounter {
    public static int numOfSubArrays(int[] arr, int k, int threshold) {

        int count = 0;
        int sum = 0;
        for (int i = 0; i < k; i++){
            sum+= arr[i];
        }

        if (sum/k >= threshold) count++;

        for (int right = k; right < arr.length; right++){
            sum+= arr[right] - arr[right-k];
            if(sum/k >= threshold) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3 , 4, 6};
        System.out.println(numOfSubArrays(nums,3,7));
    }
}