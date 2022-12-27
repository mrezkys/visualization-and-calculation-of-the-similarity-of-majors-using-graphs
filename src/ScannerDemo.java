import Core.Helper.InterfaceHelper;
import Core.Helper.ScannerHelper;
import Core.Model.Graph;
import Core.Model.VertexPair;
import Core.Utils.GraphUtils;

import java.util.List;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.insert("informatika");
        graph.insert("elektro");
        graph.insert("mesin");

        Scanner scanner = new Scanner(System.in);
        List<String> informatika = ScannerHelper.scanTopic(scanner,"informatika");
        List<String> elektro = ScannerHelper.scanTopic(scanner,"elektro");
        List<String> mesin = ScannerHelper.scanTopic(scanner,"mesin");
        scanner.close();

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
