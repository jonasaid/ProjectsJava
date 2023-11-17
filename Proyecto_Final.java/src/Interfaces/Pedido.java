/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Bebida;
import Modelo.Comida;
import Modelo.PedirPlatillo;
import Modelo.Postre;
import Modelo.Receta;
import java.util.ArrayList;
import Controlador.ControladorRepartidor;
import Modelo.ModeloRepartidor;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Pedido extends javax.swing.JFrame {
    ControladorRepartidor repartidorC;
    PedirPlatillo pedirPlatillo;
    PedirPlatillo platilloHecho = new PedirPlatillo();
    String receta;
    List <String> platillosCadenas = new ArrayList();
    String NombreCliente;
    String DomCliente;
    int Repartidor;
    int Platillo;
    String Cantidad;
    
    Receta comida_1 = new Comida("Tacos",15,"Mediano","Suadero");
    Receta comida_2 = new Comida("Pizza",15,"Chica","Mexicana");
    Receta bebida_1 = new Bebida("Refresco",15,"Chico","Coca Cola");
    Receta bebida_2 = new Bebida("Agua",15,"Mediano","Simple");
    Receta postre_1 = new Postre("Pastel",15,"Grande","Chocolate");
    Receta postre_2 = new Postre("Helado",15,"Chico","Napolitano");
    
    public Pedido() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.repartidorC = new ControladorRepartidor();    
    }
    public Pedido(PedirPlatillo pedirPlatillo, String receta) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pedirPlatillo = pedirPlatillo;
        this.receta = receta; 
    }
    public void entrada(){
        NombreCliente = nombrePedidotxt.getText();
        DomCliente = domicilioPedidotxt.getText();
        Repartidor = Integer.parseInt(numeroRepartidortext.getText());
        Platillo = Integer.parseInt(numeroPlatillotxt.getText());
        Cantidad = cantidadPlatillotxt.getText();
    }
    
    public Pedido(ControladorRepartidor cr) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.repartidorC = cr;    
        DefaultTableModel modelo = (DefaultTableModel) repartidoresDisponibles.getModel();
        for(int i=0; i<repartidorC.getRepartidores().size(); i++){
            ModeloRepartidor repartidor = repartidorC.getRepartidores().get(i);
            int id = i+1;
            repartidor.setId(id);
            modelo.addRow(new Object []{repartidor.getId(),repartidor.getNombrePersona()});
        }       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Pago = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombrePedidotxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        domicilioPedidotxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        numeroRepartidortext = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        repartidoresDisponibles = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        numeroPlatillotxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cantidadPlatillotxt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        platilloElegirtxt = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        efectivoCheck = new javax.swing.JRadioButton();
        debitoCheck = new javax.swing.JRadioButton();
        creditoCheck = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        enviarPedidoBoton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        regresarBoton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(98, 233, 239));

        jLabel1.setFont(new java.awt.Font("Mistral", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REALIZAR PEDIDO");

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("DATOS DEL CLIENTE");

        nombrePedidotxt.setBackground(new java.awt.Color(204, 255, 255));
        nombrePedidotxt.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        nombrePedidotxt.setForeground(new java.awt.Color(153, 153, 153));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel4.setText("Domicilio");

        domicilioPedidotxt.setBackground(new java.awt.Color(204, 255, 255));
        domicilioPedidotxt.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        domicilioPedidotxt.setForeground(new java.awt.Color(153, 153, 153));
        domicilioPedidotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domicilioPedidotxtActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setText("REPARTIDORES DISPONIBLES");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel11.setText("N° Repartidor");

        numeroRepartidortext.setBackground(new java.awt.Color(204, 255, 255));
        numeroRepartidortext.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        numeroRepartidortext.setForeground(new java.awt.Color(153, 153, 153));

        repartidoresDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(repartidoresDisponibles);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombrePedidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(domicilioPedidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(numeroRepartidortext, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombrePedidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(domicilioPedidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(numeroRepartidortext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("PLATILLO A ELEGIR");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setText("N° Platillo");

        numeroPlatillotxt.setBackground(new java.awt.Color(204, 255, 255));
        numeroPlatillotxt.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        numeroPlatillotxt.setForeground(new java.awt.Color(153, 153, 153));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel8.setText("Cantidad");

        cantidadPlatillotxt.setBackground(new java.awt.Color(204, 255, 255));
        cantidadPlatillotxt.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        cantidadPlatillotxt.setForeground(new java.awt.Color(153, 153, 153));

        jScrollPane3.setBackground(new java.awt.Color(153, 255, 255));

        platilloElegirtxt.setBackground(new java.awt.Color(204, 255, 255));
        platilloElegirtxt.setColumns(20);
        platilloElegirtxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        platilloElegirtxt.setForeground(new java.awt.Color(153, 153, 153));
        platilloElegirtxt.setRows(5);
        jScrollPane3.setViewportView(platilloElegirtxt);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numeroPlatillotxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cantidadPlatillotxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(numeroPlatillotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cantidadPlatillotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setText("Método de Pago");

        Pago.add(efectivoCheck);
        efectivoCheck.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        efectivoCheck.setText("Efectivo");
        efectivoCheck.setContentAreaFilled(false);

        Pago.add(debitoCheck);
        debitoCheck.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        debitoCheck.setText("Tarjeta de Debito");
        debitoCheck.setContentAreaFilled(false);

        creditoCheck.setBackground(new java.awt.Color(204, 255, 255));
        Pago.add(creditoCheck);
        creditoCheck.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        creditoCheck.setText("Tarjeta de Crédito");
        creditoCheck.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(efectivoCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(debitoCheck)
                        .addGap(28, 28, 28)
                        .addComponent(creditoCheck)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(debitoCheck)
                    .addComponent(creditoCheck)
                    .addComponent(efectivoCheck))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 255, 255));

        enviarPedidoBoton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enviarPedidoBoton.setText("Enviar Pedido");
        enviarPedidoBoton.setContentAreaFilled(false);
        enviarPedidoBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enviarPedidoBotonMouseClicked(evt);
            }
        });
        enviarPedidoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarPedidoBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enviarPedidoBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enviarPedidoBoton)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(153, 255, 255));

        regresarBoton.setBackground(new java.awt.Color(102, 102, 255));
        regresarBoton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        regresarBoton.setText("Regresar");
        regresarBoton.setContentAreaFilled(false);
        regresarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarBotonMouseClicked(evt);
            }
        });
        regresarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(regresarBoton)
                .addGap(25, 25, 25))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regresarBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(153, 255, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Platillos Disponibles");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBotonActionPerformed
        this.dispose();
        new Principal(repartidorC).setVisible(true);
    }//GEN-LAST:event_regresarBotonActionPerformed

    private void enviarPedidoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarPedidoBotonActionPerformed
        
        if(efectivoCheck.isSelected()){
        entrada();
        ImprimirPedido envia = new ImprimirPedido();
        this.setVisible(false);
        envia.setVisible(true);
        ImprimirPedido.Recibe.setText(" Nombre: "+NombreCliente+"\n\n"+" Domicilio: "+DomCliente+"\n\n"+
                                      " Numero de Repartidor: "+Repartidor+"\n\n"+" Numero de Platillo: "+Platillo+"\n\n"+
                                      " Cantidad: "+Cantidad+"\n\n" + " Forma de Pago: EFECTIVO");
        }
        else if(debitoCheck.isSelected()){
        entrada();
        ImprimirPedido envia = new ImprimirPedido();
        this.setVisible(false);
        envia.setVisible(true);
        ImprimirPedido.Recibe.setText(" Nombre: "+NombreCliente+"\n\n"+" Domicilio: "+DomCliente+"\n\n"+
                                      " Numero de Repartidor: "+Repartidor+"\n\n"+" Numero de Platillo: "+Platillo+"\n\n"+
                                      " Cantidad: "+Cantidad+"\n\n" + " Forma de Pago: TARJETA DE DÉBITO");
        }        
        if(creditoCheck.isSelected()){
        entrada();
        ImprimirPedido envia = new ImprimirPedido();
        this.setVisible(false);
        envia.setVisible(true);
        ImprimirPedido.Recibe.setText(" Nombre: "+NombreCliente+"\n\n"+" Domicilio: "+DomCliente+"\n\n"+
                                      " Numero de Repartidor: "+Repartidor+"\n\n"+" Numero de Platillo: "+Platillo+"\n\n"+
                                      " Cantidad: "+Cantidad+"\n\n" + " Forma de Pago: TARJETA DE CRÉDITO");
        }
    }//GEN-LAST:event_enviarPedidoBotonActionPerformed

    private void regresarBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarBotonMouseClicked
        new Principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarBotonMouseClicked

    private void domicilioPedidotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domicilioPedidotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domicilioPedidotxtActionPerformed

    private void enviarPedidoBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarPedidoBotonMouseClicked
        JOptionPane.showMessageDialog(this, "El pedido se ha seleccionado al repartidor "+numeroRepartidortext);
    }//GEN-LAST:event_enviarPedidoBotonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        platilloElegirtxt.setText("1. "+platilloHecho.receta(comida_1)+"\n\n"+"2. "+platilloHecho.receta(comida_2)+"\n\n"+
            "3. "+platilloHecho.receta(bebida_1)+"\n\n"+"4. "+platilloHecho.receta(bebida_2)+"\n\n"+"5. "
            +platilloHecho.receta(postre_1)+"\n\n"+"6. "+platilloHecho.receta(postre_2));//+"\n\n"+"7. "+receta
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedido().setVisible(true);
            }
        });
    }
    
    //Metodos get y set de los elementos que se ocupan, (botones, textField)
    
    public JTextField getCantidadPlatillotxt() {
        return cantidadPlatillotxt;
    }

    public void setCantidadPlatillotxt(JTextField cantidadPlatillotxt) {
        this.cantidadPlatillotxt = cantidadPlatillotxt;
    }

    public JRadioButton getCreditoCheck() {
        return creditoCheck;
    }

    public void setCreditoCheck(JRadioButton creditoCheck) {
        this.creditoCheck = creditoCheck;
    }

    public JRadioButton getDebitoCheck() {
        return debitoCheck;
    }

    public void setDebitoCheck(JRadioButton debitoCheck) {
        this.debitoCheck = debitoCheck;
    }

    public JTextField getDomicilioPedidotxt() {
        return domicilioPedidotxt;
    }

    public void setDomicilioPedidotxt(JTextField domicilioPedidotxt) {
        this.domicilioPedidotxt = domicilioPedidotxt;
    }

    public JRadioButton getEfectivoCheck() {
        return efectivoCheck;
    }

    public void setEfectivoCheck(JRadioButton efectivoCheck) {
        this.efectivoCheck = efectivoCheck;
    }

    public JButton getEnviarPedidoBoton() {
        return enviarPedidoBoton;
    }

    public void setEnviarPedidoBoton(JButton enviarPedidoBoton) {
        this.enviarPedidoBoton = enviarPedidoBoton;
    }

    public JTextField getNombrePedidotxt() {
        return nombrePedidotxt;
    }

    public void setNombrePedidotxt(JTextField nombrePedidotxt) {
        this.nombrePedidotxt = nombrePedidotxt;
    }

    public JTextField getNumeroPlatillotxt() {
        return numeroPlatillotxt;
    }

    public void setNumeroPlatillotxt(JTextField numeroPlatillotxt) {
        this.numeroPlatillotxt = numeroPlatillotxt;
    }

    public JTextField getNumeroRepartidortext() {
        return numeroRepartidortext;
    }

    public void setNumeroRepartidortext(JTextField numeroRepartidortext) {
        this.numeroRepartidortext = numeroRepartidortext;
    }

    public JScrollPane getPlatilloElegirtxt() {
        return jScrollPane3;
    }

    public JButton getRegresarBoton() {
        return regresarBoton;
    }

    public void setRegresarBoton(JButton regresarBoton) {
        this.regresarBoton = regresarBoton;
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup Pago;
    private javax.swing.JTextField cantidadPlatillotxt;
    private javax.swing.JRadioButton creditoCheck;
    private javax.swing.JRadioButton debitoCheck;
    private javax.swing.JTextField domicilioPedidotxt;
    private javax.swing.JRadioButton efectivoCheck;
    private javax.swing.JButton enviarPedidoBoton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    protected javax.swing.JTextField nombrePedidotxt;
    private javax.swing.JTextField numeroPlatillotxt;
    private javax.swing.JTextField numeroRepartidortext;
    private javax.swing.JTextArea platilloElegirtxt;
    private javax.swing.JButton regresarBoton;
    private javax.swing.JTable repartidoresDisponibles;
    // End of variables declaration//GEN-END:variables
}
