package domain;

import java.util.Arrays;
import java.util.Objects;

public class Word implements Wordable<Word>{
    private final String value;

    public static Word of(String value) {
        return new Word(value);
    }

    public Word(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

    public Word sorted() {
        char[] letters = this.value.toCharArray();
        Arrays.sort(letters);
        return Word.of(Arrays.toString(letters));
    }

    @Override
    public int compareTo(Word o) {
        return this.value.compareTo(o.get());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
