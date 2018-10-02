package decorator;
import adapter.*;
import iterator.Professor;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author puc
 */
public class UpperPersistencia implements Persistencia {
    Persistencia base; 
    
    public UpperPersistencia(Persistencia b) { 
        this.base = b; 
    }

    @Override
    public Iterator<Professor> selectAll() {
        Iterator e = this.base.selectAll();
        ArrayList conjunto = new ArrayList();
        for (Iterator conteudo = e; conteudo.hasNext() ; ) {
            Professor p = (Professor) conteudo.next();
            p.setNome(p.getNome().toUpperCase());
            p.setDep(p.getDep().toUpperCase());
            p.setTitulacao(p.getTitulacao().toUpperCase());
            p.setTipo(p.getTipo().toUpperCase());
            conjunto.add(p);
        }
        return conjunto.iterator() ; 
    }
}
