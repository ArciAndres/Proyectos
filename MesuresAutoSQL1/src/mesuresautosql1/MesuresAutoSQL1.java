
package mesuresautosql1;

import java.util.Date;
import java.io.Console;
import classes.SQLService;
import classes.SQLSpeedTest;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class MesuresAutoSQL1 {


    public static void main(String[] args) throws InterruptedException {
      
        SQLService sqlService = new SQLService();
        Date datenow2 = new Date();
        int id_meter = 1, phase = 1;
        
    //    SQLSpeedTest speedTest = new SQLSpeedTest();
    //    speedTest.testSQLSpeed(100, 10);
       
        Runnable scriptRunnable = new Runnable() {
            
            public void run() {
                sqlService.conectar();
                Date datenow = new Date();
                sqlService.insertMeasurement(datenow, id_meter, phase);
                
                System.out.println(ThreadLocalRandom.current().nextInt(5, 10));
                
                try {
                    sqlService.desconectar();
                } catch (SQLException ex) {
                    Logger.getLogger(MesuresAutoSQL1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };        
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(scriptRunnable, 0, 1, TimeUnit.SECONDS);
        
    }

}
