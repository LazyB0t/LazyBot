package ru.lazybot;

import ru.lazybot.elements.Bot;
import ru.lazybot.elements.DOMBot;
import ru.lazybot.elements.Reply;
import ru.lazybot.elements.SaveTo;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AnswerCallbackQuery;
import com.pengrad.telegrambot.request.BaseRequest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTGListener implements UpdatesListener {
    private Bot bot;
    private GetReplies getReplies;
    private XMLReplyToTGElem xmlAdapter;
    private TelegramBot tgBotAPI;

    public AbstractTGListener(Bot bot, TelegramBot tgBotAPI) {
        this.bot = bot;
        getReplies = new GetReplies(bot.getReplies());
        xmlAdapter = new XMLReplyToTGElem();
        this.tgBotAPI = tgBotAPI;
    }

    public AbstractTGListener(String botPath, TelegramBot tgBotAPI) {
        this(new DOMBot(botPath).getBot(),tgBotAPI);
    }

    public AbstractTGListener(InputStream is, TelegramBot tgBotAPI) {
        this(new DOMBot(is).getBot(),tgBotAPI);
    }

    @Override
    public int process(List<Update> list) {
        List<BaseRequest> tgReplies = new ArrayList();
        for (Update update: list) {
            getNewUpdate(update);
            if (getUpdateType(update) == "button") {
                tgReplies.add(new AnswerCallbackQuery(update.callbackQuery().id()));
            }
            for (Reply reply: getReplies.replies(getChatID(update),getUpdateData(update))) {
                saveData(reply.getSaves(),update);
                tgReplies.add(xmlAdapter.getTGElem(getChatID(update), reply));
            }
        }
        for (BaseRequest tgReply: getTGReply(tgReplies)) {
            tgBotAPI.execute(tgReply);
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    protected Object getChatID(Update update) {
        return (update.message() == null) ? update.callbackQuery().message().chat().id() : update.message().chat().id();
    }

    protected String getUpdateData(Update update) {
        return (update.message() == null) ? update.callbackQuery().data() : update.message().text();
    }

    protected String getUpdateType(Update update) {
        return (update.message() == null) ? "button" : "txt";
    }

    public abstract void getNewUpdate(Update update);
    public abstract void saveData(List<SaveTo> saves, Update update);
    public abstract List<BaseRequest> getTGReply(List<BaseRequest> tgReplies);
}
