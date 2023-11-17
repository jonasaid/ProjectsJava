
package Controlador;

import java.util.List;
import java.util.ArrayList;
import modelo.Zancudo;

public class ControladorZancudo {
    List<Zancudo> zancudos = new ArrayList();
    
    public ControladorZancudo(){}
    
    public void agregarZancudo(int numPatas, String Nombre, int alas){
        Zancudo zancudo = new Zancudo(numPatas, Nombre, alas);
        zancudos.add(zancudo);
    }

    public List<Zancudo> getZancudos() {
        return zancudos;
    }        

}
