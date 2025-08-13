package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class DijkstraAlgorithm {

    static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }


    public static int[] findShortestPath(List<List<Edge>> graph, int source) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> {
            if (a.weight == b.weight) return a.target - b.target;
            else return a.weight - b.weight;
        });

        queue.add(new Edge(source, 0));
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int u = current.target;

            for (Edge neighbour : graph.get(u)) {

                int v = neighbour.target;
                int w = neighbour.weight;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    queue.add(new Edge(v, dist[v]));
                }
            }
        }
        return dist;

    }

    public static void main(String[] args) {
        int V = 5; // number of vertices
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Add edges: undirected
        graph.get(0).add(new Edge(1, 4)); // A-B
        graph.get(0).add(new Edge(2, 3)); // A-C
        graph.get(0).add(new Edge(3, 2)); // A-D
        graph.get(1).add(new Edge(3, 2)); // B-D
        graph.get(2).add(new Edge(3, 5)); // C-D

        int[] distances = findShortestPath(graph, 0);

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " : " + distances[i]);

        }
    }
}
