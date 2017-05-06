/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.*;

/**
 *
 * @author Cristian
 */
public class SQLQuery {
    protected Connection conn;
    protected PreparedStatement statement;
    protected ResultSet datos;
    
    public void conectar(String server, String DB, String user, String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+DB,user,password);
    }
    
    public void desconectar() throws SQLException{
        this.conn.close();
        this.statement.close();
    }
    
    public void desconectar(ResultSet rs) throws SQLException{
        this.desconectar();
        rs.close();
    }
    
}
