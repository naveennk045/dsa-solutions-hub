package solvedproblems.platform.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RelativeRanks {

    public static String[] findRelativeRanksII(int[] scores) {
        int n = scores.length;
        HashMap<Integer, Integer> indexStore = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexStore.put(scores[i], i);
        }

        Arrays.sort(scores);

        int rank = 1;
        String[] answer = new String[scores.length];

        for (int i = n - 1; i >= 0; i--) {
            int score = scores[i];
            if (rank == 1) answer[indexStore.get(score)] = "Gold Medal";
            if (rank == 2) answer[indexStore.get(score)] = "Silver Medal";
            if (rank == 3) answer[indexStore.get(score)] = "Bronze Medal";
            if (rank > 3) answer[indexStore.get(score)] = "" + rank;
            rank++;
        }
        return answer;
    }

    public static String[] findRelativeRanksI(int[] scores) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> indexStore = new HashMap<>();

        for (int i = 0; i < scores.length; i++) {
            indexStore.put(scores[i], i);
        }


        //  add the scores to priority queue.
        for (int score : scores) {
            queue.add(score);
        }

        int rank = 1;
        String[] answer = new String[scores.length];
        while (!queue.isEmpty()) {
            int score = queue.poll();
            if (rank == 1) answer[indexStore.get(score)] = "Gold Medal";
            if (rank == 2) answer[indexStore.get(score)] = "Silver Medal";
            if (rank == 3) answer[indexStore.get(score)] = "Bronze Medal";
            if (rank > 3) answer[indexStore.get(score)] = "" + rank;
            rank++;
        }
        return answer;

    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findRelativeRanksI(new int[]{10, 3, 8, 9, 4})));
        System.out.println(Arrays.toString(findRelativeRanksII(new int[]{10, 3, 8, 9, 4})));
    }
}