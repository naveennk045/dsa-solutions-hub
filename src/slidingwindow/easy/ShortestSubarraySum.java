    package slidingwindow.easy;

    public class ShortestSubarraySum {




        // Initial implementation: works for some cases but fails for all test cases
        public static  int shortestSubarrayI(int[] nums, int k) {
            int n = nums.length;
            int left = 0, right = 0;
            int minLength = n + 1;
            int sum = 0;

            while (right < n){
                sum+= nums[right];
                while ( sum <= 0 && left <= right ) {
                    sum-= nums[left++];
                }
                while (sum >= k && left <= right){
                    minLength = Math.min(minLength, right-left+1);
                    sum-= nums[left];
                    left++;
                }
                right++;
            }
            if (minLength == n+1) return -1;
            return minLength;
        }

        public static void main(String[] args) {
            int[] nums={2,-1,2};
            System.out.println(shortestSubarrayI(nums,3));
        }
    }