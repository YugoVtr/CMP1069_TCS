package adapter;

/**
 * @author Yugo
 */
import iterator.Professor;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class SQLiteJDBCDriverConnection {
     /*
     * Connect to a sample database
     */
    private Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:./src/adapter/tcs.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn; 
    }
    
    private Iterator toObject(ResultSet rs) throws SQLException { 
        ArrayList values = new ArrayList(); 
        while (rs.next()) {
            Professor p;
            try {
                p = new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("departamento"),
                        rs.getString("titulacao"), 
                        rs.getString("tipo")
                );
                values.add(p); 
            } catch (Exception ex) {
                System.out.println("ERRO"); 
            }
        }
        return values.iterator();
    }
    
    /**
     * select all rows in the professor table
     * @param classe
     * @return 
     */
    public Iterator listar(String classe) {
        String sql = "SELECT * FROM " + classe;
        Iterator res = null; 
        Connection conn = this.connect();
        ResultSet rs;             
        try {
            Statement stmt  = conn.createStatement();
            rs = stmt.executeQuery(sql);
            res =  toObject(rs);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteJDBCDriverConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return res; 
    }
}