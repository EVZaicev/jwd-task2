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
    private static final String TEXT_WITH_NUMBER_OF_PARAGRAPH = "^[\\d].+";

    @Override
    public List<TextElement> parseText(String path) throws FileNotFoundException {
        logger.debug("Input text: ");
        File file = new File(path);
        Scanner reader = new Scanner(file);


        String tempCode = "";
        List<String> listBlocks = new ArrayList<>();
        while (reader.hasNextLine()) {
            String text = reader.nextLine();
            if (text.matches(TEXT_WITH_NUMBER_OF_PARAGRAPH)) {
                listBlocks.add(text);
                continue;
            }

            if (text.matches("^[A-Z](.)*[:|.]$")) {
                listBlocks.add(text);
                continue;
            }
            if (text.matches("^[A-Z](.)+")
                    && (!(text.matches("(.)*[:|.]$")))) {
                tempCode = text + " ";
                text = reader.nextLine();
                while (!(text.matches("(.)*[:|.]$"))) {
                    tempCode = tempCode + text;
                    text = reader.nextLine();
                }
                tempCode = tempCode + text;
                listBlocks.add(tempCode);
                tempCode = "";
                continue;
            }

            if (text.matches("^void(.)+|^class(.)+")) {
                tempCode += text + "\n";
                text = reader.nextLine();
                while (!(text.matches("^}$(.)*"))) {
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

            if (textBlock.matches("^[\\d].+|[A-Z]+(.)*")) {
                textElements.add(new Paragraph(parserParagraph.parseText(textBlock)));
            } else {
                textElements.add(new CodeBlock(parserCodeBlock.parseText(textBlock)));
            }
        }
        return textElements;
    }
}
