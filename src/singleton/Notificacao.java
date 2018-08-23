/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author fernando
 */

public class Notificacao {
      
    public enum Mensagens { 
        NIVEL_BAIXO("O Nivel de Agua na Caldeira esta BAIXO!! Procure o RH"),
        NIVEL_ALTO("O Nivel de Agua na Caldeira esta ALTO!! Procure o RH"),
        TEMPERATURA_BAIXA("A Temperatura da Caldeira esta BAIXA!! Procure o RH"),
        TEMPERATURA_ALTA("Parabéns a Caldeira explodiu!!!! Procure o RH imediatamente!!");
        
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
    
    public String nivelAlto() { 
        return Mensagens.NIVEL_ALTO.toString(); 
    }
    
    public String nivelBaixo() { 
        return Mensagens.NIVEL_BAIXO.toString(); 
    }
    
    public String temperaturaAlta() { 
        return Mensagens.TEMPERATURA_ALTA.toString(); 
    }
 
    public String temperaturaBaixa() { 
        return Mensagens.TEMPERATURA_BAIXA.toString(); 
    }
}
