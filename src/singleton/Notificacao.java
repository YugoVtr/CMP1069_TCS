package singleton;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author fernando
 */

public class Notificacao {
      
    public enum Mensagens { 
        NIVEL_CRITICO("O Nivel de Agua está CRITICO"), 
        NIVEL_BAIXO("O Nivel de Agua na Caldeira esta muito BAIXO!!Procure o RH!!"),
        NIVEL_ALTO("O Nivel de Agua na Caldeira esta TRANSBORDANDO!! Procure o RH"),
        TEMPERATURA_CRITICA("A Temperatura da Caldeira esta CRITICA"), 
        TEMPERATURA_BAIXA("A Temperatura da Caldeira esta muito BAIXA!!Procure o RH!!"),
        TEMPERATURA_ALTA("Parabéns a Caldeira EXPLODIU!!!! Procure o RH imediatamente!!");
        
        private final String msg; 
        
        Mensagens(final String msg) { 
            this.msg = msg; 
        }
        
        @Override
        public String toString() {
            return this.msg;
        }
    };
       
    private final ImageIcon warning = new ImageIcon("src" + File.separator + "singleton" + File.separator + "warning.png");
    private final ImageIcon poison = new ImageIcon("src" + File.separator + "singleton" + File.separator + "poison.png");

    public ImageIcon getWarning(int width, int height) {
        if(width == 0 || height == 0) {
            return warning; 
        }
        Image i = this.warning.getImage();
        Image nova = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(nova);
    }
    
    public ImageIcon getPoison(int width, int height) {
        if(width == 0 || height == 0) {
            return poison; 
        }
        Image i = this.poison.getImage();
        Image nova = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(nova);
    }
            
    //metodos
    public Notificacao(){
       
    }
    
    public String checkNotify(JLabel label){
        Caldeira c = Caldeira.getInstancia(); 
        label.setIcon(null);
        String log_error="";
        
        if(c.eNivelCritico()) {
            label.setIcon(this.getWarning(label.getWidth(), label.getHeight()));
            log_error +=  Mensagens.NIVEL_CRITICO.toString() + "\n"; 
        }
        
        if(c.eTemperaturaCritica()) { 
            label.setIcon(this.getWarning(label.getWidth(), label.getHeight()));
            log_error += Mensagens.TEMPERATURA_CRITICA.toString() + "\n"; 
        }
        
        if (c.estaNivelBaixo()) {
            log_error += Mensagens.NIVEL_BAIXO.toString() + "\n";
            label.setIcon(this.getPoison(label.getWidth(), label.getHeight()));
        }
        if (c.estaNivelAlto()) {
            log_error += Mensagens.NIVEL_ALTO.toString() + "\n";
            label.setIcon(this.getPoison(label.getWidth(), label.getHeight()));
        }
        if (c.estaTemperaturaBaixa()) {
            log_error += Mensagens.TEMPERATURA_BAIXA.toString() + "\n";
            label.setIcon(this.getWarning(label.getWidth(), label.getHeight()));
        }
        if (c.estaTemperaturaAlta()) {
            log_error += Mensagens.TEMPERATURA_ALTA.toString() + "\n";
            label.setIcon(this.getPoison(label.getWidth(), label.getHeight()));
        } 
        return log_error; 
    }
    
}
