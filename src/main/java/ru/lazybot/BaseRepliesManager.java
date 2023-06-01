package ru.lazybot;

import ru.lazybot.elements.Replies;
import ru.lazybot.elements.Reply;

import java.util.List;
import java.util.Map;

public abstract class BaseRepliesManager implements RepliesManager {
    private List<Replies> listReplies;
    private Map<Object,List<Reply>> nextReplies;
    private Map<Object,List<Reply>> sentReplies;

    public BaseRepliesManager(List<Replies> listReplies) {
        this.listReplies = listReplies;
        nextReplies = setNextReplies();
        sentReplies = setSentReplies();
    }

    public List<Replies> getListReplies() {
        return listReplies;
    }

    public Map<Object,List<Reply>> getNextReplies() {
        return nextReplies;
    }

    public Map<Object, List<Reply>> getSentReplies() {
        return sentReplies;
    }

    public abstract Map setNextReplies();
    public abstract Map setSentReplies();
}
