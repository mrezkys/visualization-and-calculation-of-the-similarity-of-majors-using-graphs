package Core.Model;


import java.util.List;

public class VertexPair {
    private final Vertex vertex1;
    private final Vertex vertex2;
    private final double similarity;

    public VertexPair(Vertex vertex1, Vertex vertex2, double similarity) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.similarity = similarity;
    }

    // mengembalikan nilai atribut vertex1
    public Vertex getVertex1() {
        return vertex1;
    }

    // mengembalikan nilai atribut vertex2
    public Vertex getVertex2() {
        return vertex2;
    }

    // mengembalikan nilai atribut similarity
    public double getSimilarity() {
        return similarity;
    }

    //  Method printListVertexPair akan mencetak nama vertex dan nilai similarity untuk setiap objek VertexPair yang ada
    //  di dalam list yang diberikan sebagai parameter. Method sort akan mengurutkan list VertexPair berdasarkan nilai
    //  similarity dengan menggunakan algoritma selection sort. Pada setiap iterasi, method ini akan mencari VertexPair
    //  dengan nilai similarity terbesar dan menukarkannya dengan VertexPair yang ada pada posisi saat ini di list.
    //  Proses ini akan diulang sampai list terurut dari yang terbesar ke yang terkecil berdasarkan nilai similarity.
    public static void printListVertexPair(List<VertexPair> list){
        for (VertexPair element : list){
            System.out.println(element.getVertex1().name + " and " + element.getVertex2().name + " : " + element.getSimilarity());
        }
    }

    //  Fungsi sort pada kelas VertexPair menggunakan algoritma sorting selection sort untuk mengurutkan list pairs dari
    //  VertexPair berdasarkan nilai similarity dari setiap objek VertexPair. Algoritma ini bekerja dengan cara mencari
    //  objek VertexPair dengan nilai similarity terbesar pada list dan menukarnya dengan objek VertexPair pada posisi
    //  saat ini dalam list. Proses ini diulangi sampai list terurut dari nilai similarity yang paling besar ke yang paling kecil.
    public static void sort(List<VertexPair> pairs) {
        for (int i = 0; i < pairs.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < pairs.size(); j++) {
                if (pairs.get(j).similarity > pairs.get(maxIndex).similarity) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                VertexPair temp = pairs.get(i);
                pairs.set(i, pairs.get(maxIndex));
                pairs.set(maxIndex, temp);
            }
        }
        //  Fungsi ini menggunakan dua loop. Loop pertama for (int i = 0; i < pairs.size() - 1; i++)
        //  akan mengiterasi setiap objek VertexPair pada list pairs.
        //  Pada setiap iterasi, loop kedua for (int j = i + 1; j < pairs.size(); j++)
        //  akan mencari objek VertexPair dengan nilai similarity terbesar dari sisa list pairs yang belum diurutkan.
        //  Jika objek VertexPair dengan similarity terbesar ditemukan, maka indeksnya disimpan dalam variabel maxIndex.
        //  Kemudian, jika maxIndex tidak sama dengan indeks saat ini dari loop pertama (i),
        //  maka objek VertexPair pada posisi i dan maxIndex ditukar menggunakan variabel sementara temp.
        //  Proses ini diulang sampai loop pertama selesai.
    }
}