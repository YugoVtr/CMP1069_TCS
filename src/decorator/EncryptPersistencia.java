package decorator;
import adapter.*;
import iterator.Professor;
import java.util.ArrayList;
import java.util.Iterator;
import factory_method.*;

/**
 * @author puc
 */
public class EncryptPersistencia implements Persistencia {
    Persistencia base; 
    
    public EncryptPersistencia(Persistencia b) { 
        this.base = b; 
    }

    @Override
    public Iterator<Professor> selectAll() {
        Iterator e = this.base.selectAll();
        ArrayList conjunto = new ArrayList();
        for (Iterator conteudo = e; conteudo.hasNext() ; ) {
            Professor p = (Professor) conteudo.next();
            
            EncryptionAlgorithm encryp = EncryptionAlgorithmFactory.getEncryptionAlgorithm(
                    EncryptionAlgorithmFactory.EncryptionAlgorithms.SHA512
            );
            
            p.setTitulacao(encryp.encrypt(p.getTitulacao()));
            conjunto.add(p);
        }
        return conjunto.iterator() ; 
    }
}
