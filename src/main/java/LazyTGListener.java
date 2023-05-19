import XMLElements.SaveTo;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AbstractSendRequest;

import java.util.List;

public class LazyTGListener extends AbstractTGListener{
    public LazyTGListener(String botPath, TelegramBot tgBotAPI) {
        super(botPath, tgBotAPI);
    }

    @Override
    public void saveData(List<SaveTo> saves, Update update) {
    //TODO: Implement saving data to standard stores from xml.
    }

    @Override
    public List<AbstractSendRequest> getTGReply(List<AbstractSendRequest> tgReplies) {
        return tgReplies;
    }
}
