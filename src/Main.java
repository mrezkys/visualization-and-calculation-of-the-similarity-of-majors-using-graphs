import Core.Helper.JsonHelper;
import Core.Helper.ScannerHelper;
import Core.Model.Graph;
import Core.Model.VertexPair;
import Core.Utils.GraphPanel;
import Core.Utils.GraphUtils;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        graph.insert("informatika");
        graph.insert("elektro");
        graph.insert("mesin");



        // get with json
        List<String> informatika = JsonHelper.readAndConvertToList("src/resources/informatika.json");
        List<String> elektro = JsonHelper.readAndConvertToList("src/resources/mesin.json");
        List<String> mesin = JsonHelper.readAndConvertToList("src/resources/elektro.json");

//        get with scanner
//        Scanner scanner = new Scanner(System.in);
//        List<String> informatika = ScannerHelper.scanTopic(scanner,"informatika");
//        List<String> elektro = ScannerHelper.scanTopic(scanner,"elektro");
//        List<String> mesin = ScannerHelper.scanTopic(scanner,"mesin");
//        scanner.close();


        graph.insertTopics("informatika", informatika.toArray(new String[0]));
        graph.insertTopics("elektro", elektro.toArray(new String[0]));
        graph.insertTopics("mesin", mesin.toArray(new String[0]));



        // generate edge with similarity
        GraphUtils.calculateTopicSimilarities(graph);

        //print all vertex
        graph.printAll();

        // print similarity calculation
        System.out.println("\nSimilarity Calculation Using Cosine : ");
        GraphUtils.printVerticesWithSimilarity(graph);

        // print similarity calculation sorted
        System.out.println("\nSimilarity Calculation Using Cosine (SORTED DESC) : ");
        List<VertexPair> listSimilar = GraphUtils.getSimilarVertices(graph);
        VertexPair.sort(listSimilar);
        VertexPair.printListVertexPair(listSimilar);





        // Create the GraphPanel and add it to a JFrame window
        GraphPanel panel = new GraphPanel(graph);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
