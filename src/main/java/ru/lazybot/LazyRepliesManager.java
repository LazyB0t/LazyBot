package ru.lazybot;

import java.util.List;
import ru.lazybot.elements.Replies;

public class LazyRepliesManager extends BaseRepliesManager {

  public LazyRepliesManager(List<Replies> listReplies) {
    super(listReplies);
  }

  @Override
  public UserReplies setUserReplies(Replies replies) {
    return new LazyUserReplies(replies);
  }
}
