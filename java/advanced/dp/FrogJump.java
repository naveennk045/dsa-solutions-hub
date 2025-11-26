package advanced.dp;

public class FrogJump {

    public static void main(String[] args) {

        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int n = nums.length;
        int k = 3;
        int subarraySum = 0;
        int maxSubarraySum = 0;
        for (int left = 0, right = 0; right < n; right++) {

            if (right >= k) {
                maxSubarraySum = Math.max(maxSubarraySum, subarraySum);
                subarraySum -= nums[left];
                left++;
            }

            subarraySum += nums[right];
        }
        System.out.println(subarraySum);
    }

    public static boolean canCross(int[] stones) {
        return canCrossUtilsV1(stones, 0);
    }

    public static boolean canCrossUtilsV1(int[] stones, int idx) {

        /*
         * This is my first version of the frog-jump solution, I wrongly understood the question
         * The mistake I did not reading the question well and directly jumped into the solution.
         */

        if (idx == stones.length - 1) return true;
        if (idx >= stones.length || idx < 0) return false;

        int k = stones[idx];

        boolean case1 = canCrossUtilsV1(stones, idx + (k + 1));

        boolean case2 = false;
        if (idx > idx + (k - 1))
            case2 = canCrossUtilsV1(stones, idx + (k - 1));

        boolean case3 = canCrossUtilsV1(stones, idx + k);

        return case1 || case2 || case3;
    }
}
