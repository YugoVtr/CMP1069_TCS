package iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yugo
 */
public class Persistencia {
     
    public Persistencia() { 
    }
    
    public Iterator<Professor> load(String path) throws IOException{ 
        List<Professor> objetos;
       
        objetos = new ArrayList<>();
        
        String url_1 = path + "\\Professores.csv"; 
        String url_2 = path + "\\DadosGerais.csv";
        
        Map<String,String> professores = readFromFile(url_1); 
        Map<String,String> dadosGerais = readFromFile(url_2); 
        
        for (Map.Entry<String, String> i : professores.entrySet()) {
            String values[] = i.getValue().split(";"); 
            Professor p = new Professor();
            p.setId(Integer.parseInt(values[0]));
            p.setNome(values[1]);
            
            //dadosGerais
            if ( dadosGerais.containsKey(i.getKey()) ) {
                String dados = dadosGerais.get( i.getKey() ); 
                String[] dg = dados.split(";");
                p.setDep(dg[1]);
                p.setTitulacao(dg[2]);
                p.setTipo(dg[3]);  
            }
            objetos.add(p);            
        }
        return objetos.iterator(); 
    }    
    
    private Map<String,String> readFromFile(String url) throws IOException {
        Map<String,String> linhas = new HashMap<>();
        FileReader file = new FileReader(url);
        BufferedReader br = new BufferedReader(file);
        String st;
        while ((st = br.readLine()) != null){
            linhas.put(st.split(";")[0], st);
        }
        return linhas; 
    }
}
