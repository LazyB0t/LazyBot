package ru.lazybot.elements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class ButtonsArray extends AbstractComplexElement {
    private List<Button> buttonsRow;
    private BackButton backButton;

    public ButtonsArray(Node node) {
        super(node);
        buttonsRow = new ArrayList();
        for (Node button: getElements("Button")) {
            buttonsRow.add(new Button(button));
        }
        backButton = hasElement("BackButton") ? new BackButton(getElement("BackButton")) : null;
    }

    public List<Button> getButtonsRow() {
        return buttonsRow;
    }

    public BackButton getBackButton() {
        return backButton;
    }
}
