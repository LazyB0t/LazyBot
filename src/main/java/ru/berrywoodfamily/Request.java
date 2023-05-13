package ru.berrywoodfamily;

import com.pengrad.telegrambot.model.Update;

public class Request {
    private Long chatID;
    private String text;
    private String type;

    public Request(Update update){
        chatID = (update.message() == null) ? update.callbackQuery().message().chat().id() : update.message().chat().id();
        text = (update.message() == null) ? update.callbackQuery().data() : update.message().text();
        type = (update.message() == null) ? "button" : "txt";
    }

    public Long getChatID(){
        return chatID;
    }

    public String getText(){
        return text;
    }

    public String getType() {
        return type;
    }
}
