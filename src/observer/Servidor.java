package observer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Yugo
 */
public class Servidor extends Observable implements Observer {
    
    ServerSocket ss;
    String msg; 
    
    public Servidor(int porta) { 
        try {
            this.ss = new ServerSocket(porta); 
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
        
    public String getMsg() { 
        return msg; 
    }
    
    public void start() {
        System.out.println("================ SERVER START ==============\n");
        while(true) { 
            try {
                Socket socket = ss.accept();
                Conexao c = new Conexao(this, socket);                          //O servidor vai notificar esta conexao 
                c.addObserver(this);                                            //A conexao deve notificar o servidor
                Thread threadServer = new Thread (c);
                threadServer.start();
                System.out.println("Nova Conexão => " + socket.toString() + "\n");                
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
            
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Conexao) {
            Conexao conexao = (Conexao) o;
            this.msg = conexao.getMsg();
            setChanged();
            notifyObservers();
        }
    }
}
