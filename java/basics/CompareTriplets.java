package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true
public class CompareTriplets {
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScore = 0;
        int bobScore = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) aliceScore += 1;
            else if (a.get(i) < b.get(i)) bobScore += 1;
        }

        return new ArrayList<>(Arrays.asList(aliceScore, bobScore));
    }


    public static void main(String[] args) {

    }
}
