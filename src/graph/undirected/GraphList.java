package graph.undirected;

import java.util.ArrayList;
import java.util.List;

public class GraphList {
    private int noOfVertices;
    private List<List<Integer>> adjList;

    public GraphList(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        if (isValid(vertex1) && isValid(vertex2)) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        } else {
            System.out.println("Invalid vertices: " + vertex1 + ", " + vertex2);
        }
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (isValid(vertex1) && isValid(vertex2)) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
        } else {
            System.out.println("Invalid vertices: " + vertex1 + ", " + vertex2);
        }
    }

    private boolean isValid(int vertex) {
        return vertex >= 0 && vertex < noOfVertices;
    }

    public void displayGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " → ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList graph = new GraphList(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.displayGraph();

        System.out.println("\nRemoving edge between 1 and 4...");
        graph.removeEdge(1, 4);
        graph.displayGraph();
    }
}