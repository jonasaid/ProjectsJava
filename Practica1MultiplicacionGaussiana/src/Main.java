/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */

public class Main {
    //Los atributos de la clase (se han creado para permitir hacer una especie de paso por referencia entre métodos)
    String x,y;
    int longitudMax;
    
    //Este método me permite saber cuántos ceros se deberan agregar a la izquiera del número
    //para hacer que su longitud sea potencia de 2. 
    //Recibe una cadena que representa el numero que procesaremos. Regresa un entero que representa cuantos ceros
    //se tienen que agregar
     public int faltanCeros(String numero){
        int ceros=0;
        if (numero.length() <= 2)
            return ceros;
        int i = 2;
        int longitud = numero.length();
        while(i < longitud){
            i *= 2;
        }
        ceros = i - longitud;
        return ceros;
    }          
    
    //Este método me permite agregar los ceros a la izquierda de un número para hacer que su 
    //longitud sea potencia de 2; este método dentro de sí tiene el metodo faltanCeros()
    //Recibe una cadena que representa el número con el que se trabajará
    //Regresa el numero con los 0´s necesarios agregados a la izquierda
    public String agregarCeros(String numero){
        String numeroCeros = "";
        int i,cerosAgregar = faltanCeros(numero);
        for(i = 0; i < cerosAgregar; i++){
            numeroCeros = numeroCeros + "0";
        }
        return numeroCeros + numero;
    }
     
    //Este método esté sobrecargado, me permite agregar los ceros que se indique como parámetro
    //a la izquierda del número
    //Recibe una cadena que representa el numero al que se agregaran los ceros y un enter que representa
    //cuantos 0´s se van a agregar a la izquierda
    //Regresa una cadena que es el numero con los ceros agregados
    public String agregarCeros(String numero, int ceros){
        String numeroCeros = "";
        int i;
        for(i = 0; i < ceros; i++){
            numeroCeros = numeroCeros + "0";
        }
        return numeroCeros + numero;
    } 
    
    //Este método se encarga que la longitud de ambos números sea potencia de  además,
    //me permite igualar la longitud de ambos números recibidos. dentro de su implementación
    //Está el método agregarCeros (haciendo uso de su sobrecarga).
    //Hay que notar como se modifica el atributo de la clase dentro de este método esto es porque
    //se requiere guardar los numeros a los que se le agregan ceros y se igualan las longitudes. 
    public void igualarLongitud(String x, String y,int longitudMax ,int base){                                        
        if(longitudMax == x.length()){            
            this.x = agregarCeros(x);
            this.longitudMax = this.x.length();
            this.y = agregarCeros(y, this.longitudMax - y.length());
        }else if(longitudMax == y.length()){
            this.y = agregarCeros(y);            
            this.longitudMax = this.y.length();
            this.x = agregarCeros(x, this.longitudMax - x.length());            
        }      
    } 
    
    //Este método permite segmentar un numero por la mitad, se conservara la parte que indique el segundo parametro (izquierda = i y derecha = d)
    //Recibe un numero que es que se dividira y otra cadena que representa el lado que se quiere conservar.Este método regresa la cadena dividida.
    public String dividir(String numero, String lado){
        int i, longitudM = numero.length()/2;
        StringBuffer valores = new StringBuffer();
        
        if("i".equals(lado.toLowerCase())){
            for(i=0; i < longitudM; i++){
                valores.insert(i, numero.charAt(i));
            }    
        }else if ("d".equals(lado.toLowerCase())){
            int t=0;
            for(i=longitudM; i < numero.length(); i++){ 
                valores.insert(t, numero.charAt(i));
                t++;
            }
        }else{
            return "ERROR";
        }
        String numeroDiv = String.valueOf(valores);     
        if(numeroDiv.equals("")){
            return "ERROR2";
        }
        return numeroDiv;        
    }
    
    //El método productoNormal regresa la multiplicación de dos cadenas (los cuales son números) recibidas.
    //Cabe mencionar que los números recibidos son de longitud 1 y en base diez. 
    public int productoNormal(String x, String y){
        int numeroX = Integer.parseInt(x);
        int numeroY = Integer.parseInt(y);
        
        return numeroX * numeroY;
    }
    
    //convertirABaseOriginal permite pasar un numero (que es una cadena) en cierta base, a la base indicada en los parametros
    //El método me regresa el numero (tambien de tipo cadena), pero en la base indicada
    //Cabe mencionar que la base del numero recibido para nuestro caso siempre será 10 y la base a la que se quiere 
    //pasar es a la base indicada en el método multplica.
    public String convertirABaseOriginal(String resultado, int base){
        long resultadoBase10 = Long.parseLong(resultado);
        String resultadoBaseN = Long.toString(resultadoBase10, base);
        return resultadoBaseN;
    }
    
    //El método multiplica recibe 4 parametros, los dos primeros son cadenas que representan los numeros que se quieren multiplicar,
    //también, recibe 2 enteros, el primero de ellos se refiere a la longitud más grande entre los dos numeros y el otro entero representa 
    //la base en la que se encuentran dichos numeros. Regresa el número multiplicado en base 10 (que después se convertira a su base 
    //original con convertirABaseOriginal).  
    public String multiplica(String x, String y, int n, int base){ 
        //En esta parte se declararon las variables donde se guardará el resultado, una de tipo entero y otro como cadena
        long resultado;
        String nuevoResultado;
        
        //En esta parte calculamos la longitud máxima de entre los dos numeros, después se le agregan ceros con 
        //el método que recibe el número y cuantos ceros se desean agregar, luego, lo que regrese ese método (el 
        //número modificado con los ceros agregados a la izquierda) se pone dentro del método agregar ceros (que agrega ceros
        //hasta que lo lleva a una longitud de potencia 2).        
        //No se usa el método igualarLongitud porque ese método modifica los valores de los atributos de la clase y eso haría que 
        //cada vez que entre al método se modificaran y por ende tambien las entradas del método multplica. 
        int longitudmax = Integer.max(x.length(), y.length());
        x = agregarCeros(agregarCeros(x,longitudmax - x.length() ));   
        y = agregarCeros(agregarCeros(y, longitudmax - y.length() ));
        n = x.length();
        
        //ESTE ES EL CASO BASE, uno de los pasos de la estrategia divide y vencerás 
        if(x.length()==1 && y.length()==1){
            int productoNormalDec = productoNormal(String.valueOf(Integer.parseInt(x, base)),String.valueOf(Integer.parseInt(y, base)));
            String productoNormal = String.valueOf(productoNormalDec);
            return productoNormal; 
                    
        }else{
            //ESTA ES LA DIVISIÓN, otro de los pasos de la estrategia divide y vencerás 
            String xi = dividir(x,"i");
            String xd = dividir(x,"d");
            String yi = dividir(y,"i");
            String yd = dividir(y,"d");
            
            //ESTA ES LA RECURSIVIDAD, otro de los pasos de la estrategia divide y vencerás 
            //Aquí también podemos ver la aplicación de la multiplicación Gaussiana que se explicará en el reporte.
            String producto1 = multiplica(String.valueOf(Integer.parseInt(xi,base)), String.valueOf(Integer.parseInt(yi, base)), n/2, 10);             
            String producto2 = multiplica(String.valueOf(Integer.parseInt(xi,base) + Integer.parseInt(xd,base)), String.valueOf(Integer.parseInt(yi,base) + Integer.parseInt(yd,base)), n/2, 10);            
            String producto3 = multiplica(String.valueOf(Integer.parseInt(xd, base)), String.valueOf(Integer.parseInt(yd, base)), n/2, 10); 

            //Pasamos los valores de producto 1, 2 y 3 para poder hace operaciones aritméticas      
            int p1 = Integer.parseInt(producto1,10);
            int p2 = Integer.parseInt(producto2,10);
            int p3 = Integer.parseInt(producto3,10);

            //ESTA ES LA COMBINACIÓN de las soluciones (producto 1, 2 y 3), un paso opcional de divide y vencerás 
            resultado = (long)((Math.pow(base, n) * p1) + (Math.pow(base, n/2) * (p2 - p1 - p3)) + p3);
            nuevoResultado = String.valueOf(resultado);

            //Regresamos el resultado como una cadena y en base 10
            return nuevoResultado;        
        }
        
    }
    
    //hacerMultiplicacionGaussiana es simplemente un método que una vez obtenido el resultado del método multiplica lo convierte a la base original (recordemos que multiplica regresa el número
    //en base 10), esto lo hacemos primero igualando las longitudes de amboos numeros (con igualar longitud que modificará los atributos), luego los atributos de la clase los pasamos como
    //parámetros al método multiplica y la base en la que están, después, lo que regrese el método (el resultado de la multiplicacion de los numeros en base 10)lo pasamos a su base original 
    //con convertirABaseOriginal. Por ultimó imprimimos los resultados; 
    //hacerMultiplicacionGaussiana recibe los mismos parametros que multiplica (los numeros a multiplicar, la longitud del maximo de entre estos y la base) y no regresa nada.
    void hacerMultiplicacionGaussiana(String x, String y, int n, int base){
        igualarLongitud(x, y,  n, base);
        String resultadoBase10 = multiplica(this.x, this.y, this.longitudMax, base);
        String resultadoBaseN = convertirABaseOriginal(resultadoBase10,base);        
        if(base == 10){
            System.out.println("La multiplicación Gaussiana entre "+x+" y "+y+" en base "+base+" es igual a: "+resultadoBaseN); 
        }else{
            System.out.println("La multiplicación Gaussiana entre "+x+" y "+y+" en base "+base+" es igual a: "+resultadoBaseN +". Su resultado en base 10 es: "+ resultadoBase10);
        }
        
    }
    
    //Dentro del main ponemos todas las pruebas de escritorio proporcionadas por el profesor.   
    public static void main(String[] args) {
        Main main = new Main();
        main.hacerMultiplicacionGaussiana("1", "0", 1, 2);
        main.hacerMultiplicacionGaussiana("11010", "1010", 5, 2);
        main.hacerMultiplicacionGaussiana("10110101", "101", 8, 2);
        main.hacerMultiplicacionGaussiana("8", "9", 1, 10);
        main.hacerMultiplicacionGaussiana("12345", "34", 5, 10);
        main.hacerMultiplicacionGaussiana("1234567", "1234", 7, 10);
        main.hacerMultiplicacionGaussiana("A", "4", 1, 16);
        main.hacerMultiplicacionGaussiana("123AB", "D3", 5, 16);
        main.hacerMultiplicacionGaussiana("111222E", "12CD", 7, 16);
                
    }

    
    
}
