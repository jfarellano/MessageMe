package managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import structures.Chat;
import structures.User;

public class chatManager {
    UserManager um;
    ArrayList<Chat> chats;
    String ruta = "chats.txt";
    private String sep = "|";
    private File File = new File(ruta);

    public chatManager(UserManager um) throws Exception {
        this.um = um;
        this.chats = new ArrayList<Chat>();
        load();
    }

    public ArrayList<Chat> get(int ID){
        ArrayList a = new ArrayList<Chat>();
        for(Chat c: chats){
            if(c.getUsr1_ID() == ID || c.getUsr2_ID() == ID) a.add(c);
        }
        return a;
    }
    
    public void createChat(int ID1,int ID2) throws IOException{
        Chat c = new Chat(0, ID1, ID1);
        chats.add(c);
        c.setID(chats.indexOf(c));
        save();
    }
    
    public void save() throws FileNotFoundException, IOException{
        File aux = new File("ayuda.txt");
        if (!File.exists()) {
            File.createNewFile();
            aux.createNewFile();
        }
        PrintWriter Bw = new PrintWriter(aux);
        BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        String s = "";
        for(Chat c: chats){
            if(um.get(c.getUsr1_ID()).isAlive() && um.get(c.getUsr2_ID()).isAlive()){
                s = c.getID() + sep + c.getUsr1_ID() + sep + c.getUsr2_ID();
                Bw.println(s);
            }
        }
        br.close();
        Bw.close();
        File.delete();
        aux.renameTo(new File(ruta));
        aux.delete();
    }
    
    public boolean load() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String line;
        while ((line = br.readLine()) != null){
            String[] chat = line.split(sep);
            chats.add(Integer.parseInt(chat[0]), new Chat(Integer.parseInt(chat[0]),Integer.parseInt(chat[1]),Integer.parseInt(chat[2])));
        }
        br.close();
        return true;
    }
}
