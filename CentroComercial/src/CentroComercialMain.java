
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */

public class CentroComercialMain {    
    //Practica 4, composición y agregación. Centro comercial, restaurante, tienda, estacionamiento.
    //6 Mayo 2021, Java 8 net beans 12.1, Jonathan Gómez Marbán y Rogelio Hernández Vázquez   
    @SuppressWarnings("empty-statement")

    public static void main(String[] args) {
        //Creamos nuestro objeto para leer las entradas, objeto Restaurante y objeto de la clase CentroComercialClase 
        //para poder mandar llamar a los metodos de sus clases.
        Scanner scan = new Scanner(System.in).useDelimiter("\n");//Se puede usar la función delimitador para segregar su entrada, es decir, nosotros indicamos el caracter con el que el objeto sabra asta donde leer
        Restaurante restaurant = new Restaurante("(no hay)","");
        CentroComercialClase CM1= new CentroComercialClase(restaurant);
        
        //Aquí es donde preguntamos si se desea crear un CC, sino se crea entonces simplemente finaliza el programa
        //En caso de que se quiera crear, entonces se hacen las preguntas necesarias para crearlo
        System.out.println("Deseas crear un centro comercial (true o false)");
        boolean respuesta = scan.nextBoolean();
        if(respuesta){//Evaluamos la respuesta
            //Preguntamos acerca de los valores de los atributos domicilio, nombre y superficie y los modficamos segun la respuesta
            //Se modifican los valores de los atributos de CM1
            System.out.println("Ingresa donde estara ubicada, el nombre de la plaza, cuanto mide la plaza en m^2:"); 
            CM1.setDomicilio(scan.next());
            CM1.setNombre(scan.next());
            CM1.setSuperficie(scan.nextDouble());

            //En esta parte es donde preguntamos si hay o no un restaurante, en caso de que haya pregunta datos sobre el mismo, 
            //en caso de que no, sigue con las preguntas para crear el CC
            System.out.println("Ahora, se requiere saber si hay un restaurante en el Centro comercial (true o false)");
            if(scan.nextBoolean()){//Se evalua la respuesta
                //Se pregunta acerca del nombre y numero de comensales del restaurante y se modifican los valores segun lo respondido
                //Se modifican los valores del objeto de la clase Restaurante
                System.out.println("Cual es el nombre del restaurante, horario de apertura y cierre (HH:MM a HH:MM),\nQue tipo de comida ofrecen (Postres, mexicana, pizza...) y cual es el numero de comensales en él");
                restaurant.setNombre(scan.next());
                restaurant.setHorario(scan.next());
                restaurant.setTipoComida(scan.next());
                restaurant.setnumComensales(scan.nextInt());
            }

            //Se pregunta acerca del estacionamiento del CC
            //Se modifican los valores del atributo estac del objeto CM1 (Numero de carros y superficie)
            System.out.println("¿Cuantos carros hay en el estacionamiento, cuanto mide el estacionamiento, cual es su horario (HH:MM a HH:MM) y por cuantos minutos el fraccionamiento es libre?: ");   
            CM1.getEstac().setNumCarros(scan.nextInt());
            CM1.getEstac().setSuperficie(scan.nextDouble());
            CM1.getEstac().setHorario(scan.next());
            CM1.getEstac().setMinutos(scan.nextInt());
            
            //Se pregunta acerca de la tienda del CC
            //Se modifican los valores del atributo tienda del objeto CM1 (Nombre y Giro de la tienda)
            System.out.println("¿Cual es el nombre que tiene la tienda, el giro que tiene, su horario y el cupo maximo de clientes por tema de pandemia?: ");
            CM1.getTienda().setNomTienda(scan.next());
            CM1.getTienda().setProducto(scan.next());
            CM1.getTienda().setHorario(scan.next());
            CM1.getTienda().setCupoMaximo(scan.nextInt());
            //Se imprimen todods los valores obtenidos para el CC (Ceentro comercial) y para el restaurante a traves de sus metodos de impresion     
            CM1.imprimirCM();
            restaurant.imprimirRestaurante();
        }
        
        
        int casos;
        if(respuesta){//Si la respuesta para crear el CC al principio del programa es igual a true, entonces desplegar el menu
            do{//El menu se estará desplegando hasta que se cumpla la condicion de paro
            
            //Mostramos cuales son las opciones
            System.out.println("\n¿Que es lo que quieres hacer?");
            System.out.println("1. Agregar carros al estacionamiento");
            System.out.println("2. Agregar comensales al restaurante");
            System.out.println("3. Crear restaurante (en caso de no haber creado alguno)\n4. Mostrar los datos del centro comercial");
            System.out.println("5. Mostrar los datos del restaurante\n6. Eliminar Centro Comercial\n7. Salir");
            casos=scan.nextInt();//leemos la respuesta (la opcion elegida del menu) 

            switch(casos){  
                //Se agregan carros al estacionamiento.
                case 1: 
                        if(CM1 != null){//Se valida que CM1 no sea nulo en sus valores de los atributos
                            System.out.println("¿Cuantos carros quieres agregar?");
                            //se utiliza el metodo ingresarCarro para aumentar el numero de carros segun el numero introducido
                            //Solo utilizando nuestro objeto CM1 obtenemos el atributo estac del mismo y luego aumentamos el numero de carros
                            CM1.getEstac().ingresarCarro(scan.nextInt());
                            //Imprimimos los cambios
                            CM1.imprimirCM();
                        }else{
                            System.out.println("No se puede realizar esta accion, has eliminado el centro comercial");
                        }
                        
                        break;

                //Se agregan comensales        
                case 2: 
                        //Hacemos la validación, sino hay restaurante entonces mandar un mensaje de error
                        if(restaurant.validarRestaurante(restaurant)){
                            System.out.println("No hay restaurante para agregar comensales");
                        }else{
                            //Si hay restaurante usaremos el objeto de Restaurante para usar el metodo agregarComensales
                            //Lo que reciba como parametro será lo que aumentará el numero de comensales
                            System.out.println("¿Cuantos comensales quieres agregar?");
                            restaurant.agregarComensal(scan.nextInt());
                            restaurant.imprimirRestaurante();
                        }
                        break;

                //Crear un restaurante        
                case 3:
                        //Validamos que no haya un restaurante en existencia, en caso de que no haya, entonces
                        //pedimos los valores requeridos para crealos y modificamos los valores de los atributos del objeto restaurant
                        //segun los datos dados
                        if(restaurant.validarRestaurante(restaurant)){
                            System.out.println("Cual es el nombre del restaurante, horario de apertura y cierre (HH:MM a HH:MM),\nQue tipo de comida ofrecen (Postres, mexicana, pizza...) y cual es el numero de comensales en él");
                            restaurant.setNombre(scan.next());
                            restaurant.setHorario(scan.next());
                            restaurant.setTipoComida(scan.next());
                            restaurant.setnumComensales(scan.nextInt());
                        }else{//Si ya existía un restaurante, entonces mandamos un mensaje de error
                            System.out.println("Ya hay un restaurante creado");
                        }    
                        break;
                
                //imprimimos Centro Comercial (CC), es decir, el objeto CM1        
                case 4:
                        //Validamos que CM1 no este vacío, en caso de ser así entonces mandamos un mensaje de error 
                        if(CM1 == null){
                            System.out.println("Ya no existe el centro comercial");
                        }else{//Imprimimos el Centro comercial con el metodo proporcionado por la clase CentroComercialclase
                            CM1.imprimirCM();
                        }
                        break;
                        
                case 5: 
                        //Imprimimos la informacion de restaurante a pratir del metodo que creamos en la clase Restaurante
                        restaurant.imprimirRestaurante();
                        break;
                        
                case 6:
                        //Eliminamos todos los valores de todos los atributos del objeto CM1
                        CM1 = null;
                        System.out.println("Ha sido eliminado el centro comercial\n");
                        break;
                        
                case 7:    
                        //Salimos del ciclo
                        System.out.println("Adios");
                        break;

                default: 
                        //En caso de que no se haya introducido un numero valido, mandar mesaje de error
                        System.out.println("Has elegido otro numero");
                        break;
                }//Fin del switch    
            
            }while (casos != 7);//Fin del do-while
        }else{//En caso de que la respuesta inicial (Crear o no un centro comercial) sea false, entonces manda este mensaje.
            System.out.println("No has creado nada");
        }   
        
    }//Fin del main
    
}
