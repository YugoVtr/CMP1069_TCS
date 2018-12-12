package main;

//Singleton
import singleton.CaldeiraWindow;

//Iterator 
import iterator.ProfessorWindow; 

//Observer 
import observer.Tipo; 
import observer.ChatWindow; 
import observer.Servidor; 

public class Main {

    public static void main(String[] args) {
        try {
            //singleton();
            //iterator();
            int arg = (args.length > 0) ? Integer.parseInt(args[0]) : 0 ;
            observer(Tipo.Integer(arg)); 
        } catch (Exception e) {
            System.out.print(e.getMessage() + "\n");
        }
    }

    private static void singleton() {
        CaldeiraWindow.main(null);
    }
    
    private static void iterator() { 
        ProfessorWindow.main(null); 
    }
    
    private static void observer(Tipo t) {
        if ( t == Tipo.SERVIDOR ) { 
            Servidor servidor = new Servidor(7777);
            Thread threadServer = new Thread (servidor);
            threadServer.start();
            servidor.receber();
        } else if ( t == Tipo.CLIENTE ) { 
            ChatWindow.main(null);
        }
    }
}
