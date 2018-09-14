package template_method;

import java.util.Comparator;
import iterator.Professor; 

/**
 * @author Yugo
 */
public class ComparePorTitulacaoTipoDep implements Comparator<Professor>{
    @Override
    public int compare(Professor o1, Professor o2) {
        ComparePorDepartamento dep = new ComparePorDepartamento(); 
        int titulacao = o1.getTitulacao().compareTo(o2.getTitulacao()); 
        int tipo = o1.getTipo().compareTo(o2.getTipo()); 
        
        if( titulacao == 0) {
            if( tipo == 0) {
                return dep.compare(o1, o2); 
            }
            return tipo;
        }
        return titulacao; 
    }
}
