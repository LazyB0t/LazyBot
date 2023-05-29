package ru.lazybot.elements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class ButtonsArray extends AbstractComplexElement {
    private List<Button> buttonsRow;

    public ButtonsArray(Node node) {
        super(node);
        buttonsRow = new ArrayList();
        for (Node button: getElements("Button")) {
            buttonsRow.add(new Button(button));
        }
    }

    public List<Button> getButtonsRow() {
        return buttonsRow;
    }

}
