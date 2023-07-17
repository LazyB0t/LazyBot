package ru.lazybot.elements;

import java.util.ArrayList;
import java.util.List;
import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

public class ButtonsArray extends AbstractComplexElement {
  private List<Button> buttonsRow;

  public ButtonsArray(Node node) {
    super(node);
    buttonsRow = new ArrayList();
    for (Node button : getElements("Button")) {
      buttonsRow.add(new Button(button));
    }
    if (hasElement("BackButton")) {
      buttonsRow.add(new BackButton(getElement("BackButton")));
    }
  }

  public List<Button> getButtonsRow() {
    return buttonsRow;
  }
}
