package Core.Utils;

import java.util.ArrayList;
import java.util.List;

import Core.Model.Edge;
import Core.Model.Graph;
import Core.Model.Vertex;
import Core.Model.VertexPair;

public class GraphUtils {

    public static void generateEdgeBasedOnSimilarity(Graph graph) {
        for (Vertex vertex1 : graph.getVertices()) {
            for (Vertex vertex2 : graph.getVertices()) {
                if (vertex1 == vertex2) continue;
                double similarity = CosineSimilarity.cosineSimilarity(vertex1.getTopicString(), vertex2.getTopicString());

                if (similarity > 0.0) {
                    Edge edge = new Edge(vertex2, similarity);
                    vertex1.addEdge(edge);
                }
            }
        }
    }

    public static List<VertexPair> generateVertexPair(Graph graph) {
        List<VertexPair> similarVertices = new ArrayList<>();
        // Iterate over all pairs of vertices in the graph
        for (Vertex vertex1 : graph.getVertices()) {
            for (Vertex vertex2 : graph.getVertices()) {
                // Skip the vertex itself
                if (vertex1 == vertex2) continue;
                // Calculate the cosine similarity of the two vertices
                double similarity = CosineSimilarity.cosineSimilarity(vertex1.getTopicString(), vertex2.getTopicString());

                // If the similarity is greater than or equal to the minimum similarity, add the pair of vertices to the list
                similarVertices.add(new VertexPair(vertex1, vertex2, similarity));
            }
        }
        return similarVertices;
    }

    public static void printVerticesWithSimilarity(Graph graph){
        List<VertexPair> similarVertices = generateVertexPair(graph);
        for (VertexPair similarVertex : similarVertices) {
            System.out.println(similarVertex.getVertex1().name + " and " + similarVertex.getVertex2().name + " : " + similarVertex.getSimilarity());
        }
    }

}
