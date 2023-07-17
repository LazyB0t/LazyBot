package ru.lazybot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AnswerCallbackQuery;
import com.pengrad.telegrambot.request.BaseRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import ru.lazybot.elements.*;

public abstract class BaseUpdatesListener implements UpdatesListener {
  private RepliesManager RepliesManager;
  private MessageFactory messageFactory;
  private TelegramBot tgBotAPI;

  public BaseUpdatesListener(Bot bot, TelegramBot tgBotAPI) {
    RepliesManager = setRepliesManager(bot.getReplies());
    messageFactory = setMessageFactory();
    this.tgBotAPI = tgBotAPI;
  }

  public BaseUpdatesListener(String botPath, TelegramBot tgBotAPI) {
    this(new DOMBot(botPath).getBot(), tgBotAPI);
  }

  public BaseUpdatesListener(InputStream is, TelegramBot tgBotAPI) {
    this(new DOMBot(is).getBot(), tgBotAPI);
  }

  @Override
  public int process(List<Update> list) {
    List<BaseRequest> tgReplies = new ArrayList();
    for (Update update : list) {
      BaseIncMessage incMessage = setIncMessage(update);
      getNewUpdate(update);
      if (incMessage.getType().equals("button") || incMessage.getType().equals("backButton")) {
        tgReplies.add(new AnswerCallbackQuery(update.callbackQuery().id()));
      }
      for (Reply reply : RepliesManager.getSuitableReplies(incMessage)) {
        saveData(reply.getSaves(), incMessage);
        tgReplies.add(messageFactory.getMessage(incMessage.getChatID(), reply));
      }
    }
    for (BaseRequest tgReply : getMessages(tgReplies)) {
      tgBotAPI.execute(tgReply);
    }
    return UpdatesListener.CONFIRMED_UPDATES_ALL;
  }

  public abstract void getNewUpdate(Update update);

  public abstract void saveData(List<SaveTo> saves, BaseIncMessage incMessage);

  public abstract List<BaseRequest> getMessages(List<BaseRequest> tgReplies);

  public abstract RepliesManager setRepliesManager(List<Replies> listReplies);

  public abstract MessageFactory setMessageFactory();

  public abstract BaseIncMessage setIncMessage(Update update);
}
