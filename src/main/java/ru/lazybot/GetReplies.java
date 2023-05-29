package ru.lazybot;

import ru.lazybot.elements.Replies;
import ru.lazybot.elements.Reply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetReplies {
    private List<Replies> listReplies;
    private Map<Object,List<Reply>> nextReplies;

    public GetReplies(List<Replies> listReplies) {
        this.listReplies = listReplies;
        nextReplies = new HashMap();
    }

    public List<Reply> replies(Object chatID, String updateData) {
        if (nextReplies.containsKey(chatID)) {
            List<Reply> replies = nextReplies.get(chatID);
            nextReplies.remove(chatID);
            return findReplies(chatID, replies);
        } else {
            return findReplies(chatID, updateData);
        }
    }

    private List<Reply> findReplies(Object chatID, String after) {
        List<Reply> relevantReplies = new ArrayList();
        for (Replies replies : listReplies) {
            if (replies.getAfter().equals(after)) {
                relevantReplies = replies.getReplies();
                break;
            }
        }
        for (Reply reply : relevantReplies) {
            if (reply.hasAttribute("wait")) {
                nextReplies.put(chatID,relevantReplies.subList(relevantReplies.indexOf(reply),relevantReplies.size()));
                relevantReplies = relevantReplies.subList(0, relevantReplies.indexOf(reply));
                break;
            }
        }
        return relevantReplies;
    }

    private List<Reply> findReplies(Object chatID, List<Reply> replies) {
        for (Reply reply : replies.subList(1,replies.size())) {
            if (reply.hasAttribute("wait")) {
                nextReplies.put(chatID,replies.subList(replies.indexOf(reply),replies.size()));
                replies = replies.subList(0, replies.indexOf(reply));
                break;
            }
        }
        return replies;
    }
}
