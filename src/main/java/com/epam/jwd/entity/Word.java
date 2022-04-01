package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class Word implements TextElement {
    String value;

    public Word(String value) {
        this.value = value;
    }

    @Override
    public void Add(TextElement text) {
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {

        return value+" ";
    }

    @Override
    public List<TextElement> getList() {
        return null;
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
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }
}
