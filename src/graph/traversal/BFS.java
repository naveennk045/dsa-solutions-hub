package graph.traversal;

import graph.Graph;

import java.util.*;

public class BFS {


    public static List<Character> bfs(Graph<Character> graph, char startingVertex) {
        List<Character> bfsPath = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();

        boolean[] visited = new boolean[26];
        visited[startingVertex - 'A'] = true;
        queue.add(startingVertex);

        while (!queue.isEmpty()) {
            char currentVertex = queue.poll();
            bfsPath.add(currentVertex);
            HashMap<Character, Integer> neighbours = graph.getAdjList().get(currentVertex);
            for (char neighbour : neighbours.keySet()) {
                if (!visited[neighbour - 'A']) {
                    visited[neighbour - 'A'] = true;
                    queue.add(neighbour);
                }
            }
        }
        return bfsPath;
    }

    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>(4, false);
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'D');
        graph.addEdge('A', 'C');

        graph.displayGraph();
        System.out.println("DFS Traversal: " + bfs(graph, 'A'));

    }
}