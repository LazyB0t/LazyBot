package ru.lazybot;

import com.pengrad.telegrambot.request.BaseRequest;
import ru.lazybot.messages.SendMessage;
import ru.lazybot.elements.Reply;

public class LazyMessageFactory implements IMessageFactory {
    @Override
    public BaseRequest getMessage(Object chatID,Reply reply) {
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
