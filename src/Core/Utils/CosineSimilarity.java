package Core.Utils;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CosineSimilarity {
    public static double cosineSimilarity(String text1, String text2) {
        // split the strings into arrays of words
        String[] words1 = text1.split(" ");
        String[] words2 = text2.split(" ");

        // build maps of word frequencies for each string
        Map<String, Integer> frequencies1 = getWordFrequencies(words1);
        Map<String, Integer> frequencies2 = getWordFrequencies(words2);

        // get the set of all words in both strings
        Set<String> uniqueWords = getUniqueWords(frequencies1, frequencies2);

        // calculate the dot product of the two frequency vectors
        double dotProduct = dotProduct(frequencies1, frequencies2, uniqueWords);

        // calculate the magnitudes of the two frequency vectors
        double magnitude1 = magnitude(frequencies1, uniqueWords);
        double magnitude2 = magnitude(frequencies2, uniqueWords);

        // calculate the cosine similarity
        return dotProduct / (magnitude1 * magnitude2);
    }

    private static Map<String, Integer> getWordFrequencies(String[] words) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            int count = frequencies.getOrDefault(word, 0);
            frequencies.put(word, count + 1);
        }
        return frequencies;
    }

    private static Set<String> getUniqueWords(Map<String, Integer> frequencies1, Map<String, Integer> frequencies2) {
        Set<String> uniqueWords = new HashSet<>(frequencies1.keySet());
        uniqueWords.addAll(frequencies2.keySet());
        return uniqueWords;
    }

    private static double dotProduct(Map<String, Integer> frequencies1, Map<String, Integer> frequencies2, Set<String> uniqueWords) {
        double dotProduct = 0;
        for (String word : uniqueWords) {
            dotProduct += frequencies1.getOrDefault(word, 0) * frequencies2.getOrDefault(word, 0);
        }
        return dotProduct;
    }
    private static double magnitude(Map<String, Integer> frequencies, Set<String> uniqueWords) {
        double magnitude = 0;
        for (String word : uniqueWords) {
            magnitude += Math.pow(frequencies.getOrDefault(word, 0), 2);
        }
        return Math.sqrt(magnitude);
    }
}
