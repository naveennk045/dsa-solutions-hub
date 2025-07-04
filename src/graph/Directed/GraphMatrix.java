package graph.Directed;


public class GraphMatrix {
    private int[][] adjMatrix;
    private int noOfVertices;

    public GraphMatrix(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjMatrix = new int[noOfVertices][noOfVertices];
    }

    public void addEdge(int from, int to) {
        adjMatrix[from - 1][to - 1] = 1;
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (isValid(vertex1, vertex2)) {
            adjMatrix[vertex1 - 1][vertex2 - 1] = 0;
        }
    }

    // Check if edge exists from vertex1 to vertex2
    public boolean hasEdge(int vertex1, int vertex2) {
        return isValid(vertex1, vertex2) && adjMatrix[vertex1 - 1][vertex2 - 1] == 1;
    }

    public void displayGraph() {
        for (int[] row : adjMatrix) {
            for (int vertex : row) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    private boolean isValid(int vertex1, int vertex2) {
        if (vertex1 < 1 || vertex2 < 1 || vertex1 > noOfVertices || vertex2 > noOfVertices) {
            System.out.println("Invalid vertices: " + vertex1 + ", " + vertex2);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("Adjacency Matrix:");
        graph.displayGraph();
    }
}