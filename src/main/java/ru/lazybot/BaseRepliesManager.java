package ru.lazybot;

import ru.lazybot.elements.Replies;
import ru.lazybot.elements.Reply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseRepliesManager implements RepliesManager {
    private List<Replies> listReplies;
    private Map<Object, UserReplies> users;

    public BaseRepliesManager(List<Replies> listReplies) {
        this.listReplies = listReplies;
        users = new HashMap();
    }

    public List<Replies> getListReplies() {
        return listReplies;
    }

    @Override
    public List<Reply> getSuitableReplies(BaseIncMessage incMessage) {
        List<Reply> suitableReplies = new ArrayList();
        if (users.get(incMessage.getChatID()) != null) {
            if (incMessage.getType().equals("backButton")) {
                suitableReplies = users.get(incMessage.getChatID()).getSentReplies(incMessage);
                return suitableReplies;
            } else {
                suitableReplies = users.get(incMessage.getChatID()).getNextReplies(incMessage);
                if (suitableReplies != null) {
                    return suitableReplies;
                }
            }
        }
        for (Replies replies: getListReplies()) {
            if (replies.getAfter().equals(incMessage.getCommand())) {
                if (users.get(incMessage.getChatID()) != null) {
                    users.get(incMessage.getChatID()).addReplies(replies);
                } else {
                    users.put(incMessage.getChatID(), setUserReplies(replies));
                }
                suitableReplies = users.get(incMessage.getChatID()).getNextReplies(incMessage);
                break;
            }
        }
        return suitableReplies;
    }

    public abstract UserReplies setUserReplies(Replies replies);
}
