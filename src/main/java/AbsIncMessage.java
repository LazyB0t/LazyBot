import com.pengrad.telegrambot.model.Update;

public abstract class AbsIncMessage implements IIncMessage {
    private Update update;
    public AbsIncMessage(Update update) {
        this.update = update;
    }
    public abstract String getData(String dataType);

    @Override
    public Update getUpdate() {
        return update;
    }
}
