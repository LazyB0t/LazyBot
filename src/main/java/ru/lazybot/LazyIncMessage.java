package ru.lazybot;

import com.pengrad.telegrambot.model.Update;
import java.util.HashMap;
import java.util.Map;

public class LazyIncMessage extends BaseIncMessage {
  private String type;
  private Object chatID;
  private Map<String, String> data;
  private String command = "";

  public LazyIncMessage(Update update) {
    super(update);
    data = new HashMap();
    if (update.callbackQuery() != null) {
      if (update.callbackQuery().data().contains("/back;")) {
        type = "backButton";
        command = update.callbackQuery().data().split(";")[1];
        data.put("callback", update.callbackQuery().data());
      } else {
        type = "button";
        command = update.callbackQuery().data();
        data.put("callback", command);
      }
      chatID = update.callbackQuery().message().chat().id();
    } else if (update.message() != null) {
      if (update.message().text() != null) {
        type = "text";
        command = update.message().text();
        data.put("text", command);
      } else if (update.message().photo() != null) {
        type = "photo";
        data.put("photo", update.message().photo()[0].fileId());
        data.put("caption", update.message().caption());
      } else if (update.message().document() != null) {
        type = "document";
        data.put("document", update.message().document().fileId());
        data.put("mimeType", update.message().document().mimeType());
      }
      chatID = update.message().chat().id();
    } else {
      type = "unknown";
      chatID = 0l;
    }
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public Object getChatID() {
    return chatID;
  }

  @Override
  public Map<String, String> getData() {
    return data;
  }

  @Override
  public String getData(String dataType) {
    return data.get(dataType);
  }

  @Override
  public String getCommand() {
    return command;
  }
}
