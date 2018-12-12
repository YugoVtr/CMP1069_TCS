package observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
            osw.write(msg, 0, msg.length());
        } else {
            System.out.println("Disconectado...\n");
        }
    }

    @Override
    public void run() {
        try {            
            while (true) {
                if( this.s.isConnected()) {
                    Scanner entrada = new Scanner(s.getInputStream());
                    String dados = ""; 
                    while(entrada.hasNext()) { 
                        dados += entrada.next() + "\n"; 
                    }
                    if(msg.isEmpty()) {
                        this.msg = dados; 
                        setChanged();
                        notifyObservers();
                    }
                } else {
                    System.out.println("Disconectado... \n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
}
