package com.epam.jwd.entity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugeny Zaitsev
 */
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        WholeText wholeText = (WholeText) object;
        return java.util.Objects.equals(blocks, wholeText.blocks);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), blocks);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "WholeText{" +
                "blocks=" + blocks +
                '}';
    }
}