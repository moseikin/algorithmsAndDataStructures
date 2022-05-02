package graph;

import graph.config.Graph;
import graph.config.VertexNames;

/**
 * Пример взят с: https://www.baeldung.com/java-graphs
 */

public class SimpleExample {

    private static final String REGULAR_EXP = "%s: %s %n";

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(VertexNames.ALICE);
        graph.addVertex(VertexNames.BOB);
        graph.addVertex(VertexNames.MARK);
        graph.addVertex(VertexNames.MARIA);
        graph.addVertex(VertexNames.ROB);

        graph.addEdge(VertexNames.ALICE, VertexNames.BOB);
        graph.addEdge(VertexNames.ALICE, VertexNames.MARIA);
        graph.addEdge(VertexNames.BOB, VertexNames.ROB);
        graph.addEdge(VertexNames.ROB, VertexNames.MARK);
        graph.addEdge(VertexNames.ROB, VertexNames.MARIA);
        graph.addEdge(VertexNames.MARK, VertexNames.ALICE);

        System.out.println("Смежные вершины");
        System.out.printf(REGULAR_EXP, VertexNames.ALICE, graph.getAdjacentVertices(VertexNames.ALICE));
        System.out.printf(REGULAR_EXP, VertexNames.BOB, graph.getAdjacentVertices(VertexNames.BOB));
        System.out.printf(REGULAR_EXP, VertexNames.MARIA, graph.getAdjacentVertices(VertexNames.MARIA));
        System.out.printf(REGULAR_EXP, VertexNames.MARK, graph.getAdjacentVertices(VertexNames.MARK));
        System.out.printf(REGULAR_EXP, VertexNames.ROB, graph.getAdjacentVertices(VertexNames.ROB));

    }
}
