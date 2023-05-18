package XMLElements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

public class Button extends AbstractComplexElement {
    private ButtonLabel buttonLabel;
    private Callback callback;

    public Button(Node node) {
        super(node);
        buttonLabel = new ButtonLabel(getElement("Text"));
        callback = new Callback(getElement("Callback"));
    }

    public ButtonLabel getButtonLabel() {
        return buttonLabel;
    }

    public Callback getCallback() {
        return callback;
    }
}
