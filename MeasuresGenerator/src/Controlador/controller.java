/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.MeasureGenerator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class controller {
    
    MeasureGenerator measureGenerator;

    public controller(MeasureGenerator aThis) {
        measureGenerator = aThis;
    }
    
    public static boolean isAnyTrue(boolean[] array)
    {
        for(boolean b : array) if(b) return true;
        return false;
    }

    public void generateMeasures(double voltage, double current, double powerFactor, double frequency, double phaseValue, double period, int id_meter, double tolerance, Date dateStart, Date dateEnd, Object timeUnit, boolean[] phases) {
        double powerReal = voltage*current;
        double powerAparent = powerReal/powerFactor;
        double powerReactive = Math.sqrt(Math.pow(powerAparent,2) - Math.pow(powerReal,2));
        Meter meter = new Meter();
        meter.setId(id_meter);
        phaseValue = Math.acos(powerFactor)*180/Math.PI;
        double[] measureValues = new double[]{voltage,current,powerReal,powerReactive,powerAparent,phaseValue,powerFactor};
        
        
        
//        Runnable scriptRunnable = new Runnable() {    
//            int conta = 0;
//            int conta2 = 0;
//
//            public void run() {
//                    System.out.println("Entró a la función run");
//                    List<Measure> measures = new ArrayList<Measure>();
//                    try{
//                        for (int phase = 0; phase < phases.length; phase++) {
//                            if (phases[phase] == true) {
//                                Measurement measurement = new Measurement(meter, new Date(), phase);
////                          JTextField TextField_insertedMeasurements = InsertMeasure.insertMeasure.getTextField_insertedMeasurements();
//                                measurement.setTime(new Date());
//                                measurement = insertSingleMeasurement(measurement);
//                                for (int j = 1; j <= numMeasures; j++) {
//                                    Quantity quantity = new Quantity();
//                                    quantity.setId(j);
//                                    measures.add(new Measure(measurement, quantity, measureValues[j-1]*(1 + tolerance*(Math.random()*2-1)/100)));
//                                    conta++;
//                                    measureGenerator.gettf_insertedMeasures().setText(String.valueOf(conta));
//                                }
//                                conta2++;
//                                measureGenerator.gettf_insertedMeasurements().setText(String.valueOf(conta2));
//                                insertListMeasures(measures);
//                                System.out.println("Medidas de fase " + phase + " insertadas");
//                            }
//                        }
//                        if (!isAnyTrue(phases)) {
//                            System.out.println("Ninguna fase seleccionada. Revise la pestaña Measurement");
//                        }
//                    }
//                    catch(Exception ex){
//                        System.out.println("Hubo en error en la ejecución. Error: " + ex.toString());
//                    }
//            }
//        };
//        
//        executor = Executors.newScheduledThreadPool(1);
//        executor.scheduleAtFixedRate(scriptRunnable, 0, period, TimeUnit.SECONDS);
    }
    
    public void insertSingleMeasure(Measurement measurement, Measure measure)
    {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        measure.setMeasurement(measurement);
        session.save(measure);
        tx.commit();
        session.close();
        //JOptionPane.showMessageDialog(null, "Single Measure inserted correctly");
    }
    
        public Measurement insertSingleMeasurement(Measurement measurement)
    {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        int id = (int)session.save(measurement);
        tx.commit();
        measurement = (Measurement)session.get(Measurement.class, id);
        session.close();
        //JOptionPane.showMessageDialog(null, "Single Measurement inserted correctly");
        return measurement;
    }
    

}

