package ru.lazybot.elements;

import org.w3c.dom.Node;

public class BackButton extends Button {
    private Count count;

    public BackButton(Node node) {
        super(node);
        count = new Count(getElement("Count"));
    }

    public Count getCount() {
        return count;
    }

    @Override
    public String getCallbackData() {
        return "/back;" + getCount().getValue();
    }
}
