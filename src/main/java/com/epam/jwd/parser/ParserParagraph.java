package com.epam.jwd.parser;


import com.epam.jwd.entity.Paragraph;
import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.TextElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserParagraph implements Parser {
    private static final Logger logger = LogManager.getLogger(ParserParagraph.class);
    List<Paragraph> paragraphs;

    public ParserParagraph() {
        this.paragraphs = new ArrayList<>();
    }
    Parser parserSentences = new ParserSentence();
    List<TextElement> sentenses;
    List<String> listSen;
    @Override
    public List<TextElement> parseText(String paragraph) throws FileNotFoundException {
    listSen = new ArrayList<>();
    sentenses = new ArrayList<>();
        //share blocks at  the parts
        String[] s = paragraph.split("\\.\\s|\\.");
        for (String s1 : s) {

            listSen.add(s1);
        }

        for (String text : listSen) {

            Pattern p = Pattern.compile("^[a-zA-z](.*)[a-z\\d]$|^[12](.*)");
            Matcher m = p.matcher(text);
            if (m.find()) {
                text= text+".";
                sentenses.add(new Sentence(parserSentences.parseText(text)));
            }
            else { sentenses.add(new Sentence(parserSentences.parseText(text)));}
            System.out.println(text);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        }
        return sentenses;
    }
}
