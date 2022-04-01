package com.epam.jwd.logic;

import com.epam.jwd.entity.Paragraph;
import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.WholeText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task12 {
    private WholeText text;
    public static final String CONSONANT = "^[b-dB-D]+[a-z\\-]*|^[f-hF-H]+[a-z\\-]*|^[j-nJ-N]+[a-z\\-]*|^[p-tP-T]+[a-z\\-]*|^[v-xV-X]+[a-z\\-]*|^[zZ]+[a-z\\-]*";

    //из текста удалить все слова заданной длинны,
    // Начинающиеся на согласную букву

    public Task12() {

    }
    public void sortText(List<TextElement> wholeText, int lenght) {
        this.text = new WholeText(wholeText);
        List<TextElement> paragraphs;
        List<TextElement> blocks = text.getList();
        List<TextElement> sentences = new ArrayList<>();

        Map<Integer, TextElement> map = new HashMap<>();
        List<TextElement> words1 = new ArrayList<>();
        for (TextElement block : blocks) {
            if (block instanceof Paragraph) {
                paragraphs = block.getList();
                for (TextElement element : paragraphs) {
                    if (element instanceof Sentence) {
                        sentences.add(element);
                        map.put(((Sentence) element).getSize(), element);
                    }
                }
            }
        }

        List<String> sents = new ArrayList<>();
        for (TextElement value : map.values()) {
            sents.add(value.getValue());
        }
        String delimiter = " ";
        List<String[]> listWord = new ArrayList<>();
        List<String> newList = new ArrayList<>();
        StringBuilder sb;
        for (String sent : sents) {
            listWord.add(sent.split(" "));
        }
        for (String[] strings : listWord) {
            sb = new StringBuilder();
            for (String string : strings) {
                if (string.length() == lenght && string.matches(CONSONANT)) {
                    string = null;
                } else {
                    sb.append(string + " ");
                }
            }
            newList.add(String.valueOf(sb));
        }
        for(String s :newList)
        {
            System.out.println(s);
            System.out.println("12-12-12-12-12-12-12-12-21-21-21-21------1111111111111111");
        }
    }

}

