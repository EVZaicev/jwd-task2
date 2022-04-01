package com.epam.jwd.entity;

import java.util.List;

public class CodeBlock implements TextElement {
    List<TextElement> blockElememnts;

    public CodeBlock(List<TextElement> blockElememnts) {
        this.blockElememnts = blockElememnts;
    }

    @Override
    public void Add(TextElement text) {

    }

    @Override
    public String getValue() {
        String result = "";
        for (TextElement blockElememnt : blockElememnts) {
            result = result + blockElememnt.getValue();
        }
        return result+"\n";
    }

    @Override
    public List<TextElement> getList() {
        return null;
    }


}
