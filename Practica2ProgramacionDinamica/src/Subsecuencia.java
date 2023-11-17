
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Subsecuencia{
    //Se declaran los  atributos de la clase principal, las consideraremos las variables globales.
    public int columnas;
    public int renglones; 
    public String cadena1, cadena2;
        
    //Aquí se declara la constante, que sirve para indicar un cambio de color (a rojo) al imprimir en consola.
    public static final String ANSI_RED = "\u001B[31m";
    //Esta es otra constante que regresa al color normal de impresión (a negro).
    public static final String ANSI_RESET = "\u001B[0m";
            
    //Este es el constructor de la clase, este lo usaremos para asignar los valores de las cadenas y 
    //determinar cuantos renglones y columnas tendrá nuestra tabla o matriz. 
    Subsecuencia(String cadena1, String cadena2){        
        this.columnas = cadena1.length()+1;
        this.cadena1 = " "+cadena1;
        this.renglones = cadena2.length()+1;
        this.cadena2 = " "+cadena2;
    }    
    
    //Este es el método que me permite obtener el valor que tiene la martiz en la aposición i y j 
    //Se ha desarrollado una clase llamada InfoMatriz para tener toda la información necesaria de una celda
    //en un solo objeto y poder trabajarlo de mejor manera. La clase InfoMatriz se explica en su archivo. 
    int L(int i, int j, InfoMatriz matriz[][]){
        int valor = matriz[i][j].numero;
        return valor;
    }        
    
    //EN ESTE MÉTODO SE APLICA EL PASO 1 Y 3 DE PROGRAMACIÓN DINÁMICA
    //Este método me permite asignarle valores a la celda en la posicion i, j dependiendo de las condiciones
    //explicadas en la introducción del reporte. Este método utiliza el método L para poder obtener el valor de
    //la celda.
    InfoMatriz condiciones(int i, int j, String x, String y, InfoMatriz matriz[][]){
        matriz[i][j] = new InfoMatriz();   
        //PASO 1: SUCESIÓN DE DECISIONES Y QUE A SU VEZ CUMPLA CON EL PRINCIPIO DE ÓPTIMO.
        //PASO 3: CÁLCULO DEL VALOR DE LA SOLUCIÓN ÓPTIMA QUE SE GUARDA EN UNA TABLA.
        //Condición si i y j son iguales a 0. Se le asigna el valor 0 a la celda y no tendrá ninguna etiqueta. PASO 1
        if(i==0 || j==0){
            //PASO 3
            matriz[i][j].etiqueta = "        ";
            if(i==0 && j!=0){
                matriz[i][j].numero = 0;
            }else if(i!=0 && j==0){
                matriz[i][j].numero = 0;
            }      
        //Condición si i y j son distintos de 0. Cumplida esta condición se derivan 3 distintos casos. PASO 1  
        }else if(i!=0 && j!=0){
            //PASO 3
            int izq = L(i,j-1,matriz);//El valor que hay en la celda izquierda
            int sup = L(i-1,j,matriz);//El valor que hay en la celda superior
            //Caso 1: si el caracter de la primer cadena que se encuentra en la posicion j (iterador de columnas) 
            //es igual a el caracter de la segunda cadena que se encuentra en la posicion i (iterador de renglones)
           
            if (x.charAt(j) == y.charAt(i)){//PASO 1 
                //PASO 3
                matriz[i][j].numero = L(i-1,j-1,matriz)+1;
                matriz[i][j].etiqueta = "Diagonal";
            //Caso 2: si el caracter de la primer cadena que se encuentra en la posicion j    
            //es distinto a el caracter de la segunda cadena que se encuentra en la posicion i
            }else if(i!=0 && j!=0){
                //Otra condición del segundo caso es que los valores de la celda a la izquierda 
                //y la celda superior sean distintos. 
                if(x.charAt(j)!= y.charAt(i) && izq != sup){//PASO 1
                //Determinamos el valor maximo entre la celda de la izquierda y la superior
                int valor = Integer.max(izq, sup);
                //El valor que sea el maximo se le asigna en la celda sobre la que estamos.
                //Y agregar la etiqueta correspondiente, si izq es el maximo se asigna la etiqueta de esta, 
                //sino es el maximo se asigna la etiqueta de superior.
                    if(valor == izq){
                        //PASO 3
                        matriz[i][j].numero = izq;
                        matriz[i][j].etiqueta = "Izquierda";
                    }else{
                        //PASO 3
                        matriz[i][j].numero = sup;
                        matriz[i][j].etiqueta = "Superior";
                    }
            //Caso 3: si los valores de izq y sup son iguales, entonces asignar la etiqueta de sup y el valor del mismo.           
            }else{//PASO 1
                //PASO 3    
                matriz[i][j].numero = sup;
                matriz[i][j].etiqueta = "Superior";
            }
            }
                
        }            
      
        return matriz[i][j];
    }
        
    //Este método lo usaremos para almacenar las posiciones de i y j de las celdas que contengan la etiqueta "Diagonal".
    //Este método recibe y regresa una clase que he desarrollado llamada PosicionesIJ que me sirve para almacenar el par de valores
    //que son las "coordenadas" o posiciones ij de la celda. Recordando que una celda dentro de la tabla o matriz es de tipo InfoMatriz.
    PosicionesIJ[] diagonales(int i, int j, int iterador, PosicionesIJ[] diagonal){
        diagonal[iterador] = new PosicionesIJ(); 
        diagonal[iterador].posicionI = i;
        diagonal[iterador].posicionJ = j;
        return diagonal;
    }  
    
    //EN ESTE MÉTODO SE APLICA EL PASO 2 DE PROGRAMACIÓN DINÁMICA. 
    //En este método lo que se hace es crear la matriz que se necesita con los renglones y columnas necesarias. 
    //Además, llena de valores y etiquetas cada celda de la tabla. Lo hace iterando en cada renglon y cada columna.
    //Dentro de este método se utiliza el método condiciones que es la que permite asignar tanto el numero 
    //como la etiqueta a cada celda, aparte de que cuando se encuentre una celda que tenga una etiqueta diagonal
    //se alamacenarán su posicion ij, el ultimo elemento de la tabla es el que tendrá este vector que almacena las 
    //posiciones de las diagonales.
    InfoMatriz[][] inicializarMatriz(){ 
        //PASO 2. DEFINICIÓN RECURSIVA DE LA SOLUCIÓN O ITERATIVA UTILIZANDO LA PILA DE LLAMADAS.
        int i,j,m=0;                
        PosicionesIJ[] diagonal = new PosicionesIJ[renglones*columnas];//declaramos el tamaño del vector que almacena las diagonales
        diagonal[m] = new PosicionesIJ();
        InfoMatriz[][] matrizGenerada = new InfoMatriz[renglones][columnas];//declaramos el tamaño de la matriz
        InfoMatriz[][] matrizNueva = new InfoMatriz[renglones][columnas];
        //Iterando sobre cada renglon
        for(i=0; i<renglones; i++){
            //Iterando sobre cada columna
            for(j=0; j<columnas; j++){ 
                //Asignando el número y etiqueta de la celda
                matrizNueva[i][j] = condiciones(i,j, this.cadena1, this.cadena2, matrizGenerada); //PASO 2                  
                String etiqueta = matrizGenerada[i][j].etiqueta;  
                //Si la etiqueta es "Diagonal" entonces guardaremos su posición en ij
                if(etiqueta.equals("Diagonal")){                                        
                    diagonal= diagonales(i,j,m,diagonal);
                    m++;
                }
            }
        }
        matrizNueva[renglones-1][columnas-1].posicionesIJ = diagonal;//ultimo elmento de la tabla que almacenará el vector de diagonales
        return matrizNueva;     
    }

    //EN ESTE MÉTODO SE APLICA EL PASO 4 (no se invierte la cadena en este método, pero se construye la subsecuencia de longitud maxima).  
    //Este método permite, una vez construida la tabla, determinar cual son las celdas que formarán parte de la solución (solución óptima)
    //a través de ciertas operaciones, además, se modifica el atributo color del objeto InfoMatriz (a un color rojo) con la constante
    //declarada al inicio.
    //Cabe mencionar que este método recibe la matriz construida y el vector de diagonales (las posiciones ij de las diagonales), pero 
    //este vector solo contiene las diagonales que tengan el valor máximo dentro de la tabla.
    String etiquetasCondiones(InfoMatriz[][] matriz, PosicionesIJ ij){ 
        //PASO 4. CONSTRUCCIÓN DE LA SOLUCIÓN ÓPTIMA HACIENDO USO DE LA INFORMACIÓN CONTENIDA EN LA TABLA
        StringBuilder subsecueciaMax = new StringBuilder();
        int iterador=0;        
        do
        //Si la etiqueta de la celda es "Diagonal", entonces:
        if(matriz[ij.posicionI][ij.posicionJ].etiqueta.contains("Diagonal")){
            //Agregar el caracter de la primer cadena en la posicion j (iterador de columnas),
            //ya que, este caracter forma parte de la solución general óptima.
            subsecueciaMax.insert(iterador, cadena1.charAt(ij.posicionJ));//PASO 4
            iterador++;
            //Cambia el color de la celda a rojo.
            matriz[ij.posicionI][ij.posicionJ].color = ANSI_RED;
            //Se mueve hacia la celda que esta arriba y a la izquierda (la diagonal).
            ij.posicionI--;
            ij.posicionJ--; 
        //Si la etiqueta de la celda es "Superior", entonces:    
        }else if(matriz[ij.posicionI][ij.posicionJ].etiqueta.contains("Superior")){
            //Cambia el color de la celda a rojo.
            matriz[ij.posicionI][ij.posicionJ].color = ANSI_RED;
            //Se mueve hacia la celda que esta arriba (la superior).
            ij.posicionI--;    
        }else if(matriz[ij.posicionI][ij.posicionJ].etiqueta.contains("Izquierda")){
            //Cambia el color de la celda a rojo.
            matriz[ij.posicionI][ij.posicionJ].color = ANSI_RED;
            //Se mueve hacia la celda que esta arriba (la superior).
            ij.posicionJ--;
            
        //Esto se realizará hasta que se llegue a una celda que no tenga una etiqueta    
        }while(!matriz[ij.posicionI][ij.posicionJ].etiqueta.contains("        ")); 
        return String.valueOf(subsecueciaMax);
    }
    
    void construirCadenasMax(InfoMatriz[][] matrizFinal, PosicionesIJ[] diagonales) {
        //Quitar espacios de memoria sin ocupar, es decir, quitar valores de diagonales iguales a null
        List<PosicionesIJ> ListaDiagonalesSinNull= new ArrayList<>();
        for(int i=diagonales.length-1, j=0; i>=0; i--){
            if(diagonales[i] != null){
                ListaDiagonalesSinNull.add(diagonales[j]);
                j++;
            }
        }        
        PosicionesIJ[] diagonalesSinNull = new PosicionesIJ[ListaDiagonalesSinNull.size()-1];
        diagonalesSinNull = ListaDiagonalesSinNull.toArray(diagonalesSinNull);   
        PosicionesIJ ultimaDiagonal = diagonalesSinNull[diagonalesSinNull.length-1];
        
        
        //Determinar el valor maximo dentro de la matriz (cuantos caracteres tendrá la subsecuencia maxima)
        int numeroMaximo = matrizFinal[ultimaDiagonal.posicionI][ultimaDiagonal.posicionJ].numero;        
        
        //Filtrar diagonales, dejar solo las celdas que tengan la etiqueta "Diagonal" que contengan el valor maximo 
        PosicionesIJ[] nuevasDiagonales = new PosicionesIJ[diagonalesSinNull.length-1];
        nuevasDiagonales[0] = ultimaDiagonal;
        //Esta variable al finalizar el siguiente for indicará cuantas soluciones o caminos distintos existen
        int nuevasDiagonalesContador = 1; 
        //For que permite iterar sobre el vector de posiciones de diagonales (que no almacenan ningun null) e ir
        //guardando en un nuevo vector las diagonales que contengan el valor maximo de la tabla.
        for (int i = diagonalesSinNull.length - 2; i >0; i--) {
            PosicionesIJ diagonalActual = diagonalesSinNull[i];
            if (matrizFinal[diagonalActual.posicionI][diagonalActual.posicionJ].numero == numeroMaximo) {
                nuevasDiagonales[nuevasDiagonalesContador] = diagonalActual;                                
                nuevasDiagonalesContador++;
            }
        }

        //Construimos la subsecuencia maxima analizando las etiquetas, además, modificamos el color de las 
        //posiciones (i,j)que formen parte de la solución (una especie de camino de abajo hacia arriba). 
        //Aquí utilizamos el método etiquetasCondiones que permite determinar las celdas que formarán parte de la solución.
        String[] subsecuencias = new String[nuevasDiagonalesContador];
        for (int i = 0; i < nuevasDiagonales.length; i++) {
            if (nuevasDiagonales[i] == null) {
                break;
            }
            subsecuencias[i] = etiquetasCondiones(matrizFinal, nuevasDiagonales[i]);
        }

        //Imprimimos la matriz coloreando los distintos "caminos" de solución.        
        System.out.print("La matriz que se constuye a partir de las cadenas:"+cadena1+" y"+cadena2+" es de tamaño: "+renglones+"x"+columnas+" y es la siguiente:");
        for (int i = 0; i < renglones; i++) {
            //Imprimiendo renglones
            System.out.println();
            for (int j = 0; j < columnas; j++) {
                //Imprimiendo columnas
                System.out.print(matrizFinal[i][j].color + matrizFinal[i][j] + ANSI_RESET);
            }
        }
       
        //Como paso final, invertimos la cadena que resulte de las celdas que forman parte de la solución, es decir, la subsecuencia máxima. 
        StringBuilder[] subsecuenciasInvertidas = new StringBuilder[nuevasDiagonalesContador];
        for(int i=0; i<nuevasDiagonalesContador; i++){
            subsecuenciasInvertidas[i] = new StringBuilder(subsecuencias[i]);
            subsecuenciasInvertidas[i] = subsecuenciasInvertidas[i].reverse();                    
        }
        
        //Se imprime la subsecuencia máxima
        System.out.println();
        System.out.println("Se han encontrado "+nuevasDiagonalesContador+" camino(s) distinto(s), los cuales nos dieron los sig. resultados: \n"+Arrays.toString(subsecuenciasInvertidas));       
        
    }
    
    //Este método simplemente ayuda a reducir un poco lineas de código en la main, aquí colocamos los 2 métodos que dan solución a este problema
    void generarMatrizYSubsecuenciasResultado(Subsecuencia datos){
        //creamos e inicializamos la matriz, a partr de la primer y segunda cadena 
        InfoMatriz[][] matriz = datos.inicializarMatriz();
        //Imprimimos la matriz con las celdas que permiten formar la subsecuencia máxima en color rojo y el resto en negro.
        //Además, se imprime la subsecuencia máxima.
        datos.construirCadenasMax(matriz, matriz[datos.renglones-1][datos.columnas-1].posicionesIJ);
        System.out.println();
    }
       
    
    public static void main(String[] args) {
        //Primer prueba propuesta
        Subsecuencia datos = new Subsecuencia("1001","010100");
        datos.generarMatrizYSubsecuenciasResultado(datos);
        
        //Segunda prueba propuesta
        Subsecuencia datos1 = new Subsecuencia("abcdefghij","ecdgi");
        datos.generarMatrizYSubsecuenciasResultado(datos1);
        
        //Tercer prueba propuesta
        Subsecuencia datos2 = new Subsecuencia("11010110","010110");
        datos.generarMatrizYSubsecuenciasResultado(datos2);
        
        //Prueba examen
        Subsecuencia datos3 = new Subsecuencia("110101","110110");
        datos.generarMatrizYSubsecuenciasResultado(datos3);
                 
    }
    
}
