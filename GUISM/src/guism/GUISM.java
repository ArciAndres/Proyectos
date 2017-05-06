/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guism;

import Vista.MainFrame;
import java.awt.Color;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class GUISM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.dispose();
        mainFrame.getContentPane().setBackground(Color.white);
        mainFrame.setUndecorated(true);
        mainFrame.setVisible(true);
    }
    
}
