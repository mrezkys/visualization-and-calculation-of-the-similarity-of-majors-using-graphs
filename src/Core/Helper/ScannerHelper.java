package Core.Helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerHelper {
    // Merupakan deklarasi kelas ScannerHelper yang memiliki satu method yaitu scanTopic.
    // Method ini digunakan untuk membaca input pengguna menggunakan Scanner, kemudian menambahkan input tersebut ke dalam list topik.
    // Pengguna dapat menghentikan input dengan mengetikkan "q". Setelah input selesai, method akan mengembalikan list topik yang telah dibuat.
    public static List<String> scanTopic(Scanner scanner, String title){
        // Create an empty list of topics
        List<String> topics = new ArrayList<>();
        //  Mendeklarasikan variabel bernama topics yang merupakan list string yang digunakan untuk menyimpan topik-topik yang diinput oleh user.

        //  Memulai loop yang akan terus berjalan selama kondisi benar. Nanti akan dihentikan dengan kondisi
        while (true) {
            //  Mencetak prompt yang meminta user untuk memasukkan topik, disertai dengan informasi bahwa user dapat menggunakan "q" untuk keluar dari loop.
            System.out.print("Enter a topic for "+ title +" (use 'q' to quit): ");
            //  Mendeklarasikan variabel bernama input yang berisi input yang diinput oleh user melalui object Scanner.
            String input = scanner.nextLine();

            //  Jika input yang diinput oleh user adalah "q", maka akan melakukan break dari loop.
            if (input.equals("q")) {
                break;
            }

            // Menambahkan input ke dalam list topics
            topics.add(input);
        }
        // mengembalikan data hasil inputan tadi
        return topics;
    }
}
