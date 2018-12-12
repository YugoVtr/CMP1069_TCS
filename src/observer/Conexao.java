
package observer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * @author Yugo
 */
public class Conexao extends Observable implements Observer, Runnable {
    
    Observable servidor; 
    Socket socket;
    String msg; 
    
    public Conexao(Observable servidor, Socket s) throws Exception {
        if (s.isConnected()) {
            Observer o = this;
            this.servidor = servidor;
            servidor.addObserver(o);
            this.socket = s;    
        } else {
            System.out.println("Disconectado...\n");
        }

    }
    
    public Socket getSocket() {
        return this.socket; 
    }
    
    @Override
    public void update(Observable o, Object o1) {
        try {
            if(o instanceof Servidor && socket.isConnected()) {
                Servidor server = (Servidor) o; 
                String msg = server.getMsg(); 
                PrintStream saida = new PrintStream(socket.getOutputStream());
                saida.println(msg);
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
    
    public String getMsg() { 
        return this.msg; 
    }

    @Override
    public void run() {
        try {
            while(true) { 
                if(!socket.isConnected()) { 
                    servidor.deleteObserver(this);
                    this.deleteObservers();
                    socket.close();
                    return;
                } 
                Scanner entrada = new Scanner(socket.getInputStream());
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
