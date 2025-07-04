package graph.undirected;

public class GraphMatrix {
    private int[][] adjMatrix;
    private int noOfVertices;

    public GraphMatrix(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjMatrix = new int[noOfVertices][noOfVertices];
    }

    public void addEdge(int vertex1, int vertex2) {
        if(!isValid(vertex1) || !isValid(vertex2)) {
            throw new RuntimeException("Invalid vertex");
        }
        adjMatrix[vertex1 - 1][vertex2 - 1] = 1;
        adjMatrix[vertex2 - 1][vertex1 - 1] = 1;
    }
    public void removeEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1 - 1][vertex2 - 1] = 0;
        adjMatrix[vertex2 - 1][vertex1 - 1] = 0;
    }

    public boolean hasEdge(int vertex1, int vertex2) {
        return adjMatrix[vertex1 - 1][vertex2 - 1] == 1;
    }

    private boolean isValid(int vertex) {
        return vertex >= 1 && vertex <= noOfVertices;
    }



    public void displayGraph() {
        for (int[] row : adjMatrix) {
            for (int vertex : row) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("Undirected Graph - Adjacency Matrix:");
        graph.displayGraph();
    }
}