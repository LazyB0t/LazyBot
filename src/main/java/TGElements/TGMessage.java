package TGElements;

import com.pengrad.telegrambot.request.SendMessage;
import ru.berrywoodfamily.Message;

public class TGMessage extends SendMessage {

    public TGMessage(Object chatID, Message message) {
        super(chatID, message.getText().getValue());
    }

}
