import com.pengrad.telegrambot.model.Update;

public interface IIncMessage {
    public Update getUpdate();
    public String getType();
    public Object getChatID();
}
