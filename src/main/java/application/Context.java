package application;

import domain.Dictionary;
import domain.Word;

import java.nio.file.Paths;
import java.util.Set;

public class Context {
    private Dictionary dictionary;
    private Word tiles;

    public Context(String ...args) {
        this.dictionary = Dictionary.of(Paths.get(args[0]));
        this.tiles = Word.of(args[1]);
    }

    public Set<Word> searchTiles() {
        return dictionary.stream().search(tiles);
    }
}
