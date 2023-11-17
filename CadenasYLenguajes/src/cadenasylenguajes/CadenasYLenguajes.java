/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenasylenguajes;

import java.util.ArrayList;

/**
 *
 * @author jona-
 */
public class CadenasYLenguajes {
    
    public static void prefijo(String s) {
        ArrayList<String> prefi = new ArrayList<>();

        for(int i=1; i<=s.length();i++){
            prefi.add(s.substring(0, i));
        }

        for(int i=0; i<prefi.size();i++){
            System.out.println(prefi.get(i));
        }
    }

    public int verificarIdentificador (String identificador){
        int verificar = 1;
        if(Character.isDigit(identificador.charAt(0))){
            verificar = 0;
        }else{
            for(int i=0; i<identificador.length(); i++){
                if (Character.isLetterOrDigit(identificador.charAt(i)) || identificador.charAt(i) == '_') {
                    verificar = 0;
                    break;
                }
            }                       
        }
        return verificar;
    }
        
    public static void main(String[] args) {
        CadenasYLenguajes ver = new CadenasYLenguajes();
        System.out.println(ver.verificarIdentificador("_hey"));
    }

    
}
