package ru.lazybot;

import ru.lazybot.elements.Replies;

public abstract class BaseUserReplies implements UserReplies {
  private Replies replies;

  public BaseUserReplies(Replies replies) {
    this.replies = replies;
  }

  public Replies getReplies() {
    return replies;
  }
}
