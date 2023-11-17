package Modelo;
public class Receta {
    public String nombre;
    public double precio;
    public String tamano;
    public String sabor;
    public String resultado;
    
    Receta(String nom, double pre, String tam, String sab) {
        nombre = nom;
        precio = pre;
        tamano = tam;
        sabor = sab;
    }
    public String getnombre(){
        return nombre;
    }
    public double getprecio(){   
        return precio;
    }
    public String gettamano(){
        return tamano;
    }
    public String getsabor(){
        return sabor;
    }
    public void settamano(String tam){
        tamano = tam;
    }
    public void setsabor(String sab){
        sabor = sab;
    }
    public void setnombre(String nom){
        nombre = nom;
    }
    public void setprecio(double pre){   
        precio = pre;
    }
    public void imprimir(){
        resultado = ("Nombre: "+ nombre + " Precio: "+ precio + " Proporcion: "+ tamano + " Sabor: "+ sabor);
    }
}