
package classes;

import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLSpeedTest {
    
    public static void main(String[] args) {
        SQLSpeedTest.testSQLSpeed(100, 100);
    }
          
    public static void testSQLSpeed(int numberRegisters, int iterations) {
        long[] results = new long[10000];
        
        SQLService sqlService = new SQLService();
        Date datenow2 = new Date();
        int id_meter = 1, phase = 1;

        long startTime, estimatedTime;
        sqlService.conectar();
        for (int j = 0; j < iterations; j++) {
            //System.out.println("Iteration " + j);
            startTime = System.currentTimeMillis();
            for (int i = 0; i < numberRegisters; i++) {
                datenow2 = new Date();
                sqlService.insertMeasurement(datenow2, id_meter, phase);
            }
            estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println(estimatedTime);
            results[j] = estimatedTime;
        }
        try {
            sqlService.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(SQLSpeedTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        System.out.println("Finished ");
        
         
    }

        

        

     
}
