package singleton;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.util.TimerTask;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class WindowHelper extends TimerTask {
    
    private static List<javax.swing.JTable> table = new ArrayList<javax.swing.JTable>();
    
    public WindowHelper(){
        
    }
    
    public WindowHelper(javax.swing.JTable table) {
        if (table != null) {
            WindowHelper.table.add(table);
        }
    }
    
    public static void addTable(javax.swing.JTable table) {
        if (table != null) {
            WindowHelper.table.add(table);
        }
    }
    
    public static void display(JFrame frame, String position) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screen_height = (int) screenSize.getHeight();
        int frame_width = (int) frame.getWidth();
        int x = frame_width + (int) (frame_width * 0.2);
        int y = screen_height / 4;

        switch (position) {
        case "left":
                x *= 0;
                break;

        case "right":
                x *= 2;
                break;

        default:
                x *= 1;
                break;
        }
        frame.setLocation(x, y);
    }

    @Override
    public void run() {
        Caldeira caldeira = Caldeira.getInstancia();
        
        //Simula Temperatura
        float diffTemp = caldeira.getTemperaturaFonteCalor() - caldeira.getTemperaturaCorrente();
        float newTemp = diffTemp / 10;
        caldeira.setTemperaturaCorrente(caldeira.getTemperaturaCorrente() + newTemp);
        
        //Simula nivel
        float taxa = caldeira.getTemperaturaCorrente() / 100;
        float novoNivel = caldeira.getNivelCorrente();
        novoNivel -= taxa;
        if (novoNivel > 0) {
            caldeira.setNivelCorrente(novoNivel);
        }
        
        //Atualiza as informacoes nas janelas
        for (javax.swing.JTable t : WindowHelper.table) {
            DecimalFormat df = new DecimalFormat("0.00");
            float temp = caldeira.getTemperaturaCorrente();
            float nvl = caldeira.getNivelCorrente();
            t.getModel().setValueAt(df.format(temp),0,3);
            t.getModel().setValueAt(df.format(nvl),1,3);
        }
    }
}
