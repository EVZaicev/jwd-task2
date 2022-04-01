package com.epam.jwd.logic;

import com.epam.jwd.entity.Paragraph;
import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.WholeText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task2 {

    private WholeText text;

//    Print all sentences of a given text in ascending
//    order of the number of words in each of them
    public Task2(List<TextElement> list) {
        this.text = new WholeText(list);
        sortText(list);
    }

    public void sortText(List<TextElement> wholeText) {
        List<TextElement> paragraphs;
        List<TextElement> blocks = text.getList();
        List<TextElement> sentences = new ArrayList<>();

        Map<Integer, TextElement> map = new TreeMap<>();
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
        File file=new File("src/main/resources/outputtask2.txt");
        try {
            StringBuilder builder = new StringBuilder();
            for (TextElement value : map.values()) {

                builder.append(value.getValue()+"\n");
            }
            FileWriter writer = new FileWriter(file);
            writer.write(builder.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


