package com.epam.jwd.entity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WholeText implements TextElement {
    List<TextElement> blocks;

    public WholeText(List<TextElement> paragraphs) {
        this.blocks = paragraphs;
    }

    public void Add(TextElement text) {
        blocks.add(text);
    }

    @Override
    public String getValue() {
        String result = "";
        for (TextElement block : blocks) {
            result = result + block.getValue();
        }
        Pattern p = Pattern.compile("\\d.+(.*)");
        Matcher matcher;
        matcher = p.matcher(result);
        if (!matcher.find()){
        return result;}
        else
        {return result;}
    }

    @Override
    public List<TextElement> getList() {
        return blocks;
    }
}