package ru.berrywoodfamily;

import com.pengrad.telegrambot.request.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class IncomingMessageHandler {
    private BotConfig botConfig;
    public IncomingMessageHandler(BotConfig botConfig){
        this.botConfig = botConfig;
    }
    public List<SendMessage> getReplies(Request request){
        List<SendMessage> replies = new ArrayList<>();
        for (Reply reply:botConfig.getReplies()) {
            if (request.getText().equals(reply.getAfter())) {
                TelegramReply tgReply = new TelegramReply(request.getChatID());
                replies.add(tgReply.getReply(reply));
                replies.add(getNext(reply.getNext(),request.getChatID()));
            }
        }
        return replies;
    }

    private SendMessage getNext(String next, Long chatID){
        SendMessage message = null;
        for (Reply reply:botConfig.getReplies()) {
            if (reply.getName() != null ? reply.getName().equals(next): false ) {
                TelegramReply tgReply = new TelegramReply(chatID);
                message = tgReply.getReply(reply);
            }
        }
        return message;
    }
}
