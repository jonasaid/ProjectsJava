package modelo;

public class Zancudo extends Insecto implements Volador{
    protected int numAlas;

    public int getNumAlas() {
        return numAlas;
    }
    
    public Zancudo(int numPatas, String Nombre, int alas) {
        super(numPatas, Nombre);
        numAlas = alas;
        nivelVeneno(numPatas);
    }

    @Override
    public void nivelVeneno(int patas){
        int potencia = patas + numAlas;
        super.nivelVeneno(potencia);
    }

    @Override
    public boolean volar() {                
        return true; 
    }

    @Override
    public String despegar() {
        return "";
    }
}
