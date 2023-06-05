package ru.lazybot.elements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

public class BackButton extends AbstractComplexElement {
    private Count count;
    private ButtonLabel buttonLabel;

    public BackButton(Node node) {
        super(node);
        count = new Count(getElement("Count"));
        buttonLabel = new ButtonLabel(getElement("ButtonLabel"));
    }

    public Count getCount() {
        return count;
    }

    public ButtonLabel getButtonLabel() {
        return buttonLabel;
    }
}
