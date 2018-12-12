package observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Yugo
 */
public class Servidor extends Observable implements Runnable{
    
    ServerSocket ss;
    CopyOnWriteArrayList<Conexao> conexoes;
    String msg; 
    
    public Servidor(int porta) { 
        try {
            this.ss         = new ServerSocket(porta); 
            this.conexoes   = new CopyOnWriteArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void receber() { 
        try {
            while(true) { 
                for (Conexao c : this.conexoes) { 
                    Socket s = c.getSocket(); 
                    BufferedReader bfr = new BufferedReader(new InputStreamReader (s.getInputStream()));
                    String dados = bfr.readLine(); 
                    if (!dados.isEmpty()) { 
                        this.msg = dados; 
                        setChanged();
                        notifyObservers();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public String getMsg() { 
        return msg; 
    }
    
    @Override
    public void run() {
        while(true) { 
            try {
                Socket socket = ss.accept();
                Conexao c = new Conexao(this, socket); 
                this.conexoes.add(c); 
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            
        }
    }
}
