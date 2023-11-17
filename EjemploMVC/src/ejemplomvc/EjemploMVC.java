/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplomvc;

/**
 *
 * @author marod
 */

//GUI
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


//MVC
import mvc1.Controlador;
import mvc1.Modelo;
import mvc1.Vista;


public class EjemploMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           }
           catch (UnsupportedLookAndFeelException e) {
           }
           catch (ClassNotFoundException e) {
           }
           catch (InstantiationException e) {
           }
           catch (IllegalAccessException e) {
           }
        
           Modelo modelo = new Modelo();
           Vista vista = new Vista();
           Controlador controlador = new Controlador(modelo, vista);
           controlador.iniciarVista();
      }
}
    
