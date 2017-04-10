package structures;

public class Chat {
    private int ID, usr1_ID, usr2_ID;

    public Chat(int ID, int usr1_ID, int usr2_ID) {
        this.ID = ID;
        this.usr1_ID = usr1_ID;
        this.usr2_ID = usr2_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUsr1_ID() {
        return usr1_ID;
    }

    public void setUsr1_ID(int usr1_ID) {
        this.usr1_ID = usr1_ID;
    }

    public int getUsr2_ID() {
        return usr2_ID;
    }

    public void setUsr2_ID(int usr2_ID) {
        this.usr2_ID = usr2_ID;
    }
}
