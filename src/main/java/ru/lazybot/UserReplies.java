package ru.lazybot;

import java.util.List;
import ru.lazybot.elements.Replies;
import ru.lazybot.elements.Reply;

public interface UserReplies {
  List<Reply> getNextReplies(IncMessage IncMessage);

  List<Reply> getSentReplies(IncMessage incMessage);

  void addReplies(Replies replies);

  int getCurrentReply();
}
