package XMLElements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;


public class Reply extends AbstractComplexElement {
    private Menu menu;
    private Message message;
    private String wait;
    private SaveTo saveTo;

    public Reply(Node node) {
        super(node);
        menu = hasElement("Menu") ? new Menu(getElement("Menu")) : null;
        message = hasElement("Message") ? new Message(getElement("Message")) : null;
        wait = hasAttribute("wait") ? getAttribute("wait") : null;
        saveTo = hasElement("SaveTo") ? new SaveTo(getElement("SaveTo")) : null;
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

    public SaveTo getSaveTo() {
        return saveTo;
    }
}
