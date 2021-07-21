import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Scrabble {
    public static void main(String[] args) {  
	// specify a dictionary to scan
        File dictionary = new File(args[0]);

    // specify available tiles to match
        String tiles = args[1];

	// search for words and their anagrams
        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (x) -> new TreeSet<>()).add(word);
            }
        } catch (FileNotFoundException ex) {}

        for (Set<String> group : groups.values())
            if (group.size() >= 2)
                System.out.println(group);
    }

    private static String alphabetize(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}