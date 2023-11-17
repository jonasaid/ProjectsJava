package API.com;

public class Resultado {
    private float c1, c2, r;
    private boolean resuelta;
    private int id;
    
    private static int formaEc;//1 = estandar, 2 = general
    

    public Resultado(float c1, float c2, float r, boolean resuelta) {
        this.c1 = c1;
        this.c2 = c2;
        this.r = r;
        this.resuelta = resuelta;
    }

    public int getFormaEc() {
        return formaEc;
    }

    public void setFormaEc(int formaEc) {
        this.formaEc = formaEc;
    }
    
    public float getC1() {
        return c1;
    }

    public void setC1(float c1) {
        this.c1 = c1;
    }

    public float getC2() {
        return c2;
    }

    public void setC2(float c2) {
        this.c2 = c2;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }

    @Override
    public String toString() {
        return "Resultado{" + "c1= " + c1 + ", c2= " + c2 + ", r= " + r + ", resuelta= " + resuelta + ", formaEc= " + formaEc + '}';
    }
    
}
