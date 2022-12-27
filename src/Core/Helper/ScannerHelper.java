package Core.Helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerHelper {
    public static List<String> scanTopic(Scanner scanner, String title){
        List<String> topics = new ArrayList<>();

        while (true) {
            System.out.print("Enter a topic for "+ title +" (use 'q' to quit): ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }

            topics.add(input);
        }
        return topics;
    }
}
