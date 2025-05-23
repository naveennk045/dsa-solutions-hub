package problems.platform.leetcode;

public class HiddenSequenceCounter {
    public static int numberOfArrays(int[] differences, int lower, int upper) {

        long currSum = 0;
        long minElement = 0;
        long maxElement = 0;


        for (int difference : differences) {
            currSum += difference;
            maxElement = Math.max(maxElement, currSum);
            minElement = Math.min(minElement, currSum);
        }

        long minStart = lower - minElement;
        long maxStart = upper - maxElement;

        return (int)Math.max(0, maxStart - minStart + 1);

    }
    public static void main(String[] args) {
        int[] differences = {-40};
        int lower = -46;
        int upper = 53;

        System.out.println(numberOfArrays(differences, lower, upper)); // Expected: 60
    }
}