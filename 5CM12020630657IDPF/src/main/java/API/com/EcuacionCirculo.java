package API.com;

public class EcuacionCirculo extends Ejercicio {
    private String mostrarEc;
    float pX, pY;

    public EcuacionCirculo(String mostrarEc, String tipoEc, float cX, float cY, float pX, float pY, float r) {
        super(cX, cY, r, tipoEc);
        this.mostrarEc = mostrarEc;
        this.pX = pX;
        this.pY = pY;
    }

    public Resultado resolver() {
        Resultado res = new Resultado(valorX, valorY, valorC, false);
        res.setFormaEc((mostrarEc.contains("estandar")) ? 1 : 2);

        if (tipoEc.contains("radioDe")) {
            res = new Resultado(valorX, valorY, valorC, true);
        } else if (tipoEc.contains("porPuntos")) {
            float primerBinomio = (valorX - pX) * (valorX - pX);
            float segundoBinomio = (valorY - pY) * (valorY - pY);
            valorC = (float) Math.sqrt(primerBinomio + segundoBinomio);
            res = new Resultado(-valorX, -valorY, valorC, true);
        } else {
            res = new Resultado(valorX, valorY, valorC, false);
        }
        return res;
    }

    public String getMostrarEc() {
        return mostrarEc;
    }

    public void setMostrarEc(String mostrarEc) {
        this.mostrarEc = mostrarEc;
    }

    public float getpX() {
        return pX;
    }

    public void setpX(float pX) {
        this.pX = pX;
    }

    public float getpY() {
        return pY;
    }

    public void setpY(float pY) {
        this.pY = pY;
    }

}
