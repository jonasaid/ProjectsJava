package modelo;

public class Insecto {
    protected int numPatas;
    protected String Nombre;
    protected double gradoVeneno;

    public int getNumPatas() {
        return numPatas;
    }

    public String getNombre() {
        return Nombre;
    }

    public double getGradoVeneno() {
        return gradoVeneno;
    }
    
    public Insecto(int numPatas, String Nombre) {
        this.Nombre = Nombre;
        this.numPatas = numPatas;
    }
    
    public void nivelVeneno(int patas){
        gradoVeneno = patas * 0.2;
    }           
}
