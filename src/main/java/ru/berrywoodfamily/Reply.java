package ru.berrywoodfamily;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Reply {
    private String name;
    private String text;
    private String after;
    private String next;
    private List<ButtonsArray> buttonsArrays;

    public Reply(Node replyNode){
        buttonsArrays = new ArrayList();
        this.name = replyNode.getAttributes().getNamedItem("name") != null ? replyNode.getAttributes().getNamedItem("name").getNodeValue(): null;
        this.after = replyNode.getAttributes().getNamedItem("after") != null ? replyNode.getAttributes().getNamedItem("after").getNodeValue(): null;
        this.next = replyNode.getAttributes().getNamedItem("next") != null ? replyNode.getAttributes().getNamedItem("next").getNodeValue(): null;
        NodeList buttonsArray = replyNode.getChildNodes();
        for (int i = 0; i < buttonsArray.getLength(); i++){
            switch (buttonsArray.item(i).getNodeName()) {
                case "Text":
                    this.text = buttonsArray.item(i).getTextContent();
                    break;
                case "ButtonsArray":
                    buttonsArrays.add(new ButtonsArray(buttonsArray.item(i)));
                    break;
            }
        }
    }

    public boolean hasButtons(){
        return buttonsArrays.size() > 0;
    }

    public List<ButtonsArray> getButtonsArrays(){
        return buttonsArrays;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }

    public String getAfter(){
        return after;
    }

    public String getNext(){
        return next;
    }

}
