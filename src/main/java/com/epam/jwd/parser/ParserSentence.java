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
    List<TextElement> words;
    List<String> listWords;
    @Override
    public List<TextElement> parseText(String text) throws FileNotFoundException {
        words =new ArrayList<>();
//        Pattern pattern = Pattern.compile("[^\\s][a-zA-Z]*,?-?[a-z]*[^\\s]");
        Pattern pattern = Pattern.compile("[^\\s][a-zA-Z]*,?-?[a-z]*-?[a-z]*[^\\s]|\\d");
        Matcher m = pattern.matcher(text);
        listWords=new ArrayList<>();
        while (m.find()) {
//            System.out.println(s);
//            System.out.println("88888888888888888888888888888888**");
            listWords.add(m.group());
        }
        for (String s : listWords) {
            words.add(new Word(s));
        }
        return words;
    }
}
