package ru.lazybot.messages;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import java.util.ArrayList;
import java.util.List;
import ru.lazybot.elements.Button;
import ru.lazybot.elements.ButtonsArray;
import ru.lazybot.elements.Menu;
import ru.lazybot.elements.Message;

public class SendMessage extends com.pengrad.telegrambot.request.SendMessage {

  public SendMessage(Object chatID, Message message) {
    super(chatID, message.getText().getValue());
  }

  public SendMessage(Object chatID, Menu menu) {
    super(chatID, menu.getText().getValue());
    replyMarkup(getKeyboard(menu.getButtonsArrays()));
  }

  private InlineKeyboardMarkup getKeyboard(List<ButtonsArray> buttonsArrays) {
    InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
    for (ButtonsArray buttonsArray : buttonsArrays) {
      List<InlineKeyboardButton> inlineButtonsRow = new ArrayList();
      for (Button button : buttonsArray.getButtonsRow()) {
        InlineKeyboardButton inlineButton =
            new InlineKeyboardButton(button.getButtonLabel().getValue());
        inlineButton.callbackData(button.getCallbackData());
        inlineButtonsRow.add(inlineButton);
      }
      inlineKeyboard.addRow(
          inlineButtonsRow.toArray(new InlineKeyboardButton[inlineButtonsRow.size()]));
    }
    return inlineKeyboard;
  }
}
