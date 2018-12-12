package strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


/**
 *
 * @author Yugo
 */
public class HeapSort implements SortAlgorithm {

    @Override
    public Iterator sort(Iterator t, Comparator c) {
        ArrayList a = toArrayList(t);
        return a.iterator();
    }
    private ArrayList toArrayList(Iterator i) {
        ArrayList arrList;
        arrList = new ArrayList();
        while (i.hasNext()) {
            arrList.add(i.next());
        }
        return arrList;
    }
}
