/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author fernando
 */
public class Notificacao {
    //atributos
    private static Notificacao instancia;
    private String notify01 = "O Nivel de Agua na Caldeira esta baixo!! Procure o RH";
    private String notify02 = "O Nivel de Agua na Caldeira esta alto!! Procure o RH";
    private String notify03 = "A Temperatura da Caldeira esta baixa!! Procure o RH";
    private String notify04 = "Parabéns a Caldeira explodiu!!!! Procure o RH imediatamente!!";
    
    //metodos
    public Notificacao(){
       
    }
    public static Notificacao getInstancia(){
        if(instancia == null){
            instancia = new Notificacao();
        }
        return instancia;
    }

    public String getNotify01() {
        return notify01;
    }

    public void setNotify01(String notify01) {
        this.notify01 = notify01;
    }
    
    public String getNotify02() {
        return notify02;
    }

    public void setNotify02(String notify02) {
        this.notify02 = notify02;
    }

    public String getNotify03() {
        return notify03;
    }

    public void setNotify03(String notify03) {
        this.notify03 = notify03;
    }

    public String getNotify04() {
        return notify04;
    }

    public void setNotify04(String notify04) {
        this.notify04 = notify04;
    }
}
