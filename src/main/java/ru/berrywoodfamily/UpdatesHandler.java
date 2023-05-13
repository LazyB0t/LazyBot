package ru.berrywoodfamily;

import TGElements.TGMenu;
import XMLElements.*;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AbstractSendRequest;

import java.util.HashMap;
import java.util.List;


public class UpdatesHandler {
private HashMap<Object, Reply> nextReply;
private Bot bot;
private DOMBot domBot;
private Update update;
public UpdatesHandler(String botPath) {
    nextReply = new HashMap();
    domBot = new DOMBot(botPath);
    bot = domBot.getBot();
}

public List<AbstractSendRequest> getReplies(Update update) {
    this.update = update;
    if(nextReply.containsKey(getChatID())) {

    } else {
        for(Replies replies: bot.getReplies()) {

        }
    }
    return null;
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

private AbstractSendRequest getTGElement(Reply reply) {
    AbstractSendRequest tgElement;
    for (String nameChild: reply.getNamesChildren()){
        switch (nameChild) {
            case "Menu":
                //tgElement = new TGMenu(getChatID(),reply.getMenu());
        }
    }
    return null;
}

}
