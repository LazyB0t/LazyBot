package ru.lazybot;

import com.pengrad.telegrambot.request.BaseRequest;
import ru.lazybot.elements.Reply;

public interface IMessageFactory {
    public BaseRequest getMessage(Object chatID, Reply reply);
}
