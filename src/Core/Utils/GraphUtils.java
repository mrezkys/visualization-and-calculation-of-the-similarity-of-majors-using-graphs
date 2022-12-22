package Core.Utils;

import java.util.ArrayList;
import java.util.List;

import Core.Model.Edge;
import Core.Model.Graph;
import Core.Model.Vertex;
import Core.Model.VertexPair;

public class GraphUtils {

    public static void generateEdgeBasedOnSimilarity(Graph graph) {
    //  Baris kode di atas merupakan deklarasi method generateEdgeBasedOnSimilarity yang menerima parameter berupa objek
        //  Graph yang akan diolah. Method ini digunakan untuk menghitung nilai cosine similarity antara dua vertex pada
        //  graf yang diberikan, kemudian membuat edge antara kedua vertex tersebut jika nilai cosine similarity
        //  tersebut lebih besar dari 0.0.
        // Iterate over all pairs of vertices in the graph
        for (Vertex vertex1 : graph.getVertices()) {
            for (Vertex vertex2 : graph.getVertices()) {
                //  Baris kode di atas merupakan perulangan for yang digunakan untuk menelusuri setiap vertex pada graf yang diberikan.
                //  Pada setiap iterasi, vertex pertama yang sedang ditelusuri disimpan dalam variabel vertex1, sedangkan vertex kedua
                //  yang sedang ditelusuri disimpan dalam variabel vertex2.

                if (vertex1 == vertex2) continue;
                //  Baris kode di atas merupakan statement if yang digunakan untuk memeriksa apakah vertex pertama yang sedang ditelusuri
                //  sama dengan vertex kedua yang sedang ditelusuri. Jika kedua vertex tersebut sama, maka proses iterasi pada perulangan
                //  for akan dilanjutkan ke iterasi selanjutnya dengan menggunakan statement continue.

                double similarity = CosineSimilarity.cosineSimilarity(vertex1.getTopicString(), vertex2.getTopicString());
                //  Baris kode di atas merupakan deklarasi variabel similarity yang digunakan untuk menyimpan nilai cosine similarity antara
                //  dua vertex yang sedang ditelusuri. Nilai cosine similarity dihitung dengan memanggil method cosineSimilarity pada kelas
                //  CosineSimilarity, kemudian mengirimkan sebagai parameter string topic dari vertex pertama yang sedang ditelusuri dan string
                //  topic dari vertex kedua yang sedang ditelusuri.


                if (similarity > 0.0) {
                    Edge edge = new Edge(vertex2, similarity);
                    vertex1.addEdge(edge);
                }
                //  Baris kode di atas merupakan statement if yang digunakan untuk memeriksa apakah nilai cosine similarity antara dua vertex
                //  yang sedang ditelusuri lebih besar dari 0.0. Jika benar, maka akan dibuat objek Edge baru yang berisi informasi tentang
                //  vertex kedua yang sedang ditelusuri dan nilai cosine similarity tersebut. Kemudian, objek Edge tersebut akan ditambahkan
                //  ke dalam list edge pada vertex pertama yang sedang ditelusuri dengan memanggil method addEdge.
            }
        }
    }

    public static List<VertexPair> generateVertexPair(Graph graph) {
        List<VertexPair> similarVertices = new ArrayList<>();
        //  Baris kode di atas merupakan deklarasi dan inisialisasi objek similarVertices dengan tipe data List<VertexPair>,
        //  yang merupakan sebuah list yang akan menyimpan objek VertexPair yang memiliki nilai cosine similarity yang
        //  lebih besar atau sama dengan nilai minimum.

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
        //  Baris kode di atas merupakan perulangan for yang digunakan untuk menelusuri setiap vertex pada graph.
        //  Pada setiap iterasi, dilakukan perulangan for lagi untuk menelusuri setiap vertex pada graph. Kemudian,
        //  dilakukan pengecekan apakah vertex tersebut merupakan vertex yang sama. Jika iya, maka proses perulangan
        //  akan dilompati. Selanjutnya, dilakukan pemanggilan method cosineSimilarity pada kelas CosineSimilarity untuk
        //  menghitung nilai cosine similarity antara dua vertex tersebut. Kemudian, objek VertexPair yang menyimpan
        //  kedua vertex tersebut dan nilai cosine similarity tersebut ditambahkan ke dalam list similarVertices menggunakan method add.

        return similarVertices;
        //  Baris kode di atas mengembalikan list similarVertices yang telah diisi dengan objek VertexPair yang
        //  memiliki nilai cosine similarity yang lebih besar atau sama dengan nilai minimum.
    }

    public static void printVerticesWithSimilarity(Graph graph){
        List<VertexPair> similarVertices = generateVertexPair(graph);
        //  Baris kode di atas merupakan deklarasi dan inisialisasi objek similarVertices dengan tipe data List<VertexPair>,
        //  yang merupakan list yang berisi objek VertexPair yang memiliki nilai cosine similarity yang lebih besar atau
        //  sama dengan nilai minimum. Objek similarVertices diinisialisasi dengan memanggil method
        //  generateVertexPair yang telah dijelaskan sebelumnya.
        for (VertexPair similarVertex : similarVertices) {
            System.out.println(similarVertex.getVertex1().name + " and " + similarVertex.getVertex2().name + " : " + similarVertex.getSimilarity());
        }
        //  Baris kode di atas merupakan perulangan for yang digunakan untuk menelusuri setiap objek VertexPair pada
        //  list similarVertices. Pada setiap iterasi, dilakukan pemanggilan method getVertex1, getVertex2, dan
        //  getSimilarity pada objek VertexPair yang sedang ditelusuri untuk mengambil nama vertex pertama, vertex kedua,
        //  dan nilai cosine similarity masing-masing. Kemudian, informasi tersebut dicetak ke layar menggunakan statement println.
    }

}
