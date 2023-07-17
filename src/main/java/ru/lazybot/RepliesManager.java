package ru.lazybot;

import java.util.List;
import ru.lazybot.elements.Reply;

public interface RepliesManager {
  public List<Reply> getSuitableReplies(BaseIncMessage incMessage);
}
