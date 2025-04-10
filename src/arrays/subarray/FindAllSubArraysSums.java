package arrays.subarray;


public class FindAllSubArraysSums {

    public static void findUsingBruteForceApproach(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                System.out.print(sum + " ");
            }
        }

    }

    public static void findUsingPrefix(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum;
                if (i == 0) {
                    sum = prefixSum[j];
                } else {
                    sum = prefixSum[j] - prefixSum[i - 1];
                }
                System.out.print(sum + " ");
            }
        }
    }

    public static void findUsingRunningSum(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                System.out.print(sum + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        findUsingBruteForceApproach(nums);
        System.out.println();
        findUsingPrefix(nums);
        System.out.println();
        findUsingRunningSum(nums);

    }
}