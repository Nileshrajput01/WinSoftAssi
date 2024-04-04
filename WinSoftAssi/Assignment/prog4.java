/* Write a Java Program to find the duplicate characters in a string. */



import java.util.*;

class DuplicateCharacters {
    void findDuplicateCharacters(String str) {
        // Create a HashMap to store characters and their counts
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Convert the string to an array of characters
        char[] characters = str.toCharArray();

        // Iterate through each character in the array
        for (char ch : characters) {
            // If the character is already present in the map, increment its count
            if (charCountMap.containsKey(ch)) {
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            } else {
                // Otherwise, add the character to the map with count 1
                charCountMap.put(ch, 1);
            }
        }

        // Print duplicate characters and their counts
	int count = 0;
        System.out.print("Duplicate characters in the string '" + str + "':");
        for (char ch : charCountMap.keySet()) {
            if (charCountMap.get(ch) > 1) {
                System.out.println(ch + ": " + charCountMap.get(ch) + " occurrences");
		count++;
            }
	}
	if(count == 0){
		System.out.println("0");
	}
    }

    public static void main(String[] args) {
        
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter String");
	
        String str = sc.nextLine();;

	DuplicateCharacters obj = new DuplicateCharacters();
        obj.findDuplicateCharacters(str);

    }
}
