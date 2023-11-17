import java.io.*;
import java.util.*;

/*Integrantes:
Gómez Marbán Jonathan Said
González Valdovinos Angélica Sofía
Gutierrez Moreno Aaron

La función "subcadenas", lo que 
hace esta es regresarnos los sufijos y prefijos de una determinada cadena haciendo uso de for
tanto para obtener los prefijos y sufijos como para imprimirlos, próximamente nos devolverá
todas las subcadenas ordenadas lexicográficamente. Se adjuntan capturas de pantalla de 
esta función.

La siguiente función se llama "verificarIdentificador" verifica que el primer carácter no sea un número (el primer if),
además, verifica que los siguientes caracteres sean validos (letras, exeptuando la 'ñ' y 'Ñ', o numeros o '_') en el else, 
en el siguinte if se verifica si es una palabra es reservada (lo verifica a través de una matriz que tiene contenida 
las palabras reservadas).
*/

/*
CAMBIOS QUE SE REALIZARON
Se cambio la función subcadenas, ya que faltaba mostrar todas las subcadenas en orden lexicográfico. 
También dentro de la función verificarIdentificador se agrego un procedimiento para reconocer si  la cadena que 
se esta pasando es una palabra reservada, para ello se creo un arreglo con las palabras reservadas de C  y una función 
aparte para que busque dentro de este arreglo si hay alguna coincidencia con la palabra que se quiere verificar si es un identificador. 
*/
public class CadenasYLenguajes {

    public static void subcadenas(String a) {

        ArrayList<String> sufijos = new ArrayList<String>();
        ArrayList<String> prefi = new ArrayList<>();
        ArrayList<String> subcadena = new ArrayList<>();
        String s;
        // Se obtienen los sufijos
        for (int i = 0; i < a.length(); i++) {
            s = a.substring(i, a.length());
            sufijos.add(s);
        }
        System.out.println("Sufijos: ");

        for (int c = 0; c < sufijos.size(); c++) {
            System.out.println(sufijos.get(c));
        }
        // Se obtienen los prefijos
        System.out.println("Prefijos: ");
        for (int n = 1; n <= a.length(); n++) {
            prefi.add(a.substring(0, n));
        }

        for (int r = 0; r < prefi.size(); r++) {
            System.out.println(prefi.get(r));
        }
        // Se generan todas las posibles subcadenas
        subcadena.add(" ");
        for (int f = 0; f <= a.length(); f++) {
            for (int j = f + 1; j <= a.length(); j++) {
                subcadena.add(a.substring(f, j));
            }
        }
        // Se ordenan lexicograficamente las subcadenas
        Collections.sort(subcadena.subList(1, subcadena.size()));

        System.out.println("\nSubcadenas: ");
        for (int t = 0; t < subcadena.size(); t++) {
            System.out.println(subcadena.get(t));
        }

    }

    // Palabras reservadas de C
    static final String reservadas[] = { "auto", "break", "case", "char", "const", "continue", "default", "do",
            "double", "else", "enum", "extern", "FILE", "float", "for", "goto", "if", "int", "long", "main", "register",
            "return", "short", "signed", "sizeof", "static", "struct", "typedef", "union", "unsigned", "void",
            "volatile", "while" };

    // Identifica si una cadena es palabra reservada
    public static boolean esPalabraReservada(String identificador) {
        boolean verificar = true;
        for (int i = 0; i < reservadas.length; i++) {
            if (Arrays.binarySearch(reservadas, identificador) >= 0) {
                verificar = false;
            }
        }
        return verificar;
    }

    // Identifica si hay un comentario en la cadena dada
    public static int esComentario(String lineaDeArchivo) {
        int verificar = 0;
        if (lineaDeArchivo.contains("/*")) {
            verificar = 1;
        } else if (lineaDeArchivo.contains("*/")) {
            verificar = 2;
        } else if (lineaDeArchivo.contains("//")) {
            verificar = 3;
        }
        return verificar;
    }

    // Identifica si hay una funcion en la cadena dada
    public static int esFuncion(String lineaDeArchivo) {
        int verificar = 0;
        if (lineaDeArchivo.contains("(") && lineaDeArchivo.contains(")")) {
            verificar = 1;
        }
        return verificar;
    }

    //Si encuentra que hat una funcion separa a partir de que encuentra el '('
    public static String separadorFuncion(String lineaDeArchivo) {
        int verificar = esFuncion(lineaDeArchivo);
        if(verificar == 1){
            String separador[] = lineaDeArchivo.split("(");
            lineaDeArchivo = separador[0];
        }
        return lineaDeArchivo;
    }


    // Identifica identificadores
    public static int verificarIdentificador(String identificador) {
        int verificar = 1;
        // Si tiene un numero al inciar
        if (Character.isDigit(identificador.charAt(0))) {
            verificar = 0;
        } else {
            for (int i = 0; i < identificador.length(); i++) {
                // Si tiene caracteres especiales que no esten permitidos
                if (!(Character.isLetterOrDigit(identificador.charAt(i)) || identificador.charAt(i) == '_')
                        || Character.toLowerCase(identificador.charAt(i)) == 'ñ') {
                    verificar = 0;
                    break;
                }
            }
        }
        // Si es una palabra reservada
        if (!esPalabraReservada(identificador)) {
            verificar = 0;
        }
        return verificar;
    }

    public static void leerArchivos(String direccion) {
        // Declarar una variable BufferedReader
        String texto = "";
        String identificador = "a";
        try {
            // Crear un objeto BufferedReader al que se le pasa
            // un objeto FileReader con el nombre del fichero
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            // Leer la primera línea, guardando en un String
            String temp = "";
            String bfRead;
            // Repetir mientras no se llegue al final del fichero
            int lineas = 0;
            while ((bfRead = bf.readLine()) != null) {
                System.out.println();
                lineas++;
                String separador[] = bfRead.split(";");
                bfRead = separador[0];
                StringTokenizer st = new StringTokenizer(bfRead);
                System.out.println("En la linea " + lineas + " esta(n) esto(s) identificador(es): ");
                // bucle por todas las palabras
                if (esComentario(bfRead) == 0) {
                    while (st.hasMoreTokens()) {

                        identificador = st.nextToken();
                        if (verificarIdentificador(identificador) == 1) {
                            System.out.println(identificador);
                        }
                    }

                } else {
                    if (esComentario(bfRead) == 1) {
                        if (bfRead.contains("*/")) {
                            separador = bfRead.split("/*");
                            bfRead = separador[0];
                            StringTokenizer st1 = new StringTokenizer(bfRead);
                            while (st1.hasMoreTokens()) {

                                identificador = st1.nextToken();
                                if (verificarIdentificador(identificador) == 1) {
                                    System.out.println(identificador);
                                }
                            }
                        } else {
                            do {
                                bfRead = bf.readLine();
                            } while (bfRead.contains("*/") == false);
                            bf.readLine();
                        }

                    } else if (esComentario(bfRead) == 3) {
                        separador = bfRead.split("//");
                        bfRead = separador[0];
                        StringTokenizer st1 = new StringTokenizer(bfRead);
                        while (st1.hasMoreTokens()) {

                            identificador = st1.nextToken();
                            if (verificarIdentificador(identificador) == 1) {
                                System.out.println(identificador);
                            }
                        }
                    }
                }
                // Leer la siguiente línea
                temp = temp + bfRead;
            }
        } catch (Exception e) {
            System.out.println("Error: Fichero no encontrado");
        }

  }

    
        
    public static void main(String[] args) {
        String a = "Turing";
        subcadenas(a);
        System.out.println(verificarIdentificador(a));
        System.out.println(verificarIdentificador("int"));
        //leerArchivos("C:\\Users\\jona-\\Documents\\Jona\\ESCOM\\semestre 2\\Estructura de datos\\manejo de cadenas\\manejo_de_cadenas.txt");
    }

}
