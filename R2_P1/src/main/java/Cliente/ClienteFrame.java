package Cliente;

import static Servidor.ServidorFrame.agregaFilas;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ClienteFrame extends javax.swing.JFrame {
    
    final File[] archivosEnviar = new File[1];
            
    public ClienteFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jbEnviar = new javax.swing.JButton();
        jbArchivo = new javax.swing.JButton();
        jbCarpeta = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaArchivos = new javax.swing.JTable();

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

        jbEnviar.setText("Enviar");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });

        jbArchivo.setText("Archivo");
        jbArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbArchivoActionPerformed(evt);
            }
        });

        jbCarpeta.setText("Carpeta");
        jbCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCarpetaActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jTablaArchivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", " Tamaño (bytes)", "Ruta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTablaArchivos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jbEnviar)
                .addGap(18, 18, 18)
                .addComponent(jbArchivo)
                .addGap(18, 18, 18)
                .addComponent(jbCarpeta)
                .addGap(18, 18, 18)
                .addComponent(jbEliminar)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEnviar)
                    .addComponent(jbArchivo)
                    .addComponent(jbCarpeta)
                    .addComponent(jbEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCarpetaActionPerformed
        JFileChooser jfSelectorC = new JFileChooser();
        jfSelectorC.setMultiSelectionEnabled(true);
        jfSelectorC.setDialogTitle("Elige una carpeta a enviar");
        jfSelectorC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if (jfSelectorC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File carpetas[]=jfSelectorC.getSelectedFiles();
            
            for (int i = 0; i < carpetas.length; i++) {
                archivosEnviar[0] = carpetas[i];
                System.err.println("Este es el archivo que deseas subir: " + archivosEnviar[0].getName());
                agregaFila(archivosEnviar[0].getName(), archivosEnviar[0].length(), archivosEnviar[0].getAbsolutePath());          
            }
        }
          
    }//GEN-LAST:event_jbCarpetaActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        elimarFilasUsuario();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbArchivoActionPerformed
        JFileChooser jfSelectorA = new JFileChooser();
        jfSelectorA.setMultiSelectionEnabled(true);
        jfSelectorA.setDialogTitle("Elige el archivo a enviar");

        if (jfSelectorA.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivos[]=jfSelectorA.getSelectedFiles();
            
            for (int i = 0; i < archivos.length; i++) {
                archivosEnviar[0] = archivos[i];
                System.err.println("Este es el archivo que deseas subir: " + archivosEnviar[0].getName());
                agregaFila(archivosEnviar[0].getName(), archivosEnviar[0].length(), archivosEnviar[0].getAbsolutePath());          
            }
        }
    }//GEN-LAST:event_jbArchivoActionPerformed

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        Cliente cliente = new Cliente();
        jTablaArchivos.selectAll();
      
        while(jTablaArchivos.getSelectedRow() != -1){
            Object[] rowData = obtenerValoresTabla();
            String nombre = (String) rowData[0];
            long tam = (long) rowData[1];
            String ruta = (String) rowData[2];
            try {
                esCarpeta(ruta);
            } catch (IOException ex) {
                Logger.getLogger(ClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_jbEnviarActionPerformed

    public static void elimarFilasUsuario(){ 
        DefaultTableModel model = (DefaultTableModel) jTablaArchivos.getModel();
        int filasBorrar[] = jTablaArchivos.getSelectedRows();
        int i = 0;
        while(i < filasBorrar.length){
            model.removeRow(jTablaArchivos.getSelectedRow());
            i++;
        }              
    }
    
    public void esCarpeta(String ruta) throws IOException{
        File carpeta = new File(ruta);
        if (carpeta.isDirectory()) { 
            File accedeRuta = new File(ruta);
            String[] listado = accedeRuta.list();
            for (int i=0; i< listado.length; i++){
                String nuevaRuta = accedeRuta.getAbsolutePath()+ "\\" + listado[i];
                File archivo = new File(nuevaRuta);
                esCarpeta(archivo.getAbsolutePath());
            }
        }else{
            Cliente cliente = new Cliente();
            cliente.enviarArchivo(carpeta.getName(), carpeta.length(), carpeta.getAbsolutePath());
        }
    }
    
    public Object[] obtenerValoresTabla() {
        
        DefaultTableModel model = (DefaultTableModel) jTablaArchivos.getModel();
        Object[] rowData = new Object[jTablaArchivos.getColumnCount()];
        rowData[0] = jTablaArchivos.getValueAt(0, 0);
        rowData[1] = jTablaArchivos.getValueAt(0, 1);
        rowData[2] = jTablaArchivos.getValueAt(0, 2);
        model.removeRow(jTablaArchivos.getSelectedRow());
        return rowData;
        
    }
    
    public void agregaFila(String nombre, long tam, String ruta){
        DefaultTableModel model = (DefaultTableModel) jTablaArchivos.getModel();
        model.addRow(new Object[]{nombre, tam, ruta});
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTable jTablaArchivos;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbArchivo;
    private javax.swing.JButton jbCarpeta;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbEnviar;
    // End of variables declaration//GEN-END:variables
}
