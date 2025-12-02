package advanced.graph;

import java.util.Arrays;

public class BellmanFord {

    public int[] bellmanFord(int V, int[][] edges, int src) {

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        /*
        First we need to write the edges, and we need to find the shortest path for v times
        Right now, I have idea to find the shortest path using bfs , run loop for another v times
        If there is the negative cycle edge means we cannot be able to find the shortest path for all.
        */



        return distance;
    }

    static void main() {

    }
}
