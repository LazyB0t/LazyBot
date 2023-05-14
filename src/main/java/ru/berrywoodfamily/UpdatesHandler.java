package ru.berrywoodfamily;

import TGElements.SendMessage;
import XMLElements.*;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AbstractSendRequest;

import java.util.ArrayList;
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
        List<AbstractSendRequest> tgReplies = new ArrayList();
        if (nextReply.containsKey(getChatID())) {
            Reply reply = nextReply.get(getChatID());
            if (reply.getWait().equals(getUpdateType())) {
                tgReplies.add(getTGElement(nextReply.get(getChatID())));
                nextReply.remove(getChatID());
            }
        } else {
            for (Replies replies: bot.getReplies()) {
                if (replies.getAfter().equals(getUpdateData())) {
                    for (Reply reply: replies.getReplies()){
                        if (!reply.hasAttribute("wait")){
                            tgReplies.add(getTGElement(reply));
                        } else {
                            nextReply.put(getChatID(),reply);
                            break;
                        }
                    }
                }
            }
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

    private AbstractSendRequest getTGElement(Reply reply) {
        for (String nameChild: reply.getNamesChildren()){
            switch (nameChild) {
                case "Menu":
                    return new SendMessage(getChatID(),reply.getMenu());
                case "Message":
                    return new SendMessage(getChatID(),reply.getMessage());
            }
        }
        return null;
    }
}
