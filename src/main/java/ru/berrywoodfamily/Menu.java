package ru.berrywoodfamily;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AbstractComplexElement {
    private Text text;
    private List<ButtonsArray> buttonsArrays;

    public Menu(Node node) {
        super(node);
        buttonsArrays = new ArrayList();
        text = new Text(getElement("Text"));
        for (Node buttonsArray: getElements("ButtonsArray")) {
            buttonsArrays.add(new ButtonsArray(buttonsArray));
        }
    }

    public Text getText() {
        return text;
    }

    public List<ButtonsArray> getButtonsArrays() {
        return buttonsArrays;
    }
}
