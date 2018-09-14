package template_method;

import java.util.Comparator;
import iterator.Professor; 

/**
 * @author Yugo
 */
public class ComparePorId implements Comparator<Professor>{
    @Override
    public int compare(Professor o1, Professor o2) {
        if( o1.getId() == o2.getId() ) return 0 ;
        if( o1.getId() > o2.getId() ) return 1;
        return -1 ; 
    }
}
