package problems.platform.hackerrank;

public class FlatLands {
//    https://www.hackerrank.com/challenges/flatland-space-stations/problem?isFullScreen=true
    static int flatlandSpaceStations(int n, int[] c) {
        int maxDistance = Integer.MIN_VALUE;

        for (int i = 0; i <n ; i++) {
            System.out.println(findMinDistance(i,c));
            maxDistance= Math.max(findMinDistance(i,c),maxDistance);
        }
        return maxDistance;
    }

    private static int findMinDistance(int i, int[] c) {
        int minDistance = Integer.MAX_VALUE;

        for (int k : c) {
            int distance = Math.abs(k - i);
            minDistance = Math.min(distance, minDistance);
        }
        return minDistance;
    }

    public static void main(String[] args) {
        System.out.println(flatlandSpaceStations(5,new int[]{0,4}));
    }
}