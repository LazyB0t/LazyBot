package ru.lazybot;

import ru.lazybot.elements.Reply;

import java.util.List;

public interface IRepliesManager {
    public List<Reply> getSuitableReplies(AbsIncMessage incMessage);
}
