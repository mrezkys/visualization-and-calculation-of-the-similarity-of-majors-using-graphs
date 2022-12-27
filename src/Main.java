import Core.Helper.InterfaceHelper;
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

        graph.insertTopics("informatika", List.of(new String[]{
                "Probabilitas dan Statistika",
                "Matematika Diskrit",
                "Sistem Digital",
                "Aljabar Linear",
                "Algoritma dan Pemrograman Dasar"
        }));
        graph.insertTopics("elektro", List.of(new String[]{
                "Kelistrikan Dasar",
                "Elektronika Dasar",
                "Sistem Digital",
                "Arus Lemah",
                "Algoritma dan Pemrograman Dasar"
        }));
        graph.insertTopics("mesin", List.of(new String[]{
                "CNC",
                "Mesin Bubut",
                "Mesin",
                "Mesin",
                "Mesin"
        }));

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
