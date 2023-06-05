package ru.lazybot;

import ru.lazybot.elements.Replies;

import java.util.List;

public class LazyRepliesManager extends BaseRepliesManager {

    public LazyRepliesManager(List<Replies> listReplies) {
        super(listReplies);
    }

    @Override
    public UserReplies setUserReplies(Replies replies) {
        return new LazyUserReplies(replies);
    }

}
