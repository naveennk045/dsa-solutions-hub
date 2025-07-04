package graph.traversal;

import graph.Graph;
import java.util.*;

public class DFS {
    public static void dfs(Graph<Character> graph, char vertex, boolean[] visited, List<Character> dfsPath) {
        visited[vertex - 'A'] = true;
        dfsPath.add(vertex);

        Map<Character, Integer> neighbours = graph.getAdjList().get(vertex);
        if (neighbours == null) return;

        for (char neighbour : neighbours.keySet()) {
            if (!visited[neighbour - 'A']) {
                dfs(graph, neighbour, visited, dfsPath);
            }
        }
    }

    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>(4, false);
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'D');
        graph.addEdge('A', 'C');

        graph.displayGraph();

        char startingVertex = 'A';
        boolean[] visited = new boolean[26];
        List<Character> dfsPath = new ArrayList<>();

        dfs(graph, startingVertex, visited, dfsPath);
        System.out.println("DFS Traversal: " + dfsPath);
    }
}