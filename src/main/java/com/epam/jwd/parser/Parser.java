package com.epam.jwd.parser;


import com.epam.jwd.entity.TextElement;

import java.io.FileNotFoundException;
import java.util.List;

public interface Parser {

    public default List<TextElement> parseText(String text) throws FileNotFoundException {
        return null;
    }
}
