package advanced.graph;

import java.util.*;

public class DijkstraAlgorithm {

    private static class Pair {
        int value;
        int dist;

        public Pair(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        PriorityQueue<Pair> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        minHeap.add(new Pair(src, 0));

        while (!minHeap.isEmpty()) {

            Pair currNode = minHeap.poll();
            List<Pair> neighbours = graph.get(currNode.value);

            int u = currNode.value;

            for (Pair neighbour : neighbours) {
                int w = neighbour.dist; // cost of travel
                int v = neighbour.value;

                if (distance[v] > distance[u] + w) {
                    distance[v] = distance[u] + w;
                    minHeap.add(new Pair(v, distance[v])); // adding the node with travel till now.
                }
            }
        }
        return distance;
    }

    static void main() {

    }
}
