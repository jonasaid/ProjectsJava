package Modelo;

public class PedirPlatillo {    
    public String Result;
    
    public String Comida(String nombre, double precio, String tamano, String sabor){
        return Result = (" Nombre: "+ nombre+" Sabor: "+ sabor+" Tamaño: "+ tamano+ " Precio: "+ precio);
    }    
    public String Bebida(String nombre, double precio, String tamano, String sabor){
        return Result = (" Nombre: "+ nombre+" Sabor: "+ sabor+" Tamaño: "+ tamano+ " Precio: "+ precio);
    }
    public String Postre(String nombre, double precio, String tamano, String sabor){
        return Result = (" Nombre: "+ nombre+" Sabor: "+ sabor+" Tamaño: "+ tamano+ " Precio: "+ precio);
    }    
    public String receta(Receta r){
        return Result = (" Nombre: "+ r.nombre+" Sabor: "+ r.sabor+" Tamaño: "+ r.tamano+ " Precio: "+ r.precio);
    }
}
