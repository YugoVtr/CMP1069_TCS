package iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Yugo
 */
public class Persistencia {
     
    public Persistencia() { 
    }
    
    public Iterator<Professor> carregaEstruturaComLista(String path) throws IOException{ 
        List<Professor> objetos;
       
        objetos = new ArrayList<>();
        
        String url_1 = path + File.separator + "Professores.csv"; 
        String url_2 = path + File.separator + "DadosGerais.csv";
        
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
    
    public Iterator<Professor> carregaEstruturaComFila(String path) throws IOException{
        Queue<Professor> objetos = new ArrayDeque<>();
        
        String url_1 = path + File.separator + "Professores.csv"; 
        String url_2 = path + File.separator + "DadosGerais.csv";
        
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
    
    public Iterator<Professor> carregaEstruturaComTreeMap(String path) throws IOException{
        Map<Integer,Professor> objetos = new TreeMap<>();
        
        String url_1 = path + File.separator + "Professores.csv"; 
        String url_2 = path + File.separator + "DadosGerais.csv";
        
        Map<String,String> professores = readFromFile(url_1); 
        Map<String,String> dadosGerais = readFromFile(url_2); 
        int indice = 1;
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
            objetos.put(indice, p);
            indice++;
        }
        
        Collection a  = objetos.values();
        return a.iterator(); 
    }
    
    public Iterator<Professor> carregaEstruturaComHashSet(String path) throws IOException{
        Set<Professor> objetos = new HashSet<>();
        
        String url_1 = path + File.separator + "Professores.csv"; 
        String url_2 = path + File.separator + "DadosGerais.csv";
        
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
