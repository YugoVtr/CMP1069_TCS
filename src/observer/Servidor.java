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
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
    
    public void receber() { 
        try {
            while(true) { 
                for (Conexao c : this.conexoes) { 
                    Socket s = c.getSocket(); 
                    if(s.isConnected()) { 
                        BufferedReader bfr = new BufferedReader(new InputStreamReader (s.getInputStream()));
                        String dados = bfr.readLine(); 
                        if (!dados.isEmpty()) {
                            System.out.println("Mensagem Recebida => " + s.getInetAddress().toString() + "\n");
                            this.msg = dados; 
                            setChanged();
                            notifyObservers();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
    
    public String getMsg() { 
        return msg; 
    }
    
    @Override
    public void run() {
        System.out.println("================ SERVER START ==============\n");
        while(true) { 
            try {
                Socket socket = ss.accept();
                Conexao c = new Conexao(this, socket);
                System.out.println("Nova Conexão => " + socket.toString() + "\n");
                this.conexoes.add(c); 
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
            
        }
    }
}
