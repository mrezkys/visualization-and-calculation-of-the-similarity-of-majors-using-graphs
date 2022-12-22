import Core.Helper.InterfaceHelper;
import Core.Helper.ScannerHelper;
import Core.Model.Graph;
import Core.Model.VertexPair;
import Core.Utils.GraphUtils;

import java.util.List;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // menginisiasi graph
        Graph graph = new Graph();
        // membuat edge
        graph.insert("informatika");
        graph.insert("elektro");
        graph.insert("mesin");

        // mendefinisikan scanner yang akan kita gunakan
        Scanner scanner = new Scanner(System.in);

        // Menggunakan class ScannerHelper yang didalamnya ada fungsi static yang mengembalikan List<String>
        // fungsi tersebut bernama scanTopic
        // membutuhkan 1 parameter sebagai judul yang akan tampil
        List<String> informatika = ScannerHelper.scanTopic(scanner,"informatika");
        List<String> elektro = ScannerHelper.scanTopic(scanner,"elektro");
        List<String> mesin = ScannerHelper.scanTopic(scanner,"mesin");
        // menutup scanner
        scanner.close();

        // memasukkan daftar topik ke setiap vertex
        graph.insertTopics("informatika", informatika);
        graph.insertTopics("elektro", elektro);
        graph.insertTopics("mesin", mesin);

        // memanggil class GraphUtils yang didalamnya terdapat fungsi static yang melakukan proses :
        // 1. perhitungan kemiripan topik berdasarkan data pada topik yang dimasukkan sebelumnya menggunakan algoritma cosine similarity
        // 2. hasil perhitungan tersebut dijadikan pertimbangan untuk melakukan pembuatan edge/penghubung vertex
        // 3. jika hasil perhitungan antara 2 vertex dengan topiknya memiliki kemiripan > 0.0 maka akan dibuat edge yang menghubungkan
        GraphUtils.generateEdgeBasedOnSimilarity(graph);

        // menampilkan hasil dari kalkulasi di atas
        // menyimpan hasil kalkulasi kedalam List of Vertex Pair dari hasil generateVertexPair yang mengembalikan
        // vertex pair yang berisi 2 vertex yang berhubungan dan besaran hubungannya
        List<VertexPair> listSimilarVertexPair = GraphUtils.generateVertexPair(graph);
        VertexPair.printListVertexPair(listSimilarVertexPair);

        // melakukan sorting secara descending dengan metode selection sort untuk mengetahui hubungan tertinggi
        System.out.println("\nSimilarity Calculation Using Cosine (SORTED DESC) : ");
        // memanggil fungsi sort untuk vertexpair
        VertexPair.sort(listSimilarVertexPair);
        // melakukan fungsi print untuk istSimilarVertexPair
        VertexPair.printListVertexPair(listSimilarVertexPair);

        // memanggil perintah printAll untuk menampilkan daftar vertex dan edge
        graph.printAll();

        // memanggil fungsi visualisasi pada class interface helper
        InterfaceHelper.show(graph);

    }
}
