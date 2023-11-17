package API.com;

public class RadioYCirculo extends Ejercicio {

    public RadioYCirculo(float valorX, float valorY, float valorC, String tipoEc) {
        super(valorX, valorY, valorC, tipoEc);
    }

    public Resultado resolver() {
        Resultado res = null;
        if (tipoEc.contains("tipo1")) {
            float valorX = this.valorX;            
            float valorY = this.valorY;
            float valorC = this.valorC;

            valorX *= valorX;
            valorY *= valorY;
            valorC *= valorC;
            float coeficienteSumado = valorC - (valorX + valorY);
            if (coeficienteSumado < 0) {
                res = new Resultado(-this.valorX, -this.valorY, this.valorC, false);
            } else {
                valorC = (float) Math.sqrt(coeficienteSumado);
                res = new Resultado(-this.valorX, -this.valorY, this.valorC, true);
            }
            res = new Resultado(-valorX, -valorY, (float) Math.sqrt(valorC), true);
        } else if (tipoEc.contains("tipo2")) {
            valorX /= 2;
            valorY /= 2;
            float valorCuadradoX, valorCuadradoY, coeficienteSumado;
            valorCuadradoX = valorX * valorX;
            valorCuadradoY = valorY * valorY;
            coeficienteSumado = (-valorC) + valorCuadradoX + valorCuadradoY;
            if (coeficienteSumado < 0) {
                res = new Resultado(-valorX, -valorY, valorC, false);
            } else {
                valorC = (float) Math.sqrt(coeficienteSumado);
                res = new Resultado(-valorX, -valorY, valorC, true);
            }
        } else {
            res = new Resultado(valorX, valorY, valorC, false);
        }
        return res;
    }

}
