package com.epam.jwd.entity;

import java.util.List;

/**
 * @author Eugeny Zaitsev
 */
public class Paragraph implements TextElement {

    List<TextElement> paragraphs;

    public Paragraph(List<TextElement> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public void Add(TextElement text) {
        paragraphs.add(text);
    }


    @Override
    public String getValue() {
        String result = "";
        for (TextElement paragraph : paragraphs) {
            result = result + paragraph.getValue();
        }

        return result+"\n";
    }

    @Override
    public List<TextElement> getList() {
        return paragraphs;
    }


}
