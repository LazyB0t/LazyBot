package ru.lazybot;

import com.pengrad.telegrambot.TelegramBot;
import java.io.InputStream;
import ru.lazybot.elements.Bot;

public class LazyBotTG {
  private TelegramBot telegramBotAPI;
  private Bot bot;

  public LazyBotTG(String botPath) {
    this(new DOMBot(botPath));
  }

  public LazyBotTG(InputStream is) {
    this(new DOMBot(is));
  }

  public LazyBotTG(DOMBot domBot) {
    bot = domBot.getBot();
    telegramBotAPI = new TelegramBot(bot.getToken());
  }

  public void start() {
    telegramBotAPI.setUpdatesListener(new LazyUpdatesListener(bot, telegramBotAPI));
  }
}
