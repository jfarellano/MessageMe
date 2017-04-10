package managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import structures.User;

public class UserManager {
    public ArrayList<User> users;
    private String ruta = "users.txt";
    private String sep = "|";
    private File File = new File(ruta);

    public UserManager() throws Exception {
        this.users = new ArrayList<User>();
        load();
    }
    
    public User get(int ID){
        for (User u: users) {
            if(u.getID() == ID) return u;
        }
        return null;
    }
    
    public User getNick(String nick){
        for (User u: users) {
            if(u.getNickname()== nick) return u;
        }
        return null;
    }
    
    public User authenticateUser(String nick, String pass){
        if(getNick(nick).getPass().equals(pass)) return getNick(nick);
        return null;
    }
    
    public boolean createUser(String nombre, String Nickname, String pass) throws IOException{
        User u = new User(nombre, Nickname, pass, 0);
        users.add(u);
        u.setID(users.indexOf(u));
        if(save()) return true;
        return false; 
    }
    
    public boolean deleteUser(int ID) throws IOException{
        get(ID).setAlive(false);
        if(save())return true;
        return false;
    }
    
    public boolean save() throws FileNotFoundException, IOException{
        File aux = new File("ayuda.txt");
        if (!File.exists()) {
            File.createNewFile();
            aux.createNewFile();
        }
        PrintWriter Bw = new PrintWriter(aux);
        BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        String s = "";
        for(User u: users){
            if(u.isAlive()){
                s = u.getID() + sep + u.getNickname() + sep + u.getNombre() + sep + u.getPass();
                Bw.println(s);
            }
        }
        br.close();
        Bw.close();
        File.delete();
        aux.renameTo(new File(ruta));
        aux.delete();
        return true;
    }
    
    public boolean load() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String line;
        while ((line = br.readLine()) != null){
            String[] user = line.split(sep);
            users.add(Integer.parseInt(user[0]), new User(user[2], user[1], user[3], Integer.parseInt(user[0])));
        }
        br.close();
        return true;
    }
}
