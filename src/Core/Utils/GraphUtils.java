package Core.Utils;

import java.util.ArrayList;
import java.util.List;

import Core.Model.Edge;
import Core.Model.Graph;
import Core.Model.Vertex;
import Core.Model.VertexPair;
import Core.Utils.CosineSimilarity;

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

    public static List<VertexPair> getSimilarVertices(Graph graph) {
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
        List<VertexPair> similarVertices = getSimilarVertices(graph);
        for (VertexPair similarVertex : similarVertices) {
            System.out.println(similarVertex.getVertex1().name + " and " + similarVertex.getVertex2().name + " : " + similarVertex.getSimilarity());
        }
    }

}
