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
    Socket s; 
    
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
        this.s.getOutputStream().write(msg.getBytes());
    }

    @Override
    public void run() {
        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader (s.getInputStream()));
            while (true) {
                this.msg = bfr.readLine();
                setChanged();
                notifyObservers();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
}
