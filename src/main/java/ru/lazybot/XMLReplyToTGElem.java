package ru.lazybot;

import ru.lazybot.messages.SendMessage;
import ru.lazybot.elements.Reply;
import com.pengrad.telegrambot.request.AbstractSendRequest;

public class XMLReplyToTGElem {
    public AbstractSendRequest getTGElem(Object chatID,Reply reply) {
        for (String nameChild: reply.getNamesChildren()){
            switch (nameChild) {
                case "Menu":
                    return new SendMessage(chatID,reply.getMenu());
                case "Message":
                    return new SendMessage(chatID,reply.getMessage());
            }
        }
        return null;
    }
}
