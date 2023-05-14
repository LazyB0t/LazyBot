package TGElements;

import XMLElements.Message;

public class SendMessage extends com.pengrad.telegrambot.request.SendMessage {

    public SendMessage(Object chatID, Message message) {
        super(chatID, message.getText().getValue());
    }

}
