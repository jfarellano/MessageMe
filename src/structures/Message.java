package structures;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

public class Message {
    private int ID, usr_ID, chat_ID;
    private String message;
    Date date;

    public Message(int ID, int usr_ID, int chat_ID, String message) {
        this.ID = ID;
        this.usr_ID = usr_ID;
        this.chat_ID = chat_ID;
        this.message = message;
        this.date = new Date();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUsr_ID() {
        return usr_ID;
    }

    public void setUsr_ID(int usr_ID) {
        this.usr_ID = usr_ID;
    }

    public int getChat_ID() {
        return chat_ID;
    }

    public void setChat_ID(int chat_ID) {
        this.chat_ID = chat_ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
