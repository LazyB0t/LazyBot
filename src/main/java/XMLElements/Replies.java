package XMLElements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Replies extends AbstractComplexElement {
    private List<Reply> replies;
    private String after;


    public Replies(Node node) {
        super(node);
        replies = new ArrayList();
        for (Node reply: getElements("Reply")) {
            replies.add(new Reply(reply));
        }
        after = getAttribute("after");
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public String getAfter() {
        return after;
    }

}
