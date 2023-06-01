package ru.lazybot;

import ru.lazybot.elements.Reply;

import java.util.List;

public interface RepliesManager {
    public List<Reply> getSuitableReplies(BaseIncMessage incMessage);
}
