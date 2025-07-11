package graph;

import java.util.HashMap;
import java.util.Map;

public class    Graph<T> {
    private int noOfVertices;
    private boolean isDirected;
    private HashMap<T, HashMap<T, Integer>> adjList;  // use can also use your custom datatype for storing weight

    public Graph(int noOfVertices, boolean isDirected) {
        this.noOfVertices = noOfVertices;
        this.isDirected = isDirected;
        this.adjList = new HashMap<>();
    }

    public void addEdge(T vertex1, T vertex2, int weight) {
        adjList.putIfAbsent(vertex1, new HashMap<>());
        adjList.putIfAbsent(vertex2, new HashMap<>());
        adjList.get(vertex1).put(vertex2, weight);
        if (!isDirected) {
            adjList.get(vertex2).put(vertex1, weight);
        }
    }

    public void addEdge(T vertex1, T vertex2) {
        addEdge(vertex1, vertex2, 0);
    }

    public HashMap<T, HashMap<T, Integer>> getAdjList() {
        return adjList;
    }

    public void removeEdge(T vertex1, T vertex2) {
        if (adjList.containsKey(vertex1)) {
            adjList.get(vertex1).remove(vertex2);
        }
        if (!isDirected && adjList.containsKey(vertex2)) {
            adjList.get(vertex2).remove(vertex1);
        }
    }


    public void displayGraph() {
        for (Map.Entry<T, HashMap<T, Integer>> entry : adjList.entrySet()) {
            T vertex = entry.getKey();
            HashMap<T, Integer> neighbors = entry.getValue();
            System.out.print(vertex + " → ");
            for (Map.Entry<T, Integer> neighbor : neighbors.entrySet()) {
                System.out.print("(" + neighbor.getKey() + ", " + neighbor.getValue() + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(5, false);  // false = undirected

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 5);
        graph.addEdge("D", "E");

        System.out.println("Graph before removing edge:");
        graph.displayGraph();

        System.out.println("\nRemoving edge B ↔ C");
        graph.removeEdge("B", "C");

        System.out.println("\nGraph after removing edge:");
        graph.displayGraph();
    }
}