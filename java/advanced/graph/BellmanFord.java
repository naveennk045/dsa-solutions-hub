package advanced.graph;

import java.util.*;


public class BellmanFord {

    public int[] bellmanFord(int V, int[][] edges, int src) {

        int MAX_VALUE =  (int)Math.pow(10,8);
        int[] distance = new int[V];
        Arrays.fill(distance,MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if (distance[u] != MAX_VALUE
                        && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            if (distance[u] != MAX_VALUE
                    && distance[u] + w < distance[v]) {
                return new int[]{-1};
            }
        }
        return distance;
    }

    static void main() {

    }
}
