package ru.lazybot;

import ru.lazybot.elements.Bot;
import ru.lazybot.elements.SaveTo;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public class LazyUpdatesListener extends AbsUpdatesListener {
    public LazyUpdatesListener(Bot bot, TelegramBot tgBotAPI) {
        super(bot,tgBotAPI);
    }

    @Override
    public void saveData(List<SaveTo> saves, Update update) {
    //TODO: Implement saving data to standard stores from xml.
    }

    @Override
    public List<BaseRequest> getMessages(List<BaseRequest> tgReplies) {
        return tgReplies;
    }

    @Override
    public void getNewUpdate(Update update) {
    }
}
