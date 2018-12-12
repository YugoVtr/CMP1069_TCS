package observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;

/**
 * @author Yugo
 */
public class Cliente extends Observable implements Runnable{
    String msg; 
    Socket s = new Socket(); 
    
    public Cliente(String ip, int port) throws Exception {
       try { 
            this.s = new Socket(ip, port);
            if (s == null) throw new Exception("Connection refused"); 
       } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
       }
    }
    
    public String getMsg() { 
        return this.msg; 
    }
    
    public void enviarMsg(String msg) throws IOException { 
        if (this.s.isConnected()) { 
            this.s.getOutputStream().write(msg.getBytes());
        } else {
            System.out.println("Disconectado...\n");
        }
    }

    @Override
    public void run() {
        try {            
            while (true) {
                if( this.s.isConnected()) {
                    BufferedReader bfr = new BufferedReader(new InputStreamReader (s.getInputStream()));
                    String msg = bfr.readLine();
                    if(msg.isEmpty()) {
                        this.msg = msg; 
                        setChanged();
                        notifyObservers();
                    }
                } else {
                    //System.out.println("Disconectado... \n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
}
