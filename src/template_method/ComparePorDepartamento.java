package template_method;

import java.util.Comparator;
import iterator.Professor; 

/**
 * @author Yugo
 */
public class ComparePorDepartamento implements Comparator<Professor>{
    @Override
    public int compare(Professor o1, Professor o2) {
        return o1.getDep().compareTo(o2.getDep()); 
    }
}
