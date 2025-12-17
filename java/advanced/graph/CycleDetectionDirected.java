package advanced.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDirected {

    private static boolean hasCycle(int vertices, List<int[]> edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < edges.size(); i++) {
            int from = edges.get(i)[0];
            int to = edges.get(i)[1];

            graph.get(from).add(to);
        }


        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            visited[i] = true;
            if (hasCycleUtils(graph, visited, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycleUtils(List<List<Integer>> graph, boolean[] visited, int currentVertex) {

        List<Integer> neighbours = graph.get(currentVertex);


        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                if (hasCycleUtils(graph, visited, neighbour)) {
                    return true;
                }
            } else {
                return true;
            }
        }

        visited[currentVertex] = false;
        return false;
    }

    public static void main(String[] args) {

        // 1️⃣ Simple linear graph (No cycle)
        testCase(1, 4, List.of(
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3}
        ));

        // 2️⃣ Simple cycle
        testCase(2, 3, List.of(
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 0}
        ));

        // 3️⃣ Self loop
        testCase(3, 3, List.of(
                new int[]{0, 1},
                new int[]{1, 1}
        ));

        // 4️⃣ Disconnected graph (one component has cycle)
        testCase(4, 6, List.of(
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{4, 5},
                new int[]{5, 3}
        ));

        // 5️⃣ Disconnected graph (no cycle)
        testCase(5, 6, List.of(
                new int[]{0, 1},
                new int[]{2, 3},
                new int[]{4, 5}
        ));

        // 6️⃣ Complex graph with back edge
        testCase(6, 5, List.of(
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 1}
        ));

        // 7️⃣ Diamond shape (no cycle)
        testCase(7, 4, List.of(
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{2, 3}
        ));

        // 8️⃣ Multiple cycles
        testCase(8, 6, List.of(
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{4, 2}
        ));

        // 9️⃣ Single node no edge
        testCase(9, 1, List.of());

        // 🔟 Single node self-cycle
        testCase(10, 1, List.of(
                new int[]{0, 0}
        ));
    }

    private static void testCase(int id, int vertices, List<int[]> edges) {
        System.out.println(
                "Test Case " + id + " -> " +
                        (hasCycle(vertices, edges) ? "Cycle Detected" : "No Cycle")
        );
    }
}
