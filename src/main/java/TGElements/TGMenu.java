package TGElements;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import ru.berrywoodfamily.Button;
import ru.berrywoodfamily.ButtonsArray;
import ru.berrywoodfamily.Menu;

import java.util.List;

public class TGMenu extends SendMessage {
    public TGMenu(Object chatID, Menu menu) {
        super(chatID, menu.getText().getValue());
        replyMarkup(getKeyboard(menu.getButtonsArrays()));
    }

    private InlineKeyboardMarkup getKeyboard(List<ButtonsArray> buttonsArrays) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        for (int i = 0; i < buttonsArrays.size(); i++) {
            List<Button> buttonsArray = buttonsArrays.get(i).getButtonsRow();
            InlineKeyboardButton[] buttonsRow = new InlineKeyboardButton[buttonsArray.size()];
            for (int j = 0; j < buttonsArray.size(); j++) {
                buttonsRow[j] = new InlineKeyboardButton(buttonsArray.get(j).getText().getValue()).callbackData(buttonsArray.get(j).getCallback().getValue());
            }
            keyboard.addRow(buttonsRow);
        }
        return keyboard;
    }
}
