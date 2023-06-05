package ru.lazybot;

import ru.lazybot.elements.Replies;
import ru.lazybot.elements.Reply;

import java.util.List;

public interface UserReplies {
    List<Reply> getNextReplies(IncMessage IncMessage);

    List<Reply> getSentReplies();

    void addReplies(Replies replies);

    int getCurrentReply();
}
