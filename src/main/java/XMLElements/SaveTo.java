package XMLElements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

public class SaveTo extends AbstractComplexElement {
    private Variable variable;
    private String save;

    public SaveTo(Node node) {
        super(node);
        variable = new Variable(getElement("Variable"));
        save = getAttribute("save");
    }

    public Variable getVariable() {
        return variable;
    }

    public String getSave() {
        return save;
    }
}
