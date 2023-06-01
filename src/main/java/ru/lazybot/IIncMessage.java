package ru.lazybot;

import com.pengrad.telegrambot.model.Update;

import java.util.Map;

public interface IIncMessage {
    public Update getUpdate();
    public String getType();
    public Object getChatID();
    public Map<String,String> getData();
}
