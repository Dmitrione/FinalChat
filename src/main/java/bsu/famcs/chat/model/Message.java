package bsu.famcs.chat.model;

public class Message {
    private final String id;
    private String user;
    private String text;
    private String sendDate;

    public Message(String id, String user, String text, String sendDate) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.sendDate = sendDate;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public String getSendDate() {
        return sendDate;
    }

    @Override
    public String toString() {
        return "{\"text\":\"" + text + "\", \"user\":\"" + user + "\", \"id\":\"" + id + "\", \"sendDate\":\"" + sendDate + "\"}";
    }

    public String getUserMessage() {
        return getSendDate() + ' ' + user + " : " + getText();
    }
}
