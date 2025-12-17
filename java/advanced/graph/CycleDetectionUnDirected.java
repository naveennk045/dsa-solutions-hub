package advanced.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionUnDirected {

    public boolean isCycle(int V, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleUtils(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycleUtils(List<List<Integer>> graph, boolean[] visited, int currVertex, int parent) {

        visited[currVertex] = true;
        List<Integer> neighbours = graph.get(currVertex);

        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                if (isCycleUtils(graph, visited, neighbour, currVertex)) {
                    return true;
                }
            } else if (parent != currVertex) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
