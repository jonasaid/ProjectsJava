/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.Pedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jona-
 */
public class ControladorPedido implements ActionListener{
    protected Pedido vistaPedido;
    
    public void actionPerformed(ActionEvent e) {
        if(!"".equals(vistaPedido.getNombrePedidotxt().getText())) {
            String nombreCliente = vistaPedido.getNombrePedidotxt().getText();
            String domicilioCliente = vistaPedido.getDomicilioPedidotxt().getText();   
        }    
        
    }
    
}
