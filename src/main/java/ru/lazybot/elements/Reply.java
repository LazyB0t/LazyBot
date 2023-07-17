package ru.lazybot.elements;

import java.util.ArrayList;
import java.util.List;
import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

public class Reply extends AbstractComplexElement {
  private Menu menu;
  private Message message;
  private String wait;
  private List<SaveTo> saves;

  public Reply(Node node) {
    super(node);
    saves = new ArrayList();
    menu = hasElement("Menu") ? new Menu(getElement("Menu")) : null;
    message = hasElement("Message") ? new Message(getElement("Message")) : null;
    wait = hasAttribute("wait") ? getAttribute("wait") : null;
    for (Node saveTo : getElements("SaveTo")) {
      saves.add(new SaveTo(saveTo));
    }
  }

  public Menu getMenu() {
    return menu;
  }

  public Message getMessage() {
    return message;
  }

  public String getWait() {
    return wait;
  }

  public List<SaveTo> getSaves() {
    return saves;
  }
}
