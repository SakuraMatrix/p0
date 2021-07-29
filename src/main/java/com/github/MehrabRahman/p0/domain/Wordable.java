package com.github.MehrabRahman.p0.domain;

public interface Wordable<T> extends Comparable<Word> {
    String get();
    T sorted();
}
