package com.github.MehrabRahman.p0.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.stream.Collectors.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Dictionary {
    private static final Logger log = LoggerFactory.getLogger(Dictionary.class);
    private final Path filepath;
    private Map<Word, Set<Word>> words;

    private Dictionary(Path filepath) {
        this.filepath = filepath;
        this.words = new HashMap<>();
    }

    public static Dictionary of(Path filepath) {
        return new Dictionary(filepath);
    }

    public Dictionary scan() {
        try (Scanner s = new Scanner(this.filepath)) {
            while (s.hasNext()) {
                String value = s.next();
                Word word = Word.of(value);
                words.computeIfAbsent(word.sorted(), (x) -> new TreeSet<>()).add(word);
            }
        } catch (IOException ex) {
            log.error("Failed to parse the file.");
        }
        return this;
    }

    public Dictionary stream() {
        try (Stream<String> lines = Files.lines(this.filepath)) {
            words = lines.map(Word::of)
                    .collect(groupingBy(Word::sorted, mapping(i -> i, toSet())));
        } catch (IOException ex) {
            log.error("Failed to stream the file.");
        }
        return this;
    }

    public Set<Word> search(Word tiles) {
        return words.get(tiles.sorted());
    }
}
