//Este proyecto muestra la gráfica de la interfaz para la pantalla del medidor inteligente. 
//No realiza ningún proceso. Sólo muestra la ventanas ventanas, sin protocolos ni procesos adicionales.

package guidisplaysm;
import Vista.MainFrame;
import java.awt.Color;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class GUIDisplaySM {

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
        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("GTK+".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
    }
    
}
