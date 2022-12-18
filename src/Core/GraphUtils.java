package Core;

import java.util.ArrayList;
import java.util.List;

import BasicGraph.Edge;
import BasicGraph.Graph;
import BasicGraph.Vertex;

public class GraphUtils {

    public static void calculateTopicSimilarities(Graph graph) {
        // Iterate over all pairs of vertices in the graph
        for (Vertex vertex1 : graph.getVertices()) {
            for (Vertex vertex2 : graph.getVertices()) {
                // Skip the vertex itself
                if (vertex1 == vertex2) continue;

                // Calculate the cosine similarity of the two vertices
                double similarity = CosineSimilarity.cosineSimilarity(vertex1.getTopicString(), vertex2.getTopicString());

                // If the similarity is greater than 0.0, create an edge between the two vertices
                if (similarity > 0.0) {
                    Edge edge = new Edge(vertex2, similarity);
                    vertex1.addEdge(edge);
                }
            }
        }
    }

    public static List<VertexPair> getSimilarVertices(Graph graph, double minSimilarity) {
        List<VertexPair> similarVertices = new ArrayList<>();

        // Iterate over all pairs of vertices in the graph
        for (Vertex vertex1 : graph.getVertices()) {
            for (Vertex vertex2 : graph.getVertices()) {
                // Skip the vertex itself
                if (vertex1 == vertex2) continue;

                // Calculate the cosine similarity of the two vertices
                double similarity = CosineSimilarity.cosineSimilarity(vertex1.getTopicString(), vertex2.getTopicString());

                // If the similarity is greater than or equal to the minimum similarity, add the pair of vertices to the list
                if (similarity >= minSimilarity) {
                    similarVertices.add(new VertexPair(vertex1, vertex2, similarity));
                }
            }
        }

        return similarVertices;
    }

    public static class VertexPair {
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
}
