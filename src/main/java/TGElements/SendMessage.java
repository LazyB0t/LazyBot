package TGElements;

import XMLElements.Button;
import XMLElements.ButtonsArray;
import XMLElements.Menu;
import XMLElements.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;

import java.util.List;

public class SendMessage extends com.pengrad.telegrambot.request.SendMessage {

    public SendMessage(Object chatID, Message message) {
        super(chatID, message.getText().getValue());
    }

    public SendMessage(Object chatID, Menu menu) {
        super(chatID, menu.getText().getValue());
        replyMarkup(getKeyboard(menu.getButtonsArrays()));
    }

    private InlineKeyboardMarkup getKeyboard(List<ButtonsArray> buttonsArrays) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        for (int i = 0; i < buttonsArrays.size(); i++) {
            List<Button> buttonsArray = buttonsArrays.get(i).getButtonsRow();
            InlineKeyboardButton[] buttonsRow = new InlineKeyboardButton[buttonsArray.size()];
            for (int j = 0; j < buttonsArray.size(); j++) {
                buttonsRow[j] = new InlineKeyboardButton(buttonsArray.get(j).getButtonLabel().getValue()).callbackData(buttonsArray.get(j).getCallback().getValue());
            }
            keyboard.addRow(buttonsRow);
        }
        return keyboard;
    }
}
