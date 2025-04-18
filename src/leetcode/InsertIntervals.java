package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertIntervals {
    public static int[][] insertII(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> mergedList = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedList.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        mergedList.add(newInterval);
        while (i < intervals.length) {
            mergedList.add(intervals[i++]);
        }

        int[][] insertedArray = new int[mergedList.size()][2];
        int j = 0;
        for (int[] interval : mergedList) {
            insertedArray[j++] = interval;
        }
        return insertedArray;

    }

    public static int[][] insertI(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int idx = 0;
        boolean isAdded = false;

        //        Step - 1 : Merge a new interval
        for (; idx < intervals.length; idx++) {
            if (newInterval[0] <= intervals[idx][1]) {
                intervals[idx][0] = Math.min(intervals[idx][0], newInterval[0]);
                intervals[idx][1] = Math.max(intervals[idx][1], newInterval[1]);
                result.add(intervals[idx]);
                isAdded = true;
                break;
            } else {
                result.add(intervals[idx]);
            }
        }
        if (!isAdded) {
            result.add(newInterval);
        }

        //        Step - 2 merge the overlapping intervals
        for (; idx < intervals.length; idx++) {

            if (!result.isEmpty()) {
                int[] lastInterval = result.getLast();
                if (intervals[idx][0] <= lastInterval[1]) {
                    lastInterval[0] = Math.min(lastInterval[0], intervals[idx][0]);
                    lastInterval[1] = Math.max(lastInterval[1], intervals[idx][1]);
                } else {
                    result.add(intervals[idx]);
                }
            }
        }

        //        Step - 3 Add in arrays
        int[][] insertedArray = new int[result.size()][2];
        int i = 0;
        for (int[] interval : result) {
            insertedArray[i++] = interval;
        }
        return insertedArray;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

//        int[][] result = insertI(intervals, newInterval);
        int[][] result = insertII(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }

    }
}