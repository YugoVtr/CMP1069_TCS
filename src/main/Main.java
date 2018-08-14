package main;

import java.util.Timer;
import java.util.TimerTask;
import singleton.CaldeiraWindow;
import singleton.WindowHelper;

public class Main {

    public static void main(String[] args) {
        try {
            
            //Rotina para atualizar as informacoes na tela
            int SEC = 1000;
            TimerTask tasknew = new WindowHelper();
            Timer timer = new Timer();
            timer.schedule(tasknew, SEC, SEC);
            
            CaldeiraWindow.main(args);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
