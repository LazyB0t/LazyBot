package ru.lazybot.elements;

import org.jaxptoobjects.AbstractComplexElement;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Bot extends AbstractComplexElement {
    private String token;
    private List<Replies> replies;

    public Bot(Node node) {
        super(node);
        replies = new ArrayList();
        for (Node reply: getElements("Replies")) {
            replies.add(new Replies(reply));
        }
        token = getAttribute("token");
    }

    public String getToken() {
        return token;
    }

    public List<Replies> getReplies() {
        return replies;
    }

}
