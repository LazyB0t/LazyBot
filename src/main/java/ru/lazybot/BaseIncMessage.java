package ru.lazybot;

import com.pengrad.telegrambot.model.Update;

public abstract class BaseIncMessage implements IncMessage {
    private Update update;
    public BaseIncMessage(Update update) {
        this.update = update;
    }
    public abstract String getData(String dataType);

    @Override
    public Update getUpdate() {
        return update;
    }
}
