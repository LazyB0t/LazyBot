package UpdatesHandling;

import XMLElements.*;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AbstractSendRequest;

import java.util.ArrayList;
import java.util.List;


public class UpdatesHandler {
    private Bot bot;
    private DOMBot domBot;
    private Update update;
    private GetReplies getReplies;
    private XMLReplyToTGElem xmlAdapter;

    public UpdatesHandler(String botPath) {
        domBot = new DOMBot(botPath);
        bot = domBot.getBot();
        getReplies = new GetReplies(bot.getReplies());
        xmlAdapter = new XMLReplyToTGElem();
    }

    public List<AbstractSendRequest> getTGReplies(Update update) {
        this.update = update;
        List<AbstractSendRequest> tgReplies = new ArrayList();
        for(Reply reply: getReplies.replies(getChatID(),getUpdateData())) {
            tgReplies.add(xmlAdapter.getTGElem(getChatID(),reply));
        }
        return tgReplies;
    }

    private String getUpdateType() {
        return (update.message() == null) ? "button" : "txt";
    }

    private String getUpdateData() {
        return (update.message() == null) ? update.callbackQuery().data() : update.message().text();
    }

    private Object getChatID() {
       return (update.message() == null) ? update.callbackQuery().message().chat().id() : update.message().chat().id();
    }
}
