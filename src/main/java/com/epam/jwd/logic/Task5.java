package com.epam.jwd.logic;

import com.epam.jwd.entity.Paragraph;
import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.WholeText;

import java.util.*;

public class Task5 {
//    В  каждом  предложении  текста  поменять  местами  первое  слово  с  последним,  не
//    изменяя длины предложения.
private WholeText text;

        public Task5(List<TextElement> list) {
        this.text = new WholeText(list);

        sortText(list);
    }

    /**
     * Task 5
     *In each sentence of the text, swap the first word with the last one without
     * changing the length of the sentence
     *
     * @param wholeText text after parsing
     *
     */
    public void sortText(List<TextElement> wholeText) {
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
                    for (TextElement sentence : sentences) {
                        words1.add(sentence);
                    }
                }
            }
        }

        List<String> sents = new ArrayList<>();
        for (TextElement value : map.values()) {
          sents.add(value.getValue());

        }

        String delimiter = " ";
        List<String[]> listWord= new ArrayList<>();
        List<String> newList=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String sent : sents) {
            listWord.add(sent.split(" "));
        }
        for (String[] strings : listWord) {
            sb = new StringBuilder();
            if(strings.length>=2)
            {
                String temp = strings[0];
                strings[0]=strings[strings.length-1];
                strings[strings.length-1]=temp;
                for (String string : strings) {
                    sb.append(string+" ");
                }
                newList.add(String.valueOf(sb));
            }
            else {
                newList.add(strings[0]);
            }
        }

        for (String s : newList) {
            System.out.println(s);
        }
    }
}
