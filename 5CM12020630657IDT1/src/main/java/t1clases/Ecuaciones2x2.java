package t1clases;

public class Ecuaciones2x2 {
    protected double coeficienteA11, coeficienteA12, 
            coeficienteA21, coeficienteA22, 
            constante1, constante2, determinante;

    public Ecuaciones2x2(double coeficienteA11, double coeficienteA12, double coeficienteA21, double coeficienteA22, double constante1, double constante2) {
        this.coeficienteA11 = coeficienteA11;
        this.coeficienteA12 = coeficienteA12;
        this.coeficienteA21 = coeficienteA21;
        this.coeficienteA22 = coeficienteA22;
        this.constante1 = constante1;
        this.constante2 = constante2;
    }

    private double encontrarDeterminante2x2Krammer(double a11, double a12, double a21, double a22){
        return this.determinante = a11*a22 - a21*a12;
    }
     
    public double[] resolverEcuacionLineal2x2Krammer(Ecuaciones2x2 ecu){
        encontrarDeterminante2x2Krammer(ecu.coeficienteA11, ecu.coeficienteA12, ecu.coeficienteA21, ecu.coeficienteA22);
        if(determinante == 0.0){
            return( null );  
        }
        double[] resultado = { (ecu.constante1*ecu.coeficienteA22 - ecu.constante2*ecu.coeficienteA12) / determinante, (ecu.constante2*ecu.coeficienteA11 - ecu.constante1*ecu.coeficienteA21) / determinante };
        return resultado;
    }
    
    public static String pintarSolucionEcuacionLineal2x2Krammer(Ecuaciones2x2 ecu){
        String determinanteNumerador1 = "det["+ecu.constante1+" "+ecu.coeficienteA12+"]<br>"+"        ["+ecu.constante2+" "+ecu.coeficienteA22+"]";
        String determinanteNumerador2 = "det["+ecu.coeficienteA11+" "+ecu.constante1+"]<br>"+"        ["+ecu.coeficienteA21+" "+ecu.constante2+"]";
        String determinanteDenominador = "      det["+ecu.coeficienteA11+" "+ecu.coeficienteA12+"]<br>"+"         ["+ecu.coeficienteA12+" "+ecu.coeficienteA22+"]";
        
        int maximo = Math.max(determinanteNumerador1.split("<br>")[0].length(), determinanteNumerador2.split("<br>")[0].length());
        maximo = Math.max(maximo, determinanteDenominador.trim().split("<br>")[0].length());
        
        String simboloDivision = "—";
        simboloDivision = simboloDivision.repeat(maximo);
        
        String resultado1 = "<label>x<sub>1</sub> = </label>"+determinanteNumerador1+"<br>"
                + "     "+simboloDivision+"<br>"+determinanteDenominador+"<br><br>";
        String resultado2 = "<label>x<sub>2</sub> = </label>"+determinanteNumerador2+"<br>"
                + "     "+simboloDivision+"<br>"+determinanteDenominador;
        
        String resultado = resultado1+resultado2;
        return resultado;   
    }

}
