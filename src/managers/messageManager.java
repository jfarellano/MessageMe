package managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import structures.Chat;
import structures.Message;

public class messageManager {
    ArrayList<Message> messages;
    String ruta = "messages.txt";
    File File = new File(ruta);
    String sep = "|";
    
    public ArrayList<Message> getMessages(int ID){
        ArrayList<Message> a = new ArrayList<Message>();
        for(Message m:messages){
            if(m.getChat_ID() == ID) a.add(m);
        }
        a.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
        return a;
    }
    
    public void createMessage(int usrID,int chatID, String name){
        Message m = new Message(0, usrID, chatID, name);
        messages.add(m);
        m.setID(messages.indexOf(m));
    }
    
    public void save() throws IOException{
        File aux = new File("ayuda.txt");
        if (!File.exists()) {
            File.createNewFile();
            aux.createNewFile();
        }
        PrintWriter Bw;
        Bw = new PrintWriter(aux);
        BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        String s = "";
        for(Message m: messages){
            s = m.getID() + sep + m.getUsr_ID() + sep + m.getChat_ID() + sep + m.getMessage() + sep + m.getDate();
            Bw.println(s);
        }
        br.close();
        Bw.close();
        File.delete();
        aux.renameTo(new File(ruta));
        aux.delete();
    }
    
    public void load() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String line;
        while ((line = br.readLine()) != null){
            String[] message = line.split(sep);
            messages.add(Integer.parseInt(message[0]), new Message(Integer.parseInt(message[0]), Integer.parseInt(message[1]), Integer.parseInt(message[2]), message[3], Date.valueOf(message[4])));
        }
        br.close();
    }
}
