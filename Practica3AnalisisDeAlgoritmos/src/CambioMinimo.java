import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CambioMinimo{
    //Atributos de la clase. (Funcionan como variables globales)
    ArrayList<Integer> denominacion = new ArrayList();    
    ArrayList<Billetes> billetesDados = new ArrayList();
    Scanner scan = new Scanner(System.in); 
    
    //1. CONJUNTO DE CANDIDATOS, QUE CORRESPONDEN A LAS N ENTRADAS DEL PROBLEMA
    //Este método permite leer todas las entradas del problema y alamacenarlas
    //en una lista.
    ArrayList<Integer> rellenarListaDenominacion(){ 
        System.err.println("¿Cauntos billetes y monedas distintas hay?");        
        System.out.println("Por ejemplo: hay de 50, 100 y monedas de 10, por lo tanto son 3"
                + "\nOtro ejemplo: hay de 200, 500, 20, 50 y monedas de 2, por lo tanto hay 5"+
                "\nPuedes colocar las denominaciones en el orden que quieras, solo \nasegurate "
                + "de indicar correctamente cuantos billetes y monesdas distintos hay");
        System.out.print("Entonces, ¿Cauntos billetes y monedas distintas hay?: " );
        int valor = scan.nextInt();
        do{
            int lecturaDenominacion=0, lecturaCantidad=0;
            System.err.print("¿Cual es el valor de la denominacion?: ");
            lecturaDenominacion = scan.nextInt();
            denominacion.add(lecturaDenominacion);            
            System.err.print("¿Cual es la cantidad disponible de este billete o moneda?: "); 
            lecturaCantidad = scan.nextInt();
            billetesDados.add(new Billetes(lecturaDenominacion, 0, lecturaCantidad));
            valor--;                       
            System.out.println();
        }while(valor>0);   
        return denominacion;
    }
 
    //Sobreescribiendo el método sort de Collections para acomodar la lista de tipo Billetes
    //Esto lo hacemos porque dado que es una clase que tiene como atributos 2 datos primitivos
    //el método no puede acomodarlos por lo que lo sobreescribimos para que acomode de forma
    //descente tomando en cuanta solo lel atributo denominaciones de la lista.
    void ordenarBilletesDados(){
        Collections.sort(billetesDados, new Comparator<Billetes>() {
	@Override
	public int compare(Billetes b1, Billetes b2) {
		return -1*(new Integer(b1.denominaciones).compareTo(new Integer(b2.denominaciones)));
	}
        });
    }
    
    //Utilizando el método sort de Collections acomodamnos la lista de manera descendente,es decir,
    //ordenar un arreglo de mayor a menor. 
    ArrayList<Integer> ordenarDescendentemente(){        
        //Este método se basa en el algoritmo TimSort, lo que nos da una complejidad de O(n*log(n)).
        //TimSort hace uso de la ordenación por inserción y los algoritmos
        //Collections.sort(denominacion, Collections.reverseOrder());
        Collections.sort(denominacion, Collections.reverseOrder());
        return denominacion;
    }
    
    //2. UNA FUNCIÓN DE SELECCIÓN QUE EN CADA MOMENTO DETERMINE EL CANDIDATO IDÓNEO 
    //PARA FORMAR LA SOLUCIÓN DE ENTRE LOS QUE AÚN NO HAN SIDO SELECCIONADOS NI RECHAZADOS
    //3. FUNCIÓN QUE COMPRUEBA SI UN CIERTO SUBCONJUNTO DE CANDIDATOS ES PROMETEDOR    
    //Este método a partir de una lista que conteine el CONJUNTO DE CANDIDATOS determina
    //la posición en la que CIERTO SUBCONJUNTO DE CANDIDATOS ES PROMETEDOR, además, la 
    //posicion (el valor del retorno) representa EL CANDIDATO IDÓNEO
    public int candidatosPrometedores(double cantidadR){
        //Ordenamos de mayor a menor el arreglo       
        denominacion = ordenarDescendentemente();
        //Una vez ordenado de manera descendente el arreglo, determinamos los candidatos prometedores
        int inicio = 0, fin = denominacion.size(), posicion=fin;
        if(cantidadR >= denominacion.get(0)){
            return 0;
        }else{
            do{       
            //Si el rango de posibilidades ya solo se encuentran 2 denominaciones (2 valores)   
            if(fin-inicio <=1){
                //Si la cantidad recibida es mayor al primer valor, entonces, regresar
                //el valor primero
                if(cantidadR >= denominacion.get(posicion))
                    return posicion;
                //si la cantidad recibida es menor que el segundo valor, entonces
                //regresas el segundo valor
                else
                    return fin;
            }
            //Calculamos la mitad de la lista
            int mitad = (inicio + fin) / 2;            
            posicion = mitad;    
            
            //Si el rango de posibilidades ya solo se encuentran 2 denominaciones (el de la posicion 0 y la 1)  
            if(mitad <=1){
                //Si la cantidad recibida es mayor al primer valor, entonces, regresar
                //el valor primero
                if(cantidadR >= denominacion.get(mitad))
                    return mitad = 1;
                //si la cantidad recibida es menor que el segundo valor, entonces
                //regresas el segundo valor
                else
                    return fin;
            }            
            
            //si la el valor de en medio es igual a la cantidad recibida entonces regresar esa posicion
            if(denominacion.get(mitad) == cantidadR)
                return mitad;
            
            //SE DESCARTA EL  O LOS CANDIDATOS PARA SIEMPRE Y NO VOLVERÁ A CONSIDERARLO
            //Si la cantidad recibida es menor que el valor de en medio, entonces el nuevo inicio 
            //será a partir de esta mitad.
            else if(denominacion.get(mitad) > cantidadR){               
                inicio = mitad;
            }
            
            //SE DESCARTA EL O LOS CANDIDATOS PARA SIEMPRE Y NO VOLVERÁ A CONSIDERARLO
            //Si la cantidad recibida es mayor que el valor de en medio, entonces el nuevo fin 
            //será a partir de esta mitad.
            else if(denominacion.get(mitad) < cantidadR){
                fin = mitad;
            }
            //La condición del ciclo es que la cantidad recibida este dentro del rango de valores(SUBCONJUNTO DE CANDIDATOS)
            }while(cantidadR <= denominacion.get(inicio) && cantidadR >= denominacion.get(fin-1));        
        }        
        return posicion;//EL CANDIDATO IDÓNEO     
        //Las siguientes posiciones representan el SUBCONJUNTO DE CANDIDATOS PROMETEDOR 
        
    }
    
    //4. UNA FUNCIÓN OBJETIVO QUE DETERMINE EL VALOR DE LA SOLUCIÓN HALLADA.
    //5. UNA FUNCIÓN QUE COMPRUEBE SI UN SUBCONJUNTO DE ESTAS ENTRADAS ES SOLUCIÓN AL PROBLEMA, SEA ÓPTIMA O NO
    ArrayList<Billetes> darCambio(double cambio){
        //COMPROBAR SI EL CANDIDATO ES PROMETEDOR PARA AÑADIRLO EN LA SOLUCIÓN.
        //EL CANDIDATO IDÓNEO, las sig. posiciones de inicio representan el SUBCONJUNTO PROMETEDOR     
        int inicio = candidatosPrometedores(cambio);
        int posicion = 0;//La posicion en la que se esta agregando el ÓPTIMO LOCAL
        int agregarBillete = 1;//La cantidad de billetes
        ArrayList<Billetes> listaBilletesResultado = new ArrayList();
        ordenarBilletesDados();
        do{                                   
            //DETERMINA EL VALOR DE LA SOLUCIÓN HALLADA.
            //SE AGREGA EL CANDIDATO IDONEO A LA SOLUCIÓN           
            if(billetesDados.get(inicio).cantidadBilletesDisponibles > 0){
                cambio -= denominacion.get(inicio);            
                Billetes billetesResultado = new Billetes(denominacion.get(inicio),agregarBillete);
                listaBilletesResultado.add(posicion,billetesResultado);
                billetesDados.get(inicio).quitarBilletesDisponibles();
            }else{
                inicio++;
                agregarBillete=1;
            }

            //CADA VEZ QUE SE INCLUYE UN CANDIDATO COMPROBARÁ SI EL CONJUNTO OBTENIDO ES LA SOLUCIÓN 
            while(cambio >=  denominacion.get(inicio) && billetesDados.get(inicio).cantidadBilletesDisponibles > 0){
                listaBilletesResultado.get(posicion).sumaUnbillete();                 
                billetesDados.get(inicio).quitarBilletesDisponibles();
                cambio -= denominacion.get(inicio);
            }
            //DETERMINAR EL PROXIMO CANDIDATO IDÓNEO Y SUBCONJUNTO PROMETEDOR 
            inicio = candidatosPrometedores(cambio); 
            agregarBillete=1;
            posicion++;

        }while(cambio != 0);//COMPRUEBA SI UN SUBCONJUNTO DE ESTAS ENTRADAS ES SOLUCIÓN AL PROBLEMA

        return listaBilletesResultado;
    }
    
    //Este método simplemente me ayuda a tener menos lineas de código en la main, poniendo todo el proceso que 
    //se debe de realizar para obtener el cambio y lo unico que hace es imprimir el resultado. 
    void procesoImprimirCambio(){
        double cambio;        
        System.out.println("¿Cuál es la cantidad que quieres que se te cambie?");
        cambio = scan.nextDouble();
        ArrayList<Billetes> billetesResultadoLista = new ArrayList();
        denominacion = rellenarListaDenominacion();
        billetesResultadoLista = darCambio(cambio);
        System.out.println("El cambio para $"+cambio+" es: "+billetesResultadoLista.toString());
    }
    
    //Este método está sobrecargado y simplemente me ayuda a tener menos lineas de código en la main, 
    //poniendo todo el proceso que se debe de realizar para obtener el cambio y lo único que hace es
    //imprimir el resultado, pero con la diferencia que recibe un parametro el cual es la respuesta de 
    //si se quiere mantener la cantidad y denominaciones de billestes o se decide cambiarla
    void procesoImprimirCambio(boolean respuesta){
        double cambio;        
        System.out.println("¿Cuál es la cantidad que quieres que se te cambie?");
        cambio = scan.nextDouble();
        ArrayList<Billetes> billetesResultadoLista = new ArrayList();
        if(respuesta == false){
            denominacion.clear();
            billetesDados.clear();
            denominacion = rellenarListaDenominacion();
        }         
        billetesResultadoLista = darCambio(cambio);
        System.out.println("El cambio para $"+cambio+" es: "+billetesResultadoLista.toString());
    }
    
    public static void main(String[] args) {
        CambioMinimo cambio = new CambioMinimo();
        //Primer prueba propuesta (con $39)(LAS N ENTRADAS DEL PROBLEMA son: $20, $100, $2, $1, $50)
        cambio.procesoImprimirCambio();                
        boolean respuesta;
        System.out.println("\n¿Deseas saber el cambio de otro numero? (true o false)");
        respuesta = cambio.scan.nextBoolean(); 
        while(respuesta != false){//Este proceso se realiza hasta que el usuario decida ya no saber el cambio de otro numero
        //Segunda prueba propuesta (con $78)(LAS N ENTRADAS DEL PROBLEMA son: $20, $100, $2, $1, $50)
        //Tercer prueba propuesta (con $123)(LAS N ENTRADAS DEL PROBLEMA son: $20, $100, $2, $1, $50)           
        //Cuarta prueba propuesta (con $299)(LAS N ENTRADAS DEL PROBLEMA son: $20, $100, $2, $1, $50)        
        //Quinta prueba propuesta (con $53) (LAS N ENTRADAS DEL PROBLEMA son: $20, $50, $1, $2) 
        //Sexta prueba propuesta (con $60) (LAS N ENTRADAS DEL PROBLEMA son: $20, $50, $1, $2)
        System.out.println("¿Quieres mantener la cantidad y denominaciones de billestes?, "
                + "\nten en cuenta que ahora tienes menos monedas y billetes disponibles (true o false)");
        respuesta = cambio.scan.nextBoolean();
        cambio.procesoImprimirCambio(respuesta);
        System.out.println("\n¿Deseas saber el cambio de otro numero? (true o false)");
        respuesta = cambio.scan.nextBoolean(); 
        }
        
    }
    
}

