import domain.Dictionary;
import domain.Word;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Scrabble {
    public static void main(String[] args) {
        // specify a dictionary to scan
        Path filepath = Paths.get(args[0]);
        Dictionary dictionary = Dictionary.of(filepath);

        // specify available tiles to match
        Word tiles = Word.of(args[1]);

        // search for words and their anagrams
        // System.out.println(dictionary.scan().search(tiles));
        System.out.println(dictionary.stream().search(tiles));
    }
}