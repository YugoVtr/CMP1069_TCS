package template_method;

import java.util.Comparator;
import iterator.Professor; 

/**
 * @author Yugo
 */
public class ComparePorDepTitulacaoNome implements Comparator<Professor>{
    @Override
    public int compare(Professor o1, Professor o2) {
        int departamento = o1.getDep().compareTo(o2.getDep());
        int titulacao = o1.getTitulacao().compareTo(o2.getTitulacao());
        int nome = o1.getNome().compareTo(o2.getNome()); 
        
        if ( departamento == 0 ) { 
            if( titulacao == 0) {
                return nome;
            }
            return titulacao; 
        }
        return departamento; 
    }
}
