package ru.berrywoodfamily;

import com.pengrad.telegrambot.model.Update;

public class Request {
    private Long chatID;
    private String text;

    public Request(Update update){
        chatID = (update.message() == null) ? update.callbackQuery().message().chat().id() : update.message().chat().id();
        text = (update.message() == null) ? update.callbackQuery().data() : update.message().text();
    }

    public Long getChatID(){
        return chatID;
    }

    public String getText(){
        return text;
    }

}
