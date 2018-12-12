
package observer;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Yugo
 */
public class Conexao implements Observer {
    
    Observable servidor; 
    Socket socket;
    public Conexao(Observable servidor, Socket s) throws Exception {
        Observer o = this;
        this.servidor = servidor;
        servidor.addObserver(o);
        this.socket = s;
    }
    
    public Socket getSocket() {
        return this.socket; 
    }
    
    @Override
    public void update(Observable o, Object o1) {
        try {
            if(o instanceof Servidor) {
                Servidor server = (Servidor) o; 
                String msg = server.getMsg(); 
                this.socket.getOutputStream().write(msg.getBytes());
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
}
