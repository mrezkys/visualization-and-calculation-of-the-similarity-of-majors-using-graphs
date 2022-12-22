package Core.Helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

//Deklarasi kelas JsonHelper yang berisi method readAndConvertToList yang digunakan untuk membaca file JSON dan mengkonversinya
// menjadi list. Kelas ini juga mengimport kelas Gson, TypeToken, BufferedReader, FileReader, IOException, dan Type dari library yang diperlukan.
public class JsonHelper {
    //  Deklarasi method readAndConvertToList yang menerima parameter path yang merupakan lokasi file JSON yang akan dibaca.
    //  Method ini akan mengembalikan sebuah list of string. Method ini juga menangkap kemungkinan terjadinya exception IOException
    //  yang mungkin terjadi ketika membaca file.
    public  static List<String> readAndConvertToList(String path) throws IOException {

        //   Membaca file JSON dengan menggunakan BufferedReader dan memasukkannya ke dalam objek StringBuilder.
        //   Kemudian membaca setiap baris dari file dengan menggunakan perulangan while dan menambahkannya ke objek StringBuilder.
        //   Setelah seluruh baris dari file terbaca, tutup objek BufferedReader dengan menggunakan method close.
        //   Kemudian konversi objek StringBuilder menjadi string dengan menggunakan method toString.
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        String json = builder.toString();

        // Inisialisasi objek gson bertipe Gson yang digunakan untuk mem-parse data JSON. ( GSON merupakan depedency tambahan )
        Gson gson = new Gson();
        //  Inisialisasi objek listType bertipe Type yang digunakan sebagai parameter untuk method fromJson() dari objek gson. TypeToken digunakan untuk menyatakan tipe data yang akan dikembalikan oleh method fromJson().
        Type listType = new TypeToken<List<String>>() {}.getType();
        //  Melakukan parsing data JSON yang terdapat dalam string json ke dalam bentuk list bertipe string. Hasil parsing disimpan dalam objek res bertipe List<String>.
        List<String> res = gson.fromJson(json, listType);
        //  Mengembalikan objek res yang merupakan hasil parsing data JSON kepada pemanggil method.
        return  res;
    }
}
