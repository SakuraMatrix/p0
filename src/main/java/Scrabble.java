import domain.Word;

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
        String tiles = alphabetize(args[1]).get();

	// search for words and their anagrams
        Map<Word, Set<Word>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String value = s.next();
                Word word = Word.of(value);
                groups.computeIfAbsent(word.sorted(), (x) -> new TreeSet<>()).add(word);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Failed to parse the file.");
        }

        if (groups.containsKey(Word.of(tiles)))
            System.out.println(groups.get(Word.of(tiles)));
    }

    public static Word alphabetize(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new Word(Arrays.toString(letters));
    }
}