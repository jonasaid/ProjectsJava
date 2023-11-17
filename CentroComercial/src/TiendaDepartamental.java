/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class TiendaDepartamental {
    //Declaramos los atributos de la Clase COMPUESTA TiendaDepartamental
    private String nomTienda, producto, horario;
    private int cupoMaximo;

    
    //Este es el constructor de la clase, se requiere que como paramerto se pasen el nombre de la tienda
    //y el giro de la misma. Despues los valores de los parametros se le asignaran a los  atributos correspondientes
    TiendaDepartamental(String nom, String product){
        nomTienda = nom;
        producto = product;
    }
    
    //Obtenemos el valor del atributo nomTienda
    public String getNomTienda() {
        return nomTienda;
    }

    //Modificamos el valor del atributo nomTienda
    public void setNomTienda(String nomTienda) {
        this.nomTienda = nomTienda;
    }

    //Obtenemos el valor del atributo producto
    public String getProducto() {
        return producto;
    }

    //Modificamos el valor del atributo producto
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    //Obtenemos el valor del atributo horario
    public String getHorario() {
        return horario;
    }

    //Modificamos el valor del atributo horario
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    //Obtenemos el valor del atributo cupoMaximo
    public int getCupoMaximo() {
        return cupoMaximo;
    }

    //Modificamos el valor del atributo cupoMaximo
    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }    

}
