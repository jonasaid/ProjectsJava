package API.com;

public class RadioYCirculo extends Ejercicio {

    public RadioYCirculo(float valorX, float valorY, float valorC, String tipoEc) {
        super(valorX, valorY, valorC, tipoEc);
    }

    public Resultado resolver() {
        Resultado res = null;
        if (tipoEc.contains("tipo1")) {
            res = new Resultado(-valorX, -valorY, (float) Math.sqrt(valorC), true);
        } else if (tipoEc.contains("tipo2")) {
            valorX /= 2;
            valorY /= 2;
            float valorCuadradoX, valorCuadradoY, coeficienteSumado;
            valorCuadradoX = valorX * valorX;
            valorCuadradoY = valorY * valorY;
            coeficienteSumado = (-valorC) + valorCuadradoX + valorCuadradoY;
            valorC = (float) Math.sqrt(coeficienteSumado);
            res = new Resultado(-valorX, -valorY, valorC, true);
        } else {
            res = new Resultado(valorX, valorY, valorC, false);
        }
        return res;
    }

}
