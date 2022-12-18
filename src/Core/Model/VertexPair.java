package Core.Model;


public class VertexPair {
    private final Vertex vertex1;
    private final Vertex vertex2;
    private final double similarity;

    public VertexPair(Vertex vertex1, Vertex vertex2, double similarity) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.similarity = similarity;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public double getSimilarity() {
        return similarity;
    }
}