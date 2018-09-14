package template_method;

import java.util.Comparator;
import iterator.Professor; 

/**
 * @author Yugo
 */
public class ComparePorDepTitulacaoTipo implements Comparator<Professor>{
    @Override
    public int compare(Professor o1, Professor o2) {
        ComparePorDepartamento dep = new ComparePorDepartamento(); 
        int titulacao = o1.getTitulacao().compareTo(o2.getTitulacao()); 
        
        if( dep.compare(o1, o2) == 0) {
            if( titulacao == 0) {
                return o1.getTipo().compareTo(o2.getTipo()); 
            }
            return titulacao;
        }
        return dep.compare(o1, o2); 
    }
}
