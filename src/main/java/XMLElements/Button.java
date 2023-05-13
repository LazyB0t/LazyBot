package XMLElements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;
import ru.berrywoodfamily.Callback;

public class Button extends AbstractComplexElement {
    private Text text;
    private Callback callback;

    public Button(Node node) {
        super(node);
        text = new Text(getElement("Text"));
        callback = new Callback(getElement("Callback"));
    }

    public Text getText() {
        return text;
    }

    public Callback getCallback() {
        return callback;
    }
}
