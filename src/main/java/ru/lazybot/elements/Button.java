package ru.lazybot.elements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

public class Button extends AbstractComplexElement {
    private ButtonLabel buttonLabel;
    private Callback callback;

    public Button(Node node) {
        super(node);
        buttonLabel = new ButtonLabel(getElement("ButtonLabel"));
        callback = hasElement("Callback") ? new Callback(getElement("Callback")) : null;
    }

    public ButtonLabel getButtonLabel() {
        return buttonLabel;
    }

    public String getCallbackData() {
        return callback.getValue();
    }

    public Callback getCallback() {
        return callback;
    }
}
