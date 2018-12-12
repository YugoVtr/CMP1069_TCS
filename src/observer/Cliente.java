package observer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

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
            PrintStream saida = new PrintStream(s.getOutputStream());
            saida.println(msg);            
        } else {
            System.out.println("Disconectado...\n");
        }
    }

    @Override
    public void run() {
        try {       
            while (true) {
                if(!s.isConnected()) { 
                    return; 
                }
                Scanner entrada = new Scanner(s.getInputStream());
                String msg = entrada.nextLine(); 
                if(!msg.isEmpty()) {
                    this.msg = msg; 
                    setChanged();
                    notifyObservers();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
}
