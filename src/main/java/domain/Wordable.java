package domain;

public interface Wordable<T> extends Comparable<Word> {
    String get();
    T sorted();
}
