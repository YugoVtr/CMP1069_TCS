package main;

//Singleton
import singleton.CaldeiraWindow;

//Iterator 
import iterator.ProfessorWindow; 

//Observer 
import observer.Tipo; 
import observer.ChatWindow; 
import observer.Servidor; 

//Imobiliaria
import imobiliaria.ImobiliariaMain; 

public class Main {

    public static void main(String[] args) {
        try {
            int arg = (args.length > 0) ? Integer.parseInt(args[0]) : -1 ;
            int obs = (args.length == 2) ? Integer.parseInt(args[1]) : 0 ;
            switch (arg) { 
                case 0: singleton();
                        break; 
                case 1: iterator();
                        break; 
                case 2: observer(Tipo.Integer(obs));
                        break; 
                case 3: imobiliaria(args);
                        break; 
                default: System.out.println("Programa invalido \n");
                        break; 
            }
            
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
            //Objeto Para receber as conexões no servidor
            Servidor servidor = new Servidor(7777);
            servidor.start();
        } else if ( t == Tipo.CLIENTE ) { 
            // Janela do cliente
            ChatWindow.main(null);
        }
    }
    
    private static void imobiliaria(String[] args) {
        ImobiliariaMain.main(args);
    }
}
