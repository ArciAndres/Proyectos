/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsdc1;

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
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class HSDC1 {
    
    static I2CDevice device;
    final static Console console = new Console();
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    private static void initComponents() throws I2CFactory.UnsupportedBusNumberException, IOException {
        gpio = GpioFactory.getInstance();
        pinIRQ1  = gpio.provisionDigitalInputPin(RaspiPin.GPIO_29); // GPIO_29 -> Pin 40 in header
        pinPM1   = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "PM1", PinState.LOW); // GPIO_00 -> Pin 11 in header
        pinPM0   = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "PM0", PinState.HIGH); // GPIO_02 -> Pin 13 in header
        pinReset = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Reset", PinState.HIGH); //GPIO_03 -> Pin 15 in header
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

    