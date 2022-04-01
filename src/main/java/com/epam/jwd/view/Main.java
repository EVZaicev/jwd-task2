package com.epam.jwd.view;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.WholeText;
import com.epam.jwd.logic.Task12;
import com.epam.jwd.logic.Task2;
import com.epam.jwd.logic.Task5;
import com.epam.jwd.parser.ParserText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        String path = "src/main/resources/text.txt";
        ParserText parser = new ParserText();
        logger.info("Created object parser");
        List<TextElement> list = parser.parseText(path);
        WholeText text = new WholeText(list);
        String s = text.getValue();
        System.out.println("\n" + s);

        File f = new File("src/main/resources/Text2.txt");
        FileWriter writer = new FileWriter(f);
        writer.write(s);
        writer.flush();

        logger.info("File's written");
        Task2 t = new Task2(list);
        System.out.println("Task2 has finished!!!");
        Task5 t2 = new Task5(list);
        Task12 t3 = new Task12();
        t3.sortText(list, 9);


    }
}
