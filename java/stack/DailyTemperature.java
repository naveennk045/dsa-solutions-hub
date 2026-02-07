package stack;

import java.util.Stack;

public class DailyTemperature {

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] daysToBeWaited = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int waitingDay = stack.pop();
                daysToBeWaited[waitingDay] = i - waitingDay;
            }
            stack.push(i);
        }


        return daysToBeWaited;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
    }
}
