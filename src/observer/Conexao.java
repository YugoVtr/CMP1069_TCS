
package observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

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
                this.socket.getOutputStream().write(msg.getBytes());
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
        while(true) { 
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) { 
                    if (!line.isEmpty()) {
                        System.out.println("Mensagem Recebida => " + socket.toString() + "\n");
                        this.msg = line; 
                        setChanged();
                        notifyObservers();
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }
    }
}
