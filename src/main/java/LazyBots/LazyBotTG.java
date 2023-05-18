package LazyBots;

import UpdatesHandling.UpdatesHandler;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AbstractSendRequest;

import java.util.List;

public abstract class LazyBotTG {
    private UpdatesHandler updatesHandler;
    private TelegramBot telegramBotAPI;
    public LazyBotTG(String botPath) {
        updatesHandler = new UpdatesHandler(botPath);
        telegramBotAPI = new TelegramBot("");
    }

    public void start() {
        telegramBotAPI.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> list) {
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });
    }

    public abstract void savedData();
    public abstract List<AbstractSendRequest> getReplies(List<AbstractSendRequest> replies);

}
