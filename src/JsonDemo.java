import Core.Helper.InterfaceHelper;
import Core.Helper.JsonHelper;
import Core.Model.Graph;
import Core.Model.VertexPair;
import Core.Utils.GraphUtils;

import java.io.IOException;
import java.util.List;

public class JsonDemo {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        graph.insert("informatika");
        graph.insert("elektro");
        graph.insert("mesin");

        List<String> informatika = JsonHelper.readAndConvertToList("src/resources/informatika.json");
        List<String> elektro = JsonHelper.readAndConvertToList("src/resources/elektro.json");
        List<String> mesin = JsonHelper.readAndConvertToList("src/resources/mesin.json");

        graph.insertTopics("informatika", informatika);
        graph.insertTopics("elektro", elektro);
        graph.insertTopics("mesin", mesin);


        GraphUtils.generateEdgeBasedOnSimilarity(graph);

        List<VertexPair> listSimilarVertexPair = GraphUtils.generateVertexPair(graph);
        VertexPair.printListVertexPair(listSimilarVertexPair);

        System.out.println("\nSimilarity Calculation Using Cosine (SORTED DESC) : ");
        VertexPair.sort(listSimilarVertexPair);
        VertexPair.printListVertexPair(listSimilarVertexPair);

        graph.printAll();

        InterfaceHelper.show(graph);

    }
}
