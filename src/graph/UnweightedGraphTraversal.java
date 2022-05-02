package graph;

import graph.config.Graph;
import graph.config.Vertex;
import graph.config.VertexNames;

import java.util.*;

/**
 * Обход невзвешенного графа в ширину и глубину.
 */
public class UnweightedGraphTraversal {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(VertexNames.ALICE);
        graph.addVertex(VertexNames.BOB);
        graph.addVertex(VertexNames.MARK);
        graph.addVertex(VertexNames.MARIA);
        graph.addVertex(VertexNames.ROB);

        graph.addEdge(VertexNames.ALICE, VertexNames.BOB);
        graph.addEdge(VertexNames.BOB, VertexNames.MARK);
        graph.addEdge(VertexNames.MARK, VertexNames.MARIA);
        graph.addEdge(VertexNames.ALICE, VertexNames.ROB);
        graph.addEdge(VertexNames.ROB, VertexNames.MARIA);

        Set<String> visitedWidth = breadthFirstTraversal(graph, VertexNames.ALICE);
        System.out.println("Обход в ширину: " + visitedWidth);

        Set<String> visitedDepth = depthFirstTraversal(graph, VertexNames.ALICE);
        System.out.println("Обход в глубину: " + visitedDepth);

    }

    /**
     * Алгоритм поиска в ширину позволяет определить, существует ли путь от одной вершины до другой.
     * Обход начинается с произвольной вершины и исследует соседние вершины прежде, чем углубляться в глубину
     */
    public static Set<String> breadthFirstTraversal(Graph graph, String startVertexName) {
        Set<String> visited = new LinkedHashSet<>();
        visited.add(startVertexName);

        Queue<String> queue = new LinkedList<>();
        queue.add(startVertexName);

        while (!queue.isEmpty()) {
            String vertexName = queue.poll();
            for (Vertex vertex : graph.getAdjacentVertices(vertexName)) {
                if (!visited.contains(vertex.getVertexName())) {
                    visited.add(vertex.getVertexName());
                    queue.add(vertex.getVertexName());
                }
            }
        }
        return visited;
    }

    /**
     * Обход в глубину исследует вершины как можно глубже вдоль каждой ветки прежде, чем исследовать вершины того же уровня
     */
    public static Set<String> depthFirstTraversal(Graph graph, String startVertexName) {
        Set<String> visited = new LinkedHashSet<>();

        Deque<String> stack = new ArrayDeque<>();
        stack.push(startVertexName);

        while (!stack.isEmpty()) {
            String vertexName = stack.pop();
            if (!visited.contains(vertexName)) {
                visited.add(vertexName);
                for (Vertex vertex : graph.getAdjacentVertices(vertexName)) {
                    stack.push(vertex.getVertexName());
                }
            }
        }
        return visited;
    }
}
