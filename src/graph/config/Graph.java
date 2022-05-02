package graph.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Vertex, List<Vertex>> adjacency = new LinkedHashMap<>();

    public void addVertex(String vertexName) {
        adjacency.putIfAbsent(new Vertex(vertexName), new ArrayList<>());
    }

    public void removeVertex(String vertexName) {
        Vertex vertexToRemove = new Vertex(vertexName);
        adjacency.values().forEach(item -> item.remove(vertexToRemove));
        adjacency.remove(new Vertex(vertexName));
    }

    public void addEdge(String vertexName1, String vertexName2) {
        Vertex vertex1 = new Vertex(vertexName1);
        Vertex vertex2 = new Vertex(vertexName2);
        adjacency.get(vertex1).add(vertex2);
        adjacency.get(vertex2).add(vertex1);
    }

    public void removeEdge(String vertexName1, String vertexName2) {
        Vertex vertex1 = new Vertex(vertexName1);
        Vertex vertex2 = new Vertex(vertexName2);

        List<Vertex> vertexList1 = adjacency.get(vertex1);
        List<Vertex> vertexList2 = adjacency.get(vertex2);

        if (vertexList1 != null) {
            vertexList1.remove(vertex2);
        }

        if (vertexList2 != null) {
            vertexList2.remove(vertex1);
        }
    }

    public List<Vertex> getAdjacentVertices(String vertexName) {
        return adjacency.get(new Vertex(vertexName));
    }


}
