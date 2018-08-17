package main;

//Singleton
import java.util.Timer;
import java.util.TimerTask;
import singleton.CaldeiraWindow;
import singleton.WindowHelper;

//Iterator 
import iterator.ProfessorWindow; 

public class Main {

    public static void main(String[] args) {
        try {
            iterator(); 
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static void singleton() {
        //Rotina para atualizar as informacoes na tela
        int SEC = 1000;
        TimerTask tasknew = new WindowHelper();
        Timer timer = new Timer();
        timer.schedule(tasknew, SEC, SEC);
        CaldeiraWindow.main(null);
    }
    
    private static void iterator() { 
        ProfessorWindow.main(null); 
    }

}
