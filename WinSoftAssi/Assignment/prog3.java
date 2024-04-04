/* Write a Java Program to count the number of words in a string using HashMap. */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WordCounter {
    
    public static Map<String, Integer> countWords(String str) {
        // Remove leading and trailing whitespaces
        str = str.trim();
        // Split the string into words
        String[] words = str.split("\\s+");
        
        // Create a HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        // Count the occurrence of each word
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        
        return wordCountMap;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input string from the user
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        
        // Count words in the input string
        Map<String, Integer> wordCountMap = countWords(inputString);
        
        // Display word counts for the input string
        System.out.println("Word counts:");
        System.out.println(wordCountMap);
        
        scanner.close();
    }
}
