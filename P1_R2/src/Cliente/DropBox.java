package Cliente;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class DropBox extends JFrame implements ActionListener {

    JButton BtnSubir, BtnActualizar, BtnDescargar, BtnEliminar;
    JLabel O=new JLabel("DROPBOX");

    static JList<String> archivos;
    static DefaultListModel<String> modelo;
    MouseListener mouseListener;
    JPanel panelBotones;
    
    static JProgressBar BarraProgreso;
    JScrollPane scroll;
    //File list[];

    public DropBox() {
          O.setAlignmentX(Component.CENTER_ALIGNMENT);
  O.setFont(new Font("Arial", Font.BOLD, 24));
  O.setForeground(Color.BLUE);
  add(O);
        setBounds(500,500,400,400);
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        this.getContentPane().setBackground(Color.WHITE);
       
        archivos = new JList<String>();
        archivos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        /*Añadimos la funcionalidad de doble clic para navegar por directorios*/
        mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int index = archivos.locationToIndex(e.getPoint());
                    String nombreSeleccion = modelo.getElementAt(index);

                    //Revisamos que la seleccion sea un directorio
                    if (Cliente.tipoFile[index] == 1) {
                        modelo.clear();
                        Cliente.AbrirCarpeta(index);
                    }
                }

            }
        };
        archivos.addMouseListener(mouseListener);
         
        modelo = new DefaultListModel<>();
        Cliente.Actualizar();

        archivos.setModel(modelo);
        archivos.setBackground(Color.darkGray);
        archivos.setForeground(Color.WHITE);
        archivos.setFont(new Font("Italic", Font.ITALIC, 16));
        scroll = new JScrollPane(archivos);
        scroll.setMinimumSize(new Dimension(0, 100));
   
        c.add(scroll);

        panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
         add(panelBotones, BorderLayout.EAST);
        panelBotones.setLayout(new GridLayout(2,4,2,3));
        panelBotones.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 20));
        BarraProgreso = new JProgressBar(0, 50);
        BarraProgreso.setAlignmentX(Component.CENTER_ALIGNMENT);
        BarraProgreso.setStringPainted(true);

        BtnSubir = new JButton("Subir");
        BtnActualizar = new JButton("Actualizar");
        BtnDescargar = new JButton("Descargar");
        BtnEliminar = new JButton("Eliminar");
        
        BtnSubir.setBackground(Color.BLUE);
        BtnSubir.setForeground(Color.WHITE);
        BtnActualizar.setBackground(Color.YELLOW);
        BtnDescargar.setBackground(Color.blue);
        BtnDescargar.setForeground(Color.WHITE);
        BtnEliminar.setBackground(Color.RED);
        BtnEliminar.setForeground(Color.WHITE);
        
        
  JLabel l=new JLabel("OPERACIONES");
  l.setAlignmentX(Component.CENTER_ALIGNMENT);
  l.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 18));
  l.setForeground(Color.BLACK);
  add(l);
 

        panelBotones.add(BtnSubir);
         panelBotones.add(BtnDescargar);
        panelBotones.add(BtnActualizar);
        panelBotones.add(BtnEliminar);
        c.add(panelBotones);
        
        BtnSubir.addActionListener(this);
        BtnActualizar.addActionListener(this);
        BtnDescargar.addActionListener(this);
        BtnEliminar.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b == BtnSubir) {
            Cliente.SeleccionarArchivos();
        } else if (b == BtnActualizar) {
            modelo.clear();
            Cliente.Actualizar();
        } else if (b == BtnDescargar) {
            if (!archivos.isSelectionEmpty()) {
                int[] indices = archivos.getSelectedIndices();
                String[] nombreSeleccion = new String[indices.length];

                for (int i = 0; i < indices.length; i++) {
                    System.out.println("El indice es: " + indices[i]);
                    nombreSeleccion[i] = modelo.getElementAt(indices[i]);
                    System.out.println("Nombre: " + nombreSeleccion[i]);
                }

                Cliente.RecibirArchivos(nombreSeleccion, indices.length);
            } else {
                JOptionPane.showMessageDialog(null, "Archivos a descargar.", "Archivos", JOptionPane.WARNING_MESSAGE);
            }

        } else if(b == BtnEliminar){
            if (!archivos.isSelectionEmpty()) {
                int[] indices = archivos.getSelectedIndices();
                String[] nombreSeleccion = new String[indices.length];

                for (int i = 0; i < indices.length; i++) {
                    System.out.println("El indice es: " + indices[i]);
                    nombreSeleccion[i] = modelo.getElementAt(indices[i]);
                    System.out.println("Nombre: " + nombreSeleccion[i]);
                }

                Cliente.EliminarArchivo(nombreSeleccion, indices.length);
            } else {
                JOptionPane.showMessageDialog(null, "Archivos a eliminar.","Archivos a eliminar.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String s[]) {
        DropBox f = new DropBox();
        f.setTitle("PRACTICA 1 REDES 2 ");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 400);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
