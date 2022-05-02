package graph.config;

import java.util.Objects;

public class Vertex {

    private final String vertexName;

    public Vertex(String vertexName) {
        this.vertexName = vertexName;
    }

    @Override
    public String toString() {
        return vertexName;
    }

    public String getVertexName() {
        return vertexName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return vertexName.equals(vertex.vertexName);
    }
}
