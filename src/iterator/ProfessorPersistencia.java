package iterator;

import adapter.Persistencia;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yugo
 */
public class ProfessorPersistencia implements Persistencia {
     
    /**
     * Esta persistencia implementa o metodo CarregaEstrutura com 
     * diferentes estruturas de dados para demonstrar a flexibilidade
     * do padrao Iterator
     */
    public ProfessorPersistencia() { 
    }
    
    /**
     * @return Iterator
     * @throws IOException
     */
    public Iterator<Professor> carregaEstruturaComLista() throws IOException{ 
        ArrayList<Professor> objetos = new ArrayList<>();
        String s = File.separator; 
        String url_1 = "." + s + "src" + s + "iterator" + s + "Professores.csv"; 
        String url_2 = "." + s + "src" + s + "iterator" + s + "DadosGerais.csv";
        
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
    
    /**
     *
     * @return Iterator
     * @throws IOException
     */
    public Iterator<Professor> carregaEstruturaComFila() throws IOException{
        Queue<Professor> objetos = new ArrayDeque<>();
        
        String s = File.separator; 
        String url_1 = "." + s + "src" + s + "iterator" + s + "Professores.csv"; 
        String url_2 = "." + s + "src" + s + "iterator" + s + "DadosGerais.csv";
        
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
    
    /**
     *
     * @return Iterator
     * @throws IOException
     */
    public Iterator<Professor> carregaEstruturaComTreeMap() throws IOException{
        Map<Integer,Professor> objetos = new TreeMap<>();
        
        String s = File.separator; 
        String url_1 = "." + s + "src" + s + "iterator" + s + "Professores.csv"; 
        String url_2 = "." + s + "src" + s + "iterator" + s + "DadosGerais.csv";
        
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
    
    /**
     *
     * @return Iterator
     * @throws IOException
     */
    public Iterator<Professor> carregaEstruturaComHashSet() throws IOException{
        Set<Professor> objetos = new HashSet<>();
                 
        String s = File.separator; 
        String url_1 = "." + s + "src" + s + "iterator" + s + "Professores.csv"; 
        String url_2 = "." + s + "src" + s + "iterator" + s + "DadosGerais.csv";
        
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
    
    /**
     *  A chave (Key) do Map e o identificador é o conteudo (Value)
     *  e todo o conteudo do Objeto
     *  @return Map(String,String) 
    */
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

    /**
     * @return Iterator
     */
    @Override
    public Iterator selectAll() {
        Iterator res = null; 
        try { 
            res = carregaEstruturaComLista();
        } catch (IOException ex) {
            Logger.getLogger(ProfessorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res; 
    }
}
