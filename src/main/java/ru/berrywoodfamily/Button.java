package ru.berrywoodfamily;

import org.w3c.dom.Node;

public class Button {
    private String text;
    private String callback;

    public Button(Node buttonNode){
        for (int i = 0; i < buttonNode.getChildNodes().getLength(); i++){
            switch (buttonNode.getChildNodes().item(i).getNodeName()){
                case "Text":
                    this.text = buttonNode.getChildNodes().item(i).getTextContent();
                    break;
                case "Callback":
                    this.callback = buttonNode.getChildNodes().item(i).getTextContent();
                    break;
            }
        }
    }

    public String getText(){
        return text;
    }

    public String getCallback(){
        return callback;
    }
}
