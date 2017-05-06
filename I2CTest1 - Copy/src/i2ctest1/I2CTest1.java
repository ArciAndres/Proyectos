/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i2ctest1;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigital;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.util.Console;
import java.io.IOException;
import javax.swing.text.html.HTML;
import com.pi4j.io.i2c.I2CDevice;
import ADE.*;
import com.sun.javafx.fxml.expression.BinaryExpression;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class I2CTest1 {
    
    public static final int TSL2561_ADDR = 0x39; // address pin not connected (FLOATING)
    static I2CDevice device;
    final static Console console = new Console();
    public static void main(String[] args) {

       // byte[] bytebuffer = new byte[]{(byte)0xE5,(byte)0x1F};
        //byte readBuffer[] = new byte[4];

        initComponents();
        int response;
        // print program title/header
        console.title("<-- SGM Udenar -->", "I2C Communication example");
        // allow for user to exit program using CTRL-C
        console.promptForExit();
        
        try {
            I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);
            device = i2c.getDevice(ADE7880.ADE7880_ADDR);
            //int cont = 0;
            
            while(pinIRQ1.isLow()){
                
                    console.println("Leido");
                    
                    //writeRegister(ADE7880.MASK0, new byte[]{(byte)cont,(byte)cont,(byte)cont,(byte)cont});
                    writeRegister(ADE7880.Gain, new byte[]{0,0,0,0});
                    writeRegister(ADE7880.COMPMODE, new byte[]{(byte)0x41,(byte)0xFF}); //Set SELFREQ
                    
                    //cont++;
                    byte[] readBuffer = readRegister(ADE7880.VNOM);
                    printHex(readBuffer);
                    if (cont >=127) {
                        cont = 0;
                    }
                    Thread.sleep(1000);
            }
            //gpio.shutdown(); //this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks
            //   console.println("Exiting ControlGpioExample");    
        } catch (Exception ex) {
            console.println(ex.toString());
        } 
        
    }
    
    public static byte[] readRegister(byte[][] register){
        byte readbuffer[] = new byte[register[1][1]];
        try {
            device.read(register[0], 0, 2, readbuffer, 0, register[1][1]);
        } catch (IOException ex) {
            Logger.getLogger(I2CTest1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readbuffer;          
    }    

    private static String writeRegister(byte[][] register, String strValue) {
        try {
            byte[] buffer = stringValidation(strValue);
            
            if (register[1][1] != buffer.length) {
                console.println("El número de bits indicado para la escritura es incorrecto");
                // return null;
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
                Logger.getLogger(I2CTest1.class.getName()).log(Level.SEVERE, null, ex);
                return ex.toString();
            } catch (Exception ex){
                console.println(ex.toString());
                return ex.toString();
            }
        } catch (SGMUdenarException ex) {
            console.println(ex.toString());
            return ex.toString();
        }
    }
    
    public static byte[] stringValidation(String strByte) throws SGMUdenarException{
        if (strByte.length()%2 != 0) {
            throw new SGMUdenarException("La cedena de entrada debe tener un número par de caracteres. Específicamente 8 para binario, aparte del identificador 0b.");
        }
        if (strByte.substring(0,2).equals("0x")) {
            byte[] buffer = new byte[strByte.length()/2-1];
            for (int i = 0; i < strByte.length()/2-1; i++) {
                buffer[i] = Byte.parseByte(strByte.substring(i, i+2),16);
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
    
    private static void printHex(byte[] readBuffer) {
        String hexNum = "0x";
        for (int i = 0; i < readBuffer.length; i++) {
            hexNum += String.format("%02x", readBuffer[i]);
        }
        console.println(hexNum);
    }
    
    private static void initComponents() {
        
        gpio = GpioFactory.getInstance();
        pinIRQ1  = gpio.provisionDigitalInputPin(RaspiPin.GPIO_29); // GPIO_29 -> Pin 40 in header
        pinPM1   = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "PM1", PinState.LOW); // GPIO_00 -> Pin 11 in header
        pinPM0   = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "PM0", PinState.HIGH); // GPIO_02 -> Pin 13 in header
        pinReset = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Reset", PinState.HIGH); //GPIO_03 -> Pin 15 in header
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
