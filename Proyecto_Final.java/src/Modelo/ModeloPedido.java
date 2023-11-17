package Modelo;

public class ModeloPedido{    
    ModeloCliente Modeloc;
    ModeloPedido(ModeloCliente c){
        ModeloRepartidor r = new ModeloRepartidor();
        Modeloc = c;
    }    
}
