package ru.lazybot;

import ru.lazybot.elements.Replies;
import ru.lazybot.elements.Reply;

import java.util.ArrayList;
import java.util.List;

public class LazyUserReplies extends BaseUserReplies {
    private int currentReply;

    private List<Replies> repliesList;
    private List<Reply> replyList;

    public LazyUserReplies(Replies replies) {
        super(replies);
        repliesList = new ArrayList(2);
        repliesList.add(replies);
        replyList = replies.getReplies();
        currentReply = -1;
    }

    @Override
    public List<Reply> getNextReplies(IncMessage incMessage) {
        List<Reply> nextReplies = new ArrayList();
        if (currentReply == replyList.size() - 1) {
            return null;
        }
        if (replyList.get(currentReply + 1) != null && replyList.get(currentReply + 1).hasAttribute("wait")) {
            if (!replyList.get(currentReply + 1).getAttribute("wait").equals(incMessage.getType())) {
                return nextReplies;
            } else {
                nextReplies.add(replyList.get(currentReply + 1));
                currentReply += 1;
            }
        }
        for (int i = currentReply + 1; i < replyList.size(); i++) {
            if (!replyList.get(i).hasAttribute("wait")) {
                nextReplies.add(replyList.get(i));
                currentReply += 1;
            } else {
                break;
            }
        }
        return nextReplies;
    }

    @Override
    //TODO: Implement the method.
    public List<Reply> getSentReplies() {
        return null;
    }

    @Override
    public void addReplies(Replies replies) {
        if (repliesList.size() == 2) {
            repliesList.remove(0);
            repliesList.add(replies);
        } else {
            repliesList.add(replies);
        }
        replyList = repliesList.get(1).getReplies();
    }

    @Override
    public int getCurrentReply() {
        return currentReply;
    }
}
