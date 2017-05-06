/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ade7880_gui1;

import ADE.ADE7880;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class Controller {
    static I2CDevice device;
    static TabContainer tabContainer;
    static JTextArea console;

    ScheduledExecutorService executor;
    
    public static void main(String[] args) throws I2CFactory.UnsupportedBusNumberException, IOException, InterruptedException {
        tabContainer = new TabContainer();
        tabContainer.setVisible(true);
        initComponents();
        
        //Initialization // suggested in ADE7880 Datasheet (Energy meter - quick start)
        printtf("Registro Gain: " + getStrHex(readRegister(ADE7880.Gain)));
        writeRegister(ADE7880.COMPMODE, "0x41FF"); //Set SELFREQ
        printtf("Registro Compmode (SELFREQ): " + getStrHex(readRegister(ADE7880.COMPMODE)));

        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xFE} , {8 , 1 , 0} }, "0xAD"); //
        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xE2} , {8 , 1 , 0} }, "0x14"); //
        Thread.sleep(1);
        //writeRegister(new byte[][]{ {(byte)0xE9,(byte)0x0C} , {16 , 2 , 0} }, "0x03BD"); //
        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xFE} , {8 , 1 , 0} }, "0xAD"); //
        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xE2} , {8 , 1 , 0} }, "0x04"); //
        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xE2} , {8 , 1 , 0} }, "0x04"); //

        writeRegister(ADE7880.RUN, "0x0001"); //
        
        printtf("Registro RUN (RAM Registers): " + getStrHex(readRegister(ADE7880.RUN)));
    }
    
    public void startReading(String entrada, int medidasPromedio, int periodo, String sistemaNum, boolean registroManual, String registro) {
        
        printtf("<-- SGM Udenar - Lectura de Medidas -->");

//        printtf("Registro Gain: " + getStrHex(readRegister(ADE7880.Gain)));
//        writeRegister(ADE7880.COMPMODE, "0x41FF"); //Set SELFREQ
//        printtf("Registro Compmode (SELFREQ): " + getStrHex(readRegister(ADE7880.COMPMODE)));
//
//        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xFE} , {8 , 1 , 0} }, "0xAD"); //
//        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xFE} , {8 , 1 , 0} }, "0xAD"); //
//        //writeRegister(new byte[][]{ {(byte)0xE9,(byte)0x0C} , {16 , 2 , 0} }, "0x03BD"); //
//        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xE3} , {8 , 1 , 0} }, "0x80"); //
//        writeRegister(new byte[][]{ {(byte)0xE7,(byte)0xE3} , {8 , 1 , 0} }, "0x80"); //
//
//        writeRegister(ADE7880.RUN, "0x0001"); //
//        writeRegister(ADE7880.RUN, "0x0001"); //
//        printtf("Registro RUN (RAM Registers): " + getStrHex(readRegister(ADE7880.RUN)));
        
        Runnable scriptRunnable = new Runnable() {    
            ArrayList<byte[][]> registros = getRegisters(entrada);
            JTable table = tabContainer.getTable_values();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            JScrollPane scroll = tabContainer.getScrollTable();
            public void run() {
                
                String[] medidas = getMedidas(registros);
                model.addRow(medidas);
                scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
                //table.setRowSelectionInterval(model.getRowCount(), 0);
//                model.fireTableDataChanged();

            }

            public String[] getMedidas(ArrayList<byte[][]> registros) {
                
                String[] valoresCadena = new String[registros.size()];
                switch(sistemaNum){
                   case "hex": 
                        for (int i = 0; i < registros.size(); i++) {
                            valoresCadena[i] = getStrHex(readRegister(registros.get(i)));
                        }
                        return valoresCadena;
                   case "dec": 
                        for (int i = 0; i < registros.size(); i++) {
                            valoresCadena[i] = NumberFormat.getIntegerInstance().format(getMeanRegisterValue(registros.get(i),medidasPromedio));
                        }
                   case "bin": 
                        for (int i = 0; i < registros.size(); i++) {
                            valoresCadena[i] = NumberFormat.getIntegerInstance().format(getMeanRegisterValue(registros.get(i),medidasPromedio));
                        }
                        return valoresCadena;       
                }
                return valoresCadena;
            }
        };
         
         executor = Executors.newScheduledThreadPool(1);
         executor.scheduleAtFixedRate(scriptRunnable, 0, periodo, TimeUnit.SECONDS);
         
    }
 
    public void stopInfiniteLoop() {
        printtf("Entró al stopInfiniteLoop");
        executor.shutdown();
    } 
    
    private static long getMeanRegisterValue(byte[][] register, int i) {
        long numValue = 0;
        for (int j = 0; j < i; j++) {
            numValue += getNumValue(readRegister(register),0);
        }
        return numValue/i;        
    }
    
    static void printtf(String text){
        String newline = "\n";
        String newlinestart = ">> ";
        console.setText(console.getText() + newlinestart + text + newline);
    }
    public static byte[] readRegister(byte[][] register){
        byte readbuffer[] = new byte[register[1][1]];
        try {
            device.read(register[0], 0, 2, readbuffer, 0, register[1][1]);
        } catch (IOException ex) {
            printtf(ex.toString());
        }
        return readbuffer;          
    }
    private static String writeRegister(byte[][] register, String strValue) {
        try {
            byte[] buffer = stringValidation(strValue);
            
            if (register[1][1] != buffer.length) {
                console.setText("El número de bits indicado para la escritura es incorrecto");
                return "El número de bits indicado para la escritura es incorrecto";
            }
            try {
                byte[] writeBuffer = new byte[register[1][1]+2];
                writeBuffer[0] = register[0][0];
                writeBuffer[1] = register[0][1];
                for (int i = 0; i < register[1][1]; i++) {
                    writeBuffer[i+2] = buffer[i];
                }
                //writeBuffer[6] = buffer[0];
                device.write(writeBuffer);
                //device.write();
                //return readRegister(register);
                return "ok";
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                return ex.toString();
            } catch (Exception ex){
                console.setText(ex.toString());
                return ex.toString();
            }
        } catch (SGMUdenarException ex) {
            console.setText(ex.toString());
            return ex.toString();
        }
    }
    public static byte[] stringValidation(String strByte) throws SGMUdenarException{
        if (strByte.length()%2 != 0) {
            throw new SGMUdenarException("La cedena de entrada debe tener un numero par de caracteres. Especificamente 8 para binario, aparte del identificador '0b'.");
        }
        if (strByte.substring(0,2).equals("0x")) {
            byte[] buffer = new byte[strByte.length()/2-1];
            for (int i = 0; i < strByte.length()/2-1; i++) {

                buffer[i] = (byte)Integer.parseInt(strByte.substring(2*i+2, 2*i+4),16);
            }
            return buffer;
        }
        else if (strByte.substring(0,2).equals("ob") && strByte.substring(2).length()%8 == 0){
            byte[] buffer = new byte[(strByte.length()-2)/8];
            for (int i = 2; i < (strByte.length()-2)/8; i++) {
                buffer[i] = Byte.parseByte(strByte.substring(i, i+8),2);
            }
            return buffer;
        }
        else{
            throw new SGMUdenarException("Error. Wrong format: String input must start with '0x'(hex) or 'ob'(binary)");
        }
    }
    private static String getStrHex(byte[] readBuffer) {
        String hexNum = "0x";
        for (int i = 0; i < readBuffer.length; i++) {
            hexNum += String.format("%02x", readBuffer[i]);
        }
        return hexNum;
     //   printtf(hexNum);
    }
    private static long getNumValue(byte[] byteValue, int selector){ //selector: 0=RSM ;
        long numValue = 0;
        
        for (int i = 0; i < byteValue.length; i++) {
            numValue += Byte.toUnsignedLong(byteValue[byteValue.length - 1 - i]) << i*8 ;
        }
        
        switch(selector){
            case 0:
                if (numValue > 5326737){
                    numValue = -(numValue - 5326737);
                    break;
                }
            default:
                break;
        }
        
        
        return numValue;
    }
    
    private ArrayList<byte[][]> getRegisters(String entrada) {
        switch(entrada){
            case "VRMS":
                ArrayList<byte[][]> registers = new ArrayList<>();
                registers.add(ADE7880.AVRMS);
                registers.add(ADE7880.BVRMS);
                registers.add(ADE7880.CVRMS);
                return registers;                
        }
        return null;
    }
        
    void speedTest(String registro, String tiempo) {
        
    }
    
    private static void initComponents() throws I2CFactory.UnsupportedBusNumberException, IOException {
        gpio = GpioFactory.getInstance();
        pinIRQ1  = gpio.provisionDigitalInputPin(RaspiPin.GPIO_29); // GPIO_29 -> Pin 40 in header
        pinPM1   = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "PM1", PinState.LOW); // GPIO_00 -> Pin 11 in header
        pinPM0   = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "PM0", PinState.HIGH); // GPIO_02 -> Pin 13 in header
        pinReset = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Reset", PinState.HIGH); //GPIO_03 -> Pin 15 in header
        
        console = tabContainer.getTa_console();
        I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);
        device = i2c.getDevice(ADE7880.ADE7880_ADDR);
    }
     
//   <editor-fold desc="pinDefinition">
    private static GpioController gpio;
    private static GpioPinDigitalInput pinIRQ1;
    private static GpioPinDigitalOutput pinPM0;
    private static GpioPinDigitalOutput pinPM1;
    private static GpioPinDigitalOutput pinReset;
 //   </editor-fold>





}


class SGMUdenarException extends Exception {
   public SGMUdenarException(String msg){
      super(msg);
   }
}