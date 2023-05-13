package ru.berrywoodfamily;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

public class Message extends AbstractComplexElement {
    private Text text;

    public Message(Node node) {
        super(node);
        text = new Text(getElement("Text"));
    }

    public Text getText() {
        return text;
    }
}
