/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaswitch;

import java.util.Scanner;

/**
 *
 * @author jona-
 */
public class PruebaSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int day;
        String dayString;
        Scanner scan = new Scanner(System.in); 
        // instrucción switch con tipo de datos int
        switch (scan.nextInt()) 
        {
            case 1:  dayString = "Lunes";
                     
            case 2:  dayString = "Martes";
                     
            case 3:  dayString = "Miercoles";
                     break;
            case 4:  dayString = "Jueves";
                     break;
            case 5:  dayString = "Viernes";
                     break;
            case 6:  dayString = "Sabado";
                     break;
            case 7:  dayString = "Domingo";
                     break;
            default: dayString = "Dia inválido";
                     break;
        }
        System.out.println(dayString);
    }
    
}
