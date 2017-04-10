package structures;
public class User {
    private String nombre, nickname, pass;
    private int ID;
    private boolean logIn, alive;

    public User(String nombre, String nickname, String pass, int ID) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.pass = pass;
        this.ID = ID;
        this.logIn = false;
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }
    
    
}
