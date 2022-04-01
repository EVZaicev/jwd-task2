package com.epam.jwd.parser;


import com.epam.jwd.entity.Paragraph;
import com.epam.jwd.entity.Sentence;
import com.epam.jwd.entity.TextElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ParserParagraph implements Parser {
    private static final Logger logger = LogManager.getLogger(ParserParagraph.class);
    private static final String EXP_FOR_HELPING_FINDING_SENTENCE = "^[a-zA-z](.*)[a-z\\d]$|^[12](.*)";
    private static final String EXP_FOR_SPLITTING_SENTENCE = "^[a-zA-z](.*)[a-z\\d]$|^[12](.*)";
    List<Paragraph> paragraphs;

    Parser parserSentences = new ParserSentence();
    List<TextElement> sentenses;
    List<String> listSentences;
    public ParserParagraph() {
        this.paragraphs = new ArrayList<>();
    }
    /**
     * This is the main method of this task.
     * It divides text into blocks
     * and also accepts data from other handler classes.
     *
     * @param paragraphBlock it is text block which contains sentences
     *
     * @return List of sentences from text.
     */
    @Override
    public List<TextElement> parseText(String paragraphBlock) throws FileNotFoundException {
        listSentences = new ArrayList<>();
        sentenses = new ArrayList<>();
        String[] s = paragraphBlock.split("EXP_FOR_SPLITTING_SENTENCE");
        for (String s1 : s) {

            listSentences.add(s1);
        }

        for (String text : listSentences) {
            sentenses.add(new Sentence(parserSentences.parseText(text)));
        }
        return sentenses;
    }
}
