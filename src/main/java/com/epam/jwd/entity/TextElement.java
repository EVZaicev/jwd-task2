package com.epam.jwd.entity;

import java.util.List;

/**
 * @author Eugeny Zaitsev
 */
public interface TextElement {
    public void  Add(TextElement text);
    public String getValue();
    public List<TextElement> getList();

}
