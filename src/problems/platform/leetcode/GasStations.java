package problems.platform.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class GasStations {
    public static int canCompleteCircuit(int[] gas, int[] costs) {
        int n = gas.length;
        int[][] sortedCosts = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedCosts[i][0] = i;
            sortedCosts[i][1] = costs[i];
        }

        Arrays.sort(sortedCosts, Comparator.comparingInt(a -> a[1]));
        for (int[] num : sortedCosts) {
            System.out.println(Arrays.toString(num));
        }
        int gasTank = 0;
        for (int i = 0; i < n; i++) {
            int station = sortedCosts[i][0];
            gasTank += gas[station];
            System.out.print(gasTank + " -- ");
            gasTank -= sortedCosts[i][1];
            System.out.println(gasTank);
            if (gasTank < 0) return -1;

        }
        return sortedCosts[0][0];
    }

    public static void main(String[] args) {
        int[] costs = {3, 4, 5, 1, 2};
        int[] gas = {1, 2, 3, 4, 5};

        System.out.println(canCompleteCircuit(gas, costs));
    }
}