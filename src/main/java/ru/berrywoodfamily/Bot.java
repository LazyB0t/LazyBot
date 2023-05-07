package ru.berrywoodfamily;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Bot {
    private String token;
    private List<Reply> replies;

    public Bot(Document document) {
        replies = new ArrayList<>();
        NodeList replyNodes = document.getElementsByTagName("Reply");
        System.out.println("Длина "+ replyNodes.getLength());
        for(int i = 0; i < replyNodes.getLength(); i++) {
            if (replyNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                replies.add(new Reply(replyNodes.item(i)));
            }
        }
        this.token = document.getElementsByTagName("Bot").item(0).getAttributes().getNamedItem("token").getNodeValue();
    }

    public String getToken() {
        return token;
    }
}
