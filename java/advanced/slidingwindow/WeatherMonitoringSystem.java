package advanced.slidingwindow;

import java.util.*;

public class WeatherMonitoringSystem {

    public static int monitorWeather(int[] nums, int k) {

        int minElement = Integer.MAX_VALUE;

        Deque<Integer> queue = new ArrayDeque<>();

        for (int left = 0, right = 0; right < nums.length; right++) {

            while (!queue.isEmpty() && queue.peekFirst() < left) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.add(right);

            if (right >= k - 1) {
                if (!queue.isEmpty()) {
                    minElement = Math.min(minElement, nums[queue.peekFirst()]);
                    System.out.println(nums[queue.peekFirst()]);
                }
                left++;
            }
        }

        return minElement;
    }

    static void main() {
        int min = monitorWeather(new int[]{80, 70, 85, 90, 95, 100, 90}, 4);
        System.out.println(min);

    }
}
