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
        // menginisiasi graph
        Graph graph = new Graph();
        // membuat edge
        graph.insert("informatika");
        graph.insert("elektro");
        graph.insert("mesin");

        // baru kita masukkan topik ke setiap vertex
        // terdapat fungsi List.of() yang berfungsi untuk mengkonversi string ke array list tipe string
        // hal itu diperlukan karena paremeternya adalah List<String>
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
