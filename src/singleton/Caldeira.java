package singleton;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Caldeira extends Observable {

    // Attributes
    private static Caldeira instancia;
    private float temperaturaMax = 0;
    private float temperaturaMin = 0;
    private float nivelMax = 0;
    private float nivelMin = 0;
    private float temperaturaCorrente = 0;
    private float nivelCorrente = 0;
    private float temperaturaFonteCalor = 0; 

    // Methods
    private Caldeira() {
    }
    
    public static Caldeira getInstancia() {
        if (instancia == null) {
            instancia = new Caldeira();
        }
        return instancia;
    }

    public void iniciar(float tMax, float tMin, float nMax, float nMin) {
        temperaturaMax = tMax;
        temperaturaMin = tMin;
        nivelMax = nMax;
        nivelMin = nMin;
        temperaturaCorrente = (temperaturaMax + temperaturaMin) / 2;
        temperaturaFonteCalor = (temperaturaMax + temperaturaMin) / 2;
        nivelCorrente = (nivelMax + nivelMin) / 2;
        this.simulacao();
    }
    
    public void alterarTemperaturaFonteCalor(float novaTemperatura) {
        this.temperaturaFonteCalor = novaTemperatura;
        setChanged();
        notifyObservers();
    }
    
    public void adicionalNivel(float quantidade){
        this.nivelCorrente += quantidade;
        setChanged();
        notifyObservers();
    }

    public void setTemperaturaCorrente(float temperaturaCorrente) {
        this.temperaturaCorrente = temperaturaCorrente;
        setChanged();
        notifyObservers();
    }

    public void setNivelCorrente(float nivelCorrente) {
        this.nivelCorrente = nivelCorrente;
        setChanged();
        notifyObservers();
    }
    
    // Getters and Setters 
    public float getTemperaturaMax() {
        return temperaturaMax;
    }

    public float getTemperaturaMin() {
        return temperaturaMin;
    }

    public float getNivelMax() {
        return nivelMax;
    }

    public float getNivelMin() {
        return nivelMin;
    }

    public float getTemperaturaCorrente() {
        return temperaturaCorrente;
    }

    public float getNivelCorrente() {
        return nivelCorrente;
    }
    
    public float getTemperaturaFonteCalor() {
        return temperaturaFonteCalor;
    }
    
    private void simulacao() {
        //Rotina para atualizar as informacoes na tela
        int SEC = 1000;
        TimerTask tasknew = new TimerTask() {
            @Override
            public void run() {
                
                Caldeira caldeira = Caldeira.getInstancia();
                if(caldeira.estaNivelAlto() || caldeira.estaNivelBaixo() ||
                   caldeira.estaTemperaturaAlta() || caldeira.estaTemperaturaBaixa()) {
                    return; 
                }

                //Simula Temperatura
                float diffTemp = caldeira.getTemperaturaFonteCalor() - caldeira.getTemperaturaCorrente();
                float newTemp = diffTemp * (float)(0.02);
                caldeira.setTemperaturaCorrente(caldeira.getTemperaturaCorrente() + newTemp);

                //Simula nivel
                float taxa = caldeira.getTemperaturaCorrente() * (float)(0.002);
                float novoNivel = caldeira.getNivelCorrente();
                novoNivel -= taxa;
                if (novoNivel > 0) {
                    caldeira.setNivelCorrente(novoNivel);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(tasknew, SEC, SEC);
    }
        
    public boolean estaNivelAlto() { 
        return nivelCorrente > nivelMax; 
    }
    public boolean estaNivelBaixo() { 
        return nivelCorrente < nivelMin; 
    }
    public boolean estaTemperaturaAlta() { 
        return temperaturaCorrente > temperaturaMax; 
    }
    public boolean estaTemperaturaBaixa() { 
        return temperaturaCorrente < temperaturaMin; 
    }
    public boolean eNivelCritico() { 
        float range = nivelMax - nivelMin; 
        float percent = (nivelCorrente/range) - 1; 
        return percent > 0.75 || percent < 0.25; 
    }
    public boolean eTemperaturaCritica() {
        float range = temperaturaMax - temperaturaMin; 
        float percent = (temperaturaCorrente/range) - 1; 
        return percent > 0.75 || percent < 0.25; 
    }
    
    @Override
    public String toString() {
        return "Caldeira [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }
    
}
