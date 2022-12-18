import Core.Model.Graph;
import Core.Model.VertexPair;
import Core.Utils.GraphUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] informatika = new String[]{"Probabilitas dan Statistika", "Matematika Diskrit", "Sistem Digital", "Aljabar Linear", "Algoritma dan Pemrograman Dasar"};
        String[] elektro = new String[]{"Kelistrikan Dasar", "Elektronika Dasar", "Sistem Digital", "Arus Lemah", "Algoritma dan Pemrograman Dasar"};
        String[] mesin = new String[]{"CNC", "Mesin Bubut", "Mesin", "Mesin", "Mesin"};

        Graph graph = new Graph();
        graph.insert("informatika");
        graph.insert("elektro");
        graph.insert("mesin");

        graph.insertTopics("informatika", informatika);
        graph.insertTopics("elektro", elektro);
        graph.insertTopics("mesin", mesin);



        GraphUtils.calculateTopicSimilarities(graph);
        graph.printAll();
        System.out.println("\nSimilarity Calculation Using Cosine");
        GraphUtils.printVerticesWithSimilarity(graph);
    }
}
