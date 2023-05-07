package ru.berrywoodfamily;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ButtonsArray {
    private List<Button> buttonsRow;

    public ButtonsArray(Node buttonsArrayNode){
        buttonsRow = new ArrayList<>();
        NodeList buttonsNod = buttonsArrayNode.getChildNodes();
        for(int i = 0; i < buttonsNod.getLength();i++){
            buttonsRow.add(new Button(buttonsNod.item(i)));
        }
    }

    private void addButton(Button button) {
        buttonsRow.add(button);
    }

    public List<Button> getButtonsRow(){
        return buttonsRow;
    }
}
