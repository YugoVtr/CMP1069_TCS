package observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;
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
                    System.out.println("Monitorando Conexão => " + s.toString() + "\n");
                    if(s.isConnected()) { 
                        Scanner entrada = new Scanner(s.getInputStream());
                        String dados = ""; 
                        while(entrada.hasNext()) { 
                            dados += entrada.next() + "\n"; 
                        }
                        if (!dados.isEmpty()) {
                            System.out.println("Mensagem Recebida => " + s.getInetAddress().toString() + "\n");
                            this.msg = dados; 
                            setChanged();
                            notifyObservers();
                        }
                    } else {
                        System.out.println("Desconectado => " + s.getInetAddress().toString() + "\n");
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
