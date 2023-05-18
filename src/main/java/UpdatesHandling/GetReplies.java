package UpdatesHandling;

import XMLElements.Replies;
import XMLElements.Reply;

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

    //TODO: Change (List<Reply> replies) to (Reply reply reply). Implement pass through SaveTo array.
    public List<String> getVariables(List<Reply> replies) {
        List<String> variables= new ArrayList();
        for (Reply reply: replies){
            variables.add(reply.getSaveTo().getVariable() != null ? reply.getSaveTo().getVariable().getValue():null);
        }
        return variables;
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
