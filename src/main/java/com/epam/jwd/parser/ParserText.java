package com.epam.jwd.parser;

import com.epam.jwd.entity.CodeBlock;
import com.epam.jwd.entity.Paragraph;
import com.epam.jwd.entity.TextElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserText implements Parser {
    private static final Logger logger = LogManager.getLogger(ParserText.class);
    private static final String EXP_TEXT_WITH_NUMBER_OF_PARAGRAPH = "^[\\d].+";
    private static final String EXP_TEXT_WITH_POINT_OR_COLON_AT_THE_END_SENTENCE = "^[A-Z](.)*[:|.]$";
    private static final String EXP_FOR_FINDING_CODE_BLOCKS = "^void(.)+|^class(.)+";
    private static final String EXP_FOR_FINDING_PARAGRAPHS = "^[\\d].+|[A-Z]+(.)*";
    private static final String EXP_FOR_BEGINNING_SENTENCE = "^[A-Z](.)+";
    private static final String EXP_FOR_SENTENCE_END = "(.)*[:|.]$";
    private static final String EXP_FOR_CODE_BLOCK_END = "^}$(.)*";


    /**
     * This is the main method of this task.
     * It divides text into blocks
     * and also accepts data from other handler classes.
     *
     * @param path It is path to file with a text
     *
     * @return List of object blocks from text.
     */
    @Override
    public List<TextElement> parseText(String path) throws FileNotFoundException {
        logger.debug("Input text: ");
        File file = new File(path);
        Scanner reader = new Scanner(file);
        String tempCode = "";
        List<String> listBlocks = new ArrayList<>();
        while (reader.hasNextLine()) {
            String text = reader.nextLine();
            if (text.matches(EXP_TEXT_WITH_NUMBER_OF_PARAGRAPH)) {
                listBlocks.add(text);
                continue;
            }

            if (text.matches("EXP_TEXT_WITH_POINT_OR_COLON_AT_THE_END_SENTENCE")) {
                listBlocks.add(text);
                continue;
            }
            if (text.matches("EXP_FOR_BEGINNING_SENTENCE")
                    && (!(text.matches("EXP_FOR_SENTENCE_END")))) {
                tempCode = text + " ";
                text = reader.nextLine();
                while (!(text.matches("EXP_FOR_SENTENCE_END"))) {
                    tempCode = tempCode + text;
                    text = reader.nextLine();
                }
                tempCode = tempCode + text;
                listBlocks.add(tempCode);
                tempCode = "";
                continue;
            }

            if (text.matches("EXP_FOR_FINDING_CODE_BLOCKS")) {
                tempCode += text + "\n";
                text = reader.nextLine();
                while (!(text.matches("EXP_FOR_CODE_BLOCK_END"))) {
                    tempCode = tempCode + text + "\n";
                    text = reader.nextLine();
                }
                tempCode += text;
                listBlocks.add(tempCode);
                tempCode = "";
                continue;
            }
            if (text.equals("")) {
                tempCode += "\n";
            } else {
                listBlocks.add(text);
                continue;
            }
        }

        reader.close();

        ParserParagraph parserParagraph = new ParserParagraph();
        ParserCodeBlock parserCodeBlock = new ParserCodeBlock();
        List<TextElement> textElements = new ArrayList<>();
        for (String textBlock : listBlocks) {

            if (textBlock.matches("EXP_FOR_FINDING_PARAGRAPHS")) {
                textElements.add(new Paragraph(parserParagraph.parseText(textBlock)));
            } else {
                textElements.add(new CodeBlock(parserCodeBlock.parseText(textBlock)));
            }
        }
        return textElements;
    }
}
