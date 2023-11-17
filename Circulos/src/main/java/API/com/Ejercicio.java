package API.com;

public abstract class Ejercicio{
    protected float valorX, valorY, valorC;
    protected String tipoEc;
    protected int id;

    public Ejercicio(float valorX, float valorY, float valorC, String tipoEc) {
        this.valorX = valorX;
        this.valorY = valorY;
        this.valorC = valorC;
        this.tipoEc = tipoEc;
    }
    
    public float getValorX() {
        return valorX;
    }

    public void setValorX(float valorX) {
        this.valorX = valorX;
    }

    public float getValorY() {
        return valorY;
    }

    public void setValorY(float valorY) {
        this.valorY = valorY;
    }

    public float getValorC() {
        return valorC;
    }

    public void setValorC(float valorC) {
        this.valorC = valorC;
    }

    public String getTipoEc() {
        return tipoEc;
    }

    public void setTipoEc(String bandera) {
        this.tipoEc = bandera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
