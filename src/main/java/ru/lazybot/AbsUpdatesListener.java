package ru.lazybot;

import ru.lazybot.elements.*;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AnswerCallbackQuery;
import com.pengrad.telegrambot.request.BaseRequest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsUpdatesListener implements UpdatesListener {
    private IRepliesManager RepliesManager;
    private IMessageFactory messageFactory;
    private TelegramBot tgBotAPI;

    public AbsUpdatesListener(Bot bot, TelegramBot tgBotAPI) {
        RepliesManager = setRepliesManager(bot.getReplies());
        messageFactory = setMessageFactory();
        this.tgBotAPI = tgBotAPI;
    }

    public AbsUpdatesListener(String botPath, TelegramBot tgBotAPI) {
        this(new DOMBot(botPath).getBot(),tgBotAPI);
    }

    public AbsUpdatesListener(InputStream is, TelegramBot tgBotAPI) {
        this(new DOMBot(is).getBot(),tgBotAPI);
    }

    @Override
    public int process(List<Update> list) {
        List<BaseRequest> tgReplies = new ArrayList();
        for (Update update: list) {
            AbsIncMessage incMessage = setIncMessage(update);
            getNewUpdate(update);
            if (incMessage.getType().equals("button")) {
                tgReplies.add(new AnswerCallbackQuery(update.callbackQuery().id()));
            }
            for (Reply reply: RepliesManager.getSuitableReplies(incMessage)) {
                saveData(reply.getSaves(),incMessage);
                tgReplies.add(messageFactory.getMessage(incMessage.getChatID(), reply));
            }
        }
        for (BaseRequest tgReply: getMessages(tgReplies)) {
            tgBotAPI.execute(tgReply);
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    public abstract void getNewUpdate(Update update);
    public abstract void saveData(List<SaveTo> saves, AbsIncMessage incMessage);
    public abstract List<BaseRequest> getMessages(List<BaseRequest> tgReplies);
    public abstract IRepliesManager setRepliesManager(List<Replies> listReplies);
    public abstract IMessageFactory setMessageFactory();
    public abstract AbsIncMessage setIncMessage(Update update);
}
