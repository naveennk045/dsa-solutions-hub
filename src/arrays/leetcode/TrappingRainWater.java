package arrays.leetcode;

public class TrappingRainWater {

    public static int trapI(int[] height) {
        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {

            int left = i;
            int leftMax = height[i];
            while (left >= 0) {
                leftMax = Math.max(leftMax, height[left]);
                left--;
            }

            int right = i;
            int rightMax = height[i];
            while (right < height.length) {
                rightMax = Math.max(rightMax, height[right]);
                right++;
            }
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }
        return totalWater;
    }

    public static int trapII(int[] height) {

        int totalWater = 0;

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];

        while (left < right) {

            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                System.out.println(leftMax);
                totalWater += Math.min(leftMax, rightMax) - height[left];
                left++;
            } else {
                System.out.println(rightMax);
                rightMax = Math.max(rightMax, height[right]);
                totalWater += Math.min(leftMax, rightMax) - height[right];
                right--;
            }
        }
        return totalWater;
    }


    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapI(heights));
        System.out.println(trapII(heights));
    }
}
