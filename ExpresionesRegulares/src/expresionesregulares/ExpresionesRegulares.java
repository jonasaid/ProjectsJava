package expresionesregulares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.*; 
import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 

public class ExpresionesRegulares {
    /*static final String reservadas[]={"char", "FILE", "float", "int", "long",
            "short", "signed", "struct", "unsigned", "void"};*/
    /*"char, FILE, float, int, long, short, signed, struct, unsigned, void" */
        /* "[char]+|[FILE][float]|[int]|[long]|[short]|[signed]|[struct]|[unsigned]|[void]" */
        /* (_+a+b+c+d+…+z+A+B+C+D+…+Z)( _+a+b+c+d+…+z+A+B+C+D+…+Z+0+1+2+3+4+5+6+7+8+9)*
        (_|[a-zA-Z])
    
        (long|short|signed|unsigned)?(char|float|int)?|(bool|struct|FILE|void)?
    */

    public static boolean identificaFloats(String num){
        boolean valor= false;
        /*Explicación de la expresion regular:
        [+-]?: permite que un numero flotante sea positivo o negativo
        ([0-9])+: los caracteres aceptados pueden ser del 0 al 9, pero obligatoriamente
        tiene que aparecer al menos un caracter de estos, no se aceptarán cadenas como:
        .8, .55, .01, etc.
        ([.][0-9]+): tiene que contener el "." y estar concatenado a los caracteres 
        aceptados que pueden ser del 0 al 9 y al menos debe aparecer un numero despues 
        del punto
        ([+-]?([0-9]))*: puede o no aparecer un numero entero
        ([+-]?([0-9])+([.][0-9]+))+: al menos una vez tiene que aparecer un numero con punto decimal
        */
        /*Puede aparecer un numero entero antes o despues del numero decimal o flotante */
        Pattern pat = Pattern.compile(".*([+-]?([0-9]))*([+-]?([0-9])+([.][0-9]+))+([+-]?([0-9]))*.*");
        Matcher mat = pat.matcher(num);  
        if (mat.matches()) {
                valor = true;
        }
        return valor;
    }
    
    
    public static boolean identificaIdentificadores(String identificador){
        boolean valor= false;        
        /*
        Explicación de la expresion regular:
        (char|FILE|float|int|long|short|signed|struct|unsigned|void)+: puede ser cualquier tipo de dato,
        pero tiene que coincidir caracter por caracter y al menos debe de aparecer una vez.        
        (\\*){0,3}: indica que el caracter "*" puede no aparecer, o concatenarlo hasta 3 veces
        \\s:indica que se esta concatenando un " " 
        (_|[a-zA-Z]): me indica que puede ser una letra minuscula o mayuscula o el caracter
        "_", solo uno de cualquier caracter de estos
        \\w*: forma corta de escribir [a-zA-Z_0-9]*, es decir cualquier letra o digito tantas veces aparezcan
        (\\[[a-zA-Z0-9]+\\])?: esto quiere decir que acepte los caracteres "[", "]" y que dentro de ellos 
        acepte numeros o letras (porque tambien se puede poner una variable dentro)
        .*: cualquier cadena, aceptando cualquier caracter
        */
        Pattern pat = Pattern.compile(".*(char|FILE|float|int|long|short|signed|struct|unsigned|void)+(\\*){0,3}\\s(\\*){0,3}(_|[a-zA-Z])+\\w*(\\[[a-zA-Z0-9]+\\])?.*");
        Matcher mat = pat.matcher(identificador);  
        if (mat.matches()) {
                valor = true;
        }
        return valor;
    }
    
    public static void leerArchivos(String archivo)throws FileNotFoundException, IOException {
        String cadena; //variable que almacenará toda una linea de codigo
        FileReader f = new FileReader(archivo); //clase que nos permite manejar archivos
        BufferedReader b = new BufferedReader(f); //clase que nos permite manipular archivos
        int lineas=1;
        while((cadena = b.readLine())!=null) { //leer linea por linea hasta que se termine el archivo
                if(identificaIdentificadores(cadena)){ //imprime las lineaas donde se encuentra un identificador                   
                    System.out.println("En la linea "+lineas+" aparece un identificador: "+ cadena.trim()); 
                }
                if(identificaFloats(cadena)){ //imprime las lineas donde se ecuentran flotantes                    
                    System.out.println("En la linea "+lineas+" aparece un float: "+ cadena.trim()); 
                }
                lineas++;
        } 
        b.close(); //cieera el archivo
    }
    
    public static boolean identificaComentarios(String num){
        boolean valor= false;
        /*Explicación de la expresion regular:
        [ab]*:cualquier cadena que contenga alguna "a" y/o alguna "b" en cualquier 
        orden y cuantas sean o nada
        /#:forzosamente tienen que aparecer estos simbolos
        [[ab]*[^/#][ab]*]*: lo siguiente puede ser cualquier cadena que contenga 
        alguna "a" y/o alguna "b" en cualquier orden y cuantas sean o nada, 
        exceptuando la cadena "/#"
        #/: forzosamente tiene que aparecer esta cadena
        */
        Pattern pat = Pattern.compile("[ab]*/#[[ab]*[^/#][ab]*]*#/[ab]*");
        Matcher mat = pat.matcher(num);  
        if (mat.matches()) {
                valor = true;
        }
        return valor;
    }
    
    public static void main(String[] args) throws IOException {
        
        /*Pruebas de la primer fuunción*/
        /*
        System.out.println(identificaFloats("0.8"));
        System.out.println(identificaFloats("-7.8"));
        System.out.println(identificaFloats(".8"));
        System.out.println(identificaFloats("9."));
        System.out.println(identificaFloats("9.1-2.1"));
        System.out.println(identificaFloats("9.1+2.1"));
        System.out.println(identificaFloats("9+2.1"));
        System.out.println(identificaFloats("3.7-5"));
        System.out.println(identificaFloats("5+3.7-5"));
        System.out.println(identificaFloats("5.1+3.7-5"));
        */
        
        /*Pruebas de la segunda función*/
        /*
        System.out.println(identificaIdentificadores("float *_2"));
        System.out.println(identificaIdentificadores("float _2[3] = {1.1,2.2,3.3}"));
        System.out.println(identificaIdentificadores("FILE "));
        System.out.println(identificaIdentificadores("int 2daRespuesta"));
        System.out.println(identificaIdentificadores("float numero1"));
        System.out.println(identificaIdentificadores("bool ___"));
        System.out.println(identificaIdentificadores("FILE archivo"));        
        System.out.println(identificaIdentificadores("signed FILE archivo"));
        System.out.println(identificaIdentificadores("char*** arregloDECadenas"));
        System.out.println(identificaIdentificadores("char**** arregloDECadenas"));
        System.out.println(identificaIdentificadores("longdouble numerote"));          
        System.out.println(identificaIdentificadores("long double numerote"));                 
        System.out.println(identificaIdentificadores("unsigned long int numerote"));
        */
        
        /*Prueba de la tercer función */
        leerArchivos("C:\\Users\\jona-\\Documents\\Jona\\ESCOM\\semestre 4\\Teoría de la computación\\P1\\manejo_de_cadenas.txt");
       
        
        /*Prueba de la cuarta función */
        /*
        System.out.println(identificaComentarios("ababa/#abababa#/"));
        System.out.println(identificaComentarios("/#aaabbb#/ab"));
        System.out.println(identificaComentarios("/##/"));         
        System.out.println(identificaComentarios("/##/#/"));     
        System.out.println(identificaComentarios("/#ababa#/#/"));             
        System.out.println(identificaComentarios("/#ababa#/abababa#/"));
        */
    }

}
