package graph.Directed;

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

    public void addEdge(int from, int to) {
        if (isValid(from) && isValid(to)) {
            adjList.get(from).add(to);
        } else {
            System.out.println("Invalid vertices: " + from + ", " + to);
        }
    }

    public void removeEdge(int from, int to) {
        if (isValid(from) && isValid(to)) {
            adjList.get(from).remove(Integer.valueOf(to));
        } else {
            System.out.println("Invalid vertices: " + from + ", " + to);
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
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Directed Graph:");
        graph.displayGraph();

        System.out.println("\nRemoving edge 1 → 3...");
        graph.removeEdge(1, 3);
        graph.displayGraph();
    }
}