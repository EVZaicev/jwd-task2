package com.epam.jwd.entity;

import java.util.List;

public class Sentence implements TextElement {
    List<TextElement> sentenses;

    public Sentence(List<TextElement> textElements) {
        this.sentenses = textElements;
    }

    @Override
    public void Add(TextElement text) {
        sentenses.add(text);
    }

    @Override
    public String getValue() {
        String result = "";
        for (TextElement sentence : sentenses) {
            result = result + sentence.getValue();
        }

        return result;
    }

    @Override
    public List<TextElement> getList() {
        return sentenses;
    }
    public int getSize(){return sentenses.size();}

        public void setSentenses(List<TextElement> sentenses) {
        this.sentenses = sentenses;
    }
}
