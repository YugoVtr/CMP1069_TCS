
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
}
