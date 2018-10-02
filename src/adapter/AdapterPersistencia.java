package adapter;

import java.util.Iterator;

/**
 * @author Yugo
 */
public class AdapterPersistencia implements Persistencia{
    @Override
    public Iterator selectAll() {
        SQLiteJDBCDriverConnection select = new SQLiteJDBCDriverConnection();
        Iterator valor = null; 
        valor = select.listar("professor");
        return valor; 
    }    
}
