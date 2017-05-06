package ade7880_gui1;

import static ade7880_gui1.Controller.device;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class WVController {
    
    static long[][]  hola;
    private JFreeChart chart;
    public static void graphDataChart(){
        
    }
    
    private static JFreeChart createLineChart(){
        Number[][] data = new Integer[][]
            {{new Integer(-3), new Integer(-2)},
             {new Integer(-1), new Integer(1)},
             {new Integer(2), new Integer(3)}};
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset("S","C", data);
        return ChartFactory.createLineChart("Line Chart", "Domain", "Range",dataset);
    }
    
    public static double[][] getNumValueSet(byte[][] byteValueSet, int selector){ //selector: 0=RSM ;
        double numValue[][] = new double[byteValueSet.length][];
        
        for (int j = 0; j < byteValueSet.length; j++) {
            for (int i = 0; i < byteValueSet[j].length; i++) {
                numValue[j][i] += Byte.toUnsignedLong(byteValueSet[j][byteValueSet[j].length - 1 - i]) << i * 8;
            }
        }
        return numValue;
    }
    
    public static byte[][] readRegisterSet(byte[][] register, int samples) throws IOException{
        byte readbuffer[][] = new byte[register[1][1]][samples];
            for (int i = 0; i < samples; i++) {
                device.read(register[0], 0, 2, readbuffer[i], 0, register[1][1]);
            }
            
        return readbuffer;          
    }
}
