package com.epam.jwd.entity;

import java.util.List;
import java.util.Objects;

public class CodeBlockElement implements TextElement{
    String value;

    public CodeBlockElement(String value) {
        this.value = value;
    }

    @Override
    public void Add(TextElement text) {

    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public List<TextElement> getList() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeBlockElement that = (CodeBlockElement) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CodeBlockElement{" +
                "value='" + value + '\'' +
                '}';
    }
}
