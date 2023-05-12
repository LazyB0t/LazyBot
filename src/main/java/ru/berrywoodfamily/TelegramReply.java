package ru.berrywoodfamily;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class TelegramReply {
    private Long chatID;

    public TelegramReply (Long chatID) {
       this.chatID = chatID;
    }

    public SendMessage getReply(Reply reply){
        SendMessage sendReply = new SendMessage(chatID,reply.getText());
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        for (ButtonsArray buttonsArray: reply.getButtonsArrays()){
            InlineKeyboardButton [] buttons = new InlineKeyboardButton[buttonsArray.getButtonsRow().size()];
            for (int i = 0; i < buttonsArray.getButtonsRow().size(); i++ ){
                buttons[i] =  new InlineKeyboardButton(buttonsArray.getButtonsRow().get(i).getText()).callbackData(buttonsArray.getButtonsRow().get(i).getCallback());
            }
            keyboard.addRow(buttons);
        }
        sendReply.replyMarkup(keyboard);
        return sendReply;
    }
}




