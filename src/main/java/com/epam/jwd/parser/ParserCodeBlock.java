package com.epam.jwd.parser;

import com.epam.jwd.entity.CodeBlockElement;
import com.epam.jwd.entity.TextElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ParserCodeBlock implements Parser {
    private static final Logger logger = LogManager.getLogger(ParserCodeBlock.class);
    private List<TextElement> codeBlocks;
    private List<String> codePart;

    @Override
    public List<TextElement> parseText(String text) throws FileNotFoundException {
        codeBlocks= new ArrayList<>();
        codePart = new ArrayList<>();
        String[] s = text.split("[\n]");
        for (String s1 : s) {
            codePart.add(s1);
        }
        codeBlocks.add(new CodeBlockElement(text));
        return codeBlocks;
    }
}
