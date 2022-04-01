package com.epam.jwd.parser;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserSentence implements Parser {
    private static final Logger logger = LogManager.getLogger(ParserSentence.class);
    private static final String EXP_DIVIDING_SENTENCE = "[^\\s][a-zA-Z]*,?-?[a-z]*-?[a-z]*[^\\s]|\\d";
    List<TextElement> words;
    List<String> listWords;
    /**
     * It divides sentences into words
     *
     * @param text it is text block which contains sentences
     *
     * @return List of words from text.
     */
    @Override
    public List<TextElement> parseText(String text) throws FileNotFoundException {
        words =new ArrayList<>();
        Pattern pattern = Pattern.compile(EXP_DIVIDING_SENTENCE);
        Matcher m = pattern.matcher(text);
        listWords=new ArrayList<>();
        while (m.find()) {
            listWords.add(m.group());
        }
        for (String s : listWords) {
            words.add(new Word(s));
        }
        return words;
    }
}
