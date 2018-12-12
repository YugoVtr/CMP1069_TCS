package strategy;
import java.util.Iterator;
import java.util.Comparator;

/**
 *
 * @author Yugo
 */
public interface SortAlgorithm {
    Iterator sort(Iterator t, Comparator c);
}
