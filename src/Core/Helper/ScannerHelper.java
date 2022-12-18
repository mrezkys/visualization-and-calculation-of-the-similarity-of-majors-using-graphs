package Core.Helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerHelper {
    public static List<String> scanTopic(Scanner scanner, String title){
        // Create an empty list of topics
        List<String> topics = new ArrayList<>();

        // Read user input using a Scanner
        while (true) {
            System.out.print("Enter a "+ title +" (or 'q' to quit): ");
            String input = scanner.nextLine();

            // Check if the user wants to quit
            if (input.equals("q")) {
                break;
            }

            // Add the input to the list of topics
            topics.add(input);
        }

        // Close the Scanner

        // Print the list of topics
        return topics;
    }
}
