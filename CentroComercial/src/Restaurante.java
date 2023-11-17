/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Restaurante {
    //Declaramos los atributos de la Clase AGREGADA Restaurante
    private String nombre;
    private int numComensales;
    private String horario = "(no existe horario)";
    private String tipoComida = "(no existe tipo de comida)";

    //Este es el constructor de la clase, se requiere que como paramerto se pasen el nombre del restaurante
    //y el giro de la misma. Despues el valore de nom se asignara a el atributo correspondiente, mientras que el giro siempre sera comida.
    Restaurante(String nom, String producto){
        nombre = nom;
        producto = "Comida";
    }
    
    //Obtenemos el valor del atributo nombre
    public String getNombre() {
        return nombre;
    }
 
    //Modificamos el valor del atributo numComensales
    public void setnumComensales(int numero) {
        numComensales = numero;
    }
    
    //Obtenemos el valor del atributo numComensales
    public int getnumComensales() {
        return numComensales;
    }
    
    //Modificamos el valor del atributo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Agregamos mas clientes al restaurante, el numero que recibe como parametro, 
    //es la cantidad que se incrementará
    public int agregarComensal(int num){
        return numComensales += num;
    }
    
    //Modificamos el valor del atributo horario.
    public void setHorario(String horario) {
        this.horario = horario;
    }

    //Modificamos el valor del atributo tipoComida
    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
    
    //Imprime todos los valores de los atributos del objeto de la clase Restaurante
    public void imprimirRestaurante(){
        System.out.println("El restaurante es " + "'"+ nombre + "'"+" y tiene "+ numComensales + " comensales, su horario es de "+ horario + " y el tipo de comida que venden es: "+ tipoComida + "\n");    
    }
    
    //Me indica si un restaurante no ha recibido valores, recibe un objeto de tipo Restaurante y regresa un boolean
    public boolean validarRestaurante(Restaurante r){
        boolean validacion = false;
        if(r.nombre.contains("(no hay)")){
            validacion = true;
        }
        return validacion;
    }
        
}
