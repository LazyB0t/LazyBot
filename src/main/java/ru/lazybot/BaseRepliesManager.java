package ru.lazybot;

import ru.lazybot.elements.Replies;
import ru.lazybot.elements.Reply;

import java.util.List;
import java.util.Map;

public abstract class BaseRepliesManager implements RepliesManager {
    private List<Replies> listReplies;
    private Map<Object,Reply> nextReply;
    private Map<Object,List<Reply>> sentReplies;

    public BaseRepliesManager(List<Replies> listReplies) {
        this.listReplies = listReplies;
        nextReply = setNextReplies();
        sentReplies = setSentReplies();
    }

    public List<Replies> getListReplies() {
        return listReplies;
    }

    public Map<Object, Reply> getNextReply() {
        return nextReply;
    }

    public Map<Object, List<Reply>> getSentReplies() {
        return sentReplies;
    }

    @Override
    public List<Reply> getSuitableReplies(BaseIncMessage incMessage) {
        if (incMessage.getType().equals("button") && incMessage.getData("callback").equals("Back")) {
            if (!getSentReplies().isEmpty()) {
                List<Reply> listSentReplies = getSentReplies().get(incMessage.getChatID());
                Reply sentReply = listSentReplies.get(listSentReplies.size() - 1);
                listSentReplies.remove(listSentReplies.size() - 1);
                return findRepliesByReply(incMessage, sentReply);
            }
        } else if (getNextReply().containsKey(incMessage.getChatID())) {
            Reply nextReply = getNextReply().get(incMessage.getChatID());
            getNextReply().remove(incMessage.getChatID());
            return findRepliesByReply(incMessage, nextReply);
        } else {
            return findRepliesByData(incMessage);
        }
        return null;
    }

    public abstract Map setNextReplies();

    public abstract Map setSentReplies();

    public abstract List<Reply> findRepliesByData(BaseIncMessage incMessage);

    public abstract List<Reply> findRepliesByReply(BaseIncMessage incMessage, Reply reply);
}
