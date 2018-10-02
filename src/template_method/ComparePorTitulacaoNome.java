package template_method;

import java.util.Comparator;
import iterator.Professor; 

/**
 * @author Yugo
 */
public class ComparePorTitulacaoNome implements Comparator<Professor>{
    @Override
    public int compare(Professor o1, Professor o2) {
        int titulacao = o1.getTitulacao().compareTo(o2.getTitulacao());
        int nome = o1.getNome().compareTo(o2.getNome()); 
        
        if( titulacao == 0) {
            return nome;
        }
        return titulacao; 
    }
}
