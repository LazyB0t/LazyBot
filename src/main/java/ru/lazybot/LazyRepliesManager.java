package ru.lazybot;

import ru.lazybot.elements.Replies;
import ru.lazybot.elements.Reply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyRepliesManager extends BaseRepliesManager {

    public LazyRepliesManager(List<Replies> listReplies) {
        super(listReplies);
    }

    @Override
    public Map setNextReplies() {
        return new HashMap();
    }

    @Override
    public Map setSentReplies() {
        return new HashMap();
    }

    //TODO: Made a temporary solution. Reworked the method with the BaseIncMessage class in mind.
    @Override
    public List<Reply> getSuitableReplies(BaseIncMessage incMessage) {
        Object chatID = incMessage.getChatID();
        String data = incMessage.getData("");
        if (getNextReplies().containsKey(chatID)) {
            List<Reply> replies = getNextReplies().get(chatID);
            getNextReplies().remove(chatID);
            return findReplies(chatID, replies);
        } else {
            return findReplies(chatID, data);
        }
    }

    private List<Reply> findReplies(Object chatID, String after) {
        List<Reply> relevantReplies = new ArrayList();
        for (Replies replies : getListReplies()) {
            if (replies.getAfter().equals(after)) {
                relevantReplies = replies.getReplies();
                break;
            }
        }
        for (Reply reply : relevantReplies) {
            if (reply.hasAttribute("wait")) {
                getNextReplies().put(chatID,relevantReplies.subList(relevantReplies.indexOf(reply),relevantReplies.size()));
                relevantReplies = relevantReplies.subList(0, relevantReplies.indexOf(reply));
                break;
            }
        }
        return relevantReplies;
    }

    private List<Reply> findReplies(Object chatID, List<Reply> replies) {
        for (Reply reply : replies.subList(1,replies.size())) {
            if (reply.hasAttribute("wait")) {
                getNextReplies().put(chatID,replies.subList(replies.indexOf(reply),replies.size()));
                replies = replies.subList(0, replies.indexOf(reply));
                break;
            }
        }
        return replies;
    }
}
