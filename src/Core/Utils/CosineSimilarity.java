package Core.Utils;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// Merupakan statement yang digunakan untuk mengimport kelas HashMap, HashSet, Map, dan Set dari package java.util.
// Kelas HashMap dan Map digunakan untuk menyimpan pasangan kunci-nilai yang tidak terurut,
// sedangkan kelas HashSet dan Set digunakan untuk menyimpan daftar objek tanpa menyertakan objek duplikat.


public class CosineSimilarity {
    public static double cosineSimilarity(String text1, String text2) {
        // split the strings into arrays of words
        String[] words1 = text1.split(" ");
        String[] words2 = text2.split(" ");
        // String[] words1 = text1.split(" "); String[] words2 = text2.split(" ");:
        // Merupakan statement yang digunakan untuk memecah teks yang diberikan menjadi array of words (daftar kata)
        // dengan menggunakan delimiter spasi. Hasil dari pemecahan tersebut akan disimpan pada array words1 dan words2.

        // build maps of word frequencies for each string
        Map<String, Integer> frequencies1 = getWordFrequencies(words1);
        Map<String, Integer> frequencies2 = getWordFrequencies(words2);
        // Map<String, Integer> frequencies1 = getWordFrequencies(words1);
        // Map<String, Integer> frequencies2 = getWordFrequencies(words2);:
        // Merupakan statement yang digunakan untuk memanggil method getWordFrequencies dengan parameter
        // words1 dan words2 yang masing-masing merupakan array of words dari teks text1 dan text2.
        // Hasil dari pemanggilan method tersebut akan disimpan pada objek Map dengan nama frequencies1 dan frequencies2.
        // Method getWordFrequencies akan mengembalikan objek Map yang menyimpan frekuensi dari setiap kata yang ada pada teks yang diberikan.

        // get the set of all words in both strings
        Set<String> uniqueWords = getUniqueWords(frequencies1, frequencies2);
        // Merupakan statement yang digunakan untuk memanggil method getUniqueWords dengan
        // parameter frequencies1 dan frequencies2 yang masing-masing merupakan objek Map yang menyimpan frekuensi dari
        // setiap kata pada teks text1 dan text2. Hasil dari pemanggilan method tersebut akan disimpan pada objek Set
        // dengan nama uniqueWords.  Method getUniqueWords akan mengembalikan objek Set yang menyimpan daftar kata yang
        // unik dari kedua teks yang diberikan.

        // calculate the dot product of the two frequency vectors
        double dotProduct = dotProduct(frequencies1, frequencies2, uniqueWords);
        // Merupakan statement yang digunakan untuk memanggil method dotProduct dengan parameter frequencies1, frequencies2,
        // dan uniqueWords. Hasil dari pemanggilan method tersebut akan disimpan pada variabel dotProduct. Method dotProduct
        // akan menghitung dot product dari dua vektor frekuensi yang diberikan. Vektor frekuensi merupakan daftar frekuensi
        // dari setiap kata yang ada pada teks, dimana setiap elemen pada vektor merupakan frekuensi dari kata tersebut pada teks.

        // calculate the magnitudes of the two frequency vectors
        double magnitude1 = magnitude(frequencies1, uniqueWords);
        double magnitude2 = magnitude(frequencies2, uniqueWords);
        // Merupakan statement yang digunakan untuk memanggil method magnitude dengan parameter frequencies1, frequencies2,
        // dan uniqueWords. Hasil dari pemanggilan method tersebut akan disimpan pada variabel magnitude1 dan magnitude2.
        // Method magnitude akan menghitung magnitude dari sebuah vektor frekuensi yang diberikan.
        // Magnitude merupakan panjang vektor yang dihitung dengan mengakar dari kuadrat dari setiap elemen pada vektor.

        // calculate the cosine similarity
        return dotProduct / (magnitude1 * magnitude2);
        //  Merupakan statement yang digunakan untuk menghitung nilai cosine similarity dengan menggunakan rumus
        //  dotProduct / (magnitude1 * magnitude2). Nilai yang dihasilkan akan dikembalikan kepada pemanggil
        //  method cosineSimilarity.
    }

    private static Map<String, Integer> getWordFrequencies(String[] words) {

        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            int count = frequencies.getOrDefault(word, 0);
            frequencies.put(word, count + 1);
        }
        return frequencies;

        //  for (String word : words) { ... }:
        //  Merupakan perulangan for yang digunakan untuk mengelola setiap kata pada array words.
        //  Pada setiap iterasi, kata yang sedang diterima akan disimpan pada variabel word.

        //  int count = frequencies.getOrDefault(word, 0);:
        //  Merupakan statement yang digunakan untuk mengambil nilai dari elemen word pada objek Map dengan nama frequencies.
        //  Jika elemen word tidak ada pada objek Map, maka akan dikembalikan nilai default yaitu 0.
        //  Nilai yang dihasilkan akan disimpan pada variabel count.

        //  frequencies.put(word, count + 1);:
        //  Merupakan statement yang digunakan untuk menambahkan elemen baru pada objek Map dengan nama frequencies.
        //  Elemen yang ditambahkan merupakan pasangan kata dan frekuensi.
        //  Kata yang ditambahkan merupakan variabel word dan frekuensi yang ditambahkan merupakan nilai dari count + 1.
    }

    private static Set<String> getUniqueWords(Map<String, Integer> frequencies1, Map<String, Integer> frequencies2) {
        Set<String> uniqueWords = new HashSet<>(frequencies1.keySet());
        uniqueWords.addAll(frequencies2.keySet());
        return uniqueWords;
        //  uniqueWords.addAll(frequencies2.keySet());:
        //  Merupakan statement yang digunakan untuk menambahkan semua elemen yang ada pada objek Set dengan nama
        //  frequencies2.keySet() ke dalam objek Set dengan nama uniqueWords.
    }

    private static double dotProduct(Map<String, Integer> frequencies1, Map<String, Integer> frequencies2, Set<String> uniqueWords) {
        double dotProduct = 0;
        for (String word : uniqueWords) {
            dotProduct += frequencies1.getOrDefault(word, 0) * frequencies2.getOrDefault(word, 0);
        }
        return dotProduct;
        //  double dotProduct = 0;:
        //  Merupakan statement yang digunakan untuk mendeklarasikan variabel dotProduct dengan nilai awal 0.
        //  Variabel dotProduct akan menyimpan hasil perkalian dari setiap elemen pada vektor frekuensi yang sesuai.

        //  for (String word : uniqueWords) { ... }:
        //  Merupakan perulangan for yang digunakan untuk mengelola setiap elemen pada objek Set dengan nama uniqueWords.
        //  Pada setiap iterasi, elemen yang sedang diterima akan disimpan pada variabel word.

        //  dotProduct += frequencies1.getOrDefault(word, 0) * frequencies2.getOrDefault(word, 0);:
        //  Merupakan statement yang digunakan untuk menambahkan hasil perkalian dari frekuensi dari word pada objek Map
        //  dengan nama frequencies1 dan frekuensi dari word pada objek Map dengan nama frequencies2. Jika elemen word
        //  tidak ada pada salah satu objek Map, maka akan dikembalikan nilai default yaitu 0.
    }
    private static double magnitude(Map<String, Integer> frequencies, Set<String> uniqueWords) {
        double magnitude = 0;
        for (String word : uniqueWords) {
            magnitude += Math.pow(frequencies.getOrDefault(word, 0), 2);
        }
        return Math.sqrt(magnitude);
        //  for (String word : uniqueWords) { ... }:
        //  Merupakan perulangan for yang digunakan untuk mengelola setiap elemen pada objek Set dengan nama uniqueWords.
        //  Pada setiap iterasi, elemen yang sedang diterima akan disimpan pada variabel word.

        //  magnitude += Math.pow(frequencies.getOrDefault(word, 0), 2);:
        //  Merupakan statement yang digunakan untuk menambahkan hasil dari perpangkatan frekuensi dari word pada objek
        //  Map dengan nama frequencies. Jika elemen word tidak ada pada objek Map, maka akan dikembalikan nilai default
        //  yaitu 0.

        //  Mengapa perlu mengembalikan nilai akar dari magnitude? Hal ini dikarenakan magnitude pada vektor frekuensi
        //  didefinisikan sebagai akar dari hasil perpangkatan dari setiap elemen pada vektor frekuensi.
        //  Oleh karena itu, untuk menghitung nilai magnitude dari sebuah vektor frekuensi, perlu dilakukan operasi akar
        //  pada hasil perpangkatan dari setiap elemen pada vektor frekuensi tersebut.

        //  Dengan demikian, statement return Math.sqrt(magnitude);
        //  digunakan untuk mengembalikan nilai akar dari magnitude, sehingga nilai yang dihasilkan merupakan nilai
        //  magnitude yang sesungguhnya dari vektor frekuensi tersebut.
    }
}
