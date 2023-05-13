package ru.berrywoodfamily;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

public class Button extends AbstractComplexElement {
    private Text text;
    private Callback callback;

    public Button(Node node) {
        super(node);
        text = new Text(getElement("Text"));
        callback = new Callback(getElement("Callback"));
    }

    public String getText() {
        return text.getValue();
    }

    public String getCallback() {
        return callback.getValue();
    }
}
