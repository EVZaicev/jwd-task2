package com.epam.jwd.logic;

import com.epam.jwd.entity.TextElement;

import java.util.Comparator;
import java.util.List;

public class SentenceComparator implements Comparator<List<TextElement>> {


//    @Override
//    public int compare(TextElement o1, TextElement o2) {
//        return o1.getValue().length() - o2.getValue().length();
//    }

    @Override
    public int compare(List<TextElement> textElements, List<TextElement> t1) {
        return textElements.size()- t1.size();
    }
}
