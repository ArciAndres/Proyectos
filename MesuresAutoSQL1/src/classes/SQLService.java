/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class SQLService extends SQLQuery{
    public void conectar(){
        try {
        //this.conectar("localhost", "ecobikedb", "root", "1q2w3e4R");
          this.conectar("localhost", "sgmudenar", "root", "1q2w3e4R");
          } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLService.class.getName()).log(Level.SEVERE, null, ex);           
        }
    }
       
    
    public ResultSet checkID(String IDInput) {
        String[] ID = IDInput.split(",");
        if (ID.length != 2){
            return null;
        }
       
        try {
            this.statement = this.conn.prepareStatement("SELECT user.*, card.* FROM user, card WHERE card.code = ?  and card.idCard = user.idCard");
            this.statement.setString(1, ID[1].substring(0,8));
            this.datos = this.statement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.datos;
    }


    public void insertMeasurement(Date datenow, int id_meter, int phase) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
           // this.conectar("localhost", "sgmudenar", "root", "1q2w3e4R");
            this.statement = this.conn.prepareStatement("INSERT INTO measurement (time,id_meter,phase) VALUES (?,?,?)");
            this.statement.setString(1, dateFormat.format(datenow));
            this.statement.setString(2, String.valueOf(phase));
            this.statement.setString(3, String.valueOf(id_meter));
            this.statement.executeUpdate();
            
            
            //this.desconectar();
        }  catch (SQLException ex) {
            Logger.getLogger(SQLService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public void verTodos(){
        try {
          //  this.conectar("127.0.0.1", "ecobikedb", "veltriuk", "1q2w3e4R");
            this.conectar("localhost", "sgmudenar", "root", "1q2w3e4R");
            this.statement = this.conn.prepareStatement("SELECT * FROM quantity");
            this.datos = this.statement.executeQuery();
            while (this.datos.next()) {                
                System.out.println("id: "+this.datos.getInt("id")+" nombre: "+this.datos.getString("name")+ " unidad: " + this.datos.getString("unit"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
