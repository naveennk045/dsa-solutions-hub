package slidingwindow.grokking.questions;

public class DietPlanPerformance {
    //    https://leetcode.ca/2019-02-18-1176-Diet-Plan-Performance/
    public static int performance(int[] calories, int lower, int upper, int k) {

        int sum = 0;
        int points = 0;

        for (int i = 0; i < calories.length; i++) {
            sum += calories[i];

            if (i >= k - 1) {
                if (sum < lower) points--;
                if (sum > upper) points++;
                sum -= calories[i-k+1];
            }
        }
        return points;
    }

    public static void main(String[] args) {
        int points = performance(new int[]{1, 2, 3, 4, 5}, 3, 3, 1);
        System.out.println(points);
    }
}