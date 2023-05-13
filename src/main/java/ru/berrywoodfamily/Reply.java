package ru.berrywoodfamily;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;


public class Reply extends AbstractComplexElement {
    private Menu menu;
    private Message message;
    private String wait;

    public Reply(Node node) {
        super(node);
        menu = new Menu(getElement("Menu"));
        message = new Message(getElement("Message"));
        wait = getAttribute("wait");
    }

    public Menu getMenu() {
        return menu;
    }

    public Message getMessage() {
        return message;
    }
}
