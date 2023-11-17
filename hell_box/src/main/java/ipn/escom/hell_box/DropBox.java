package ipn.escom.hell_box;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;	
import java.io.*;

public class DropBox extends JFrame implements ActionListener {
	JButton BtnSubir, BtnActualizar, BtnDescargar, BtnEliminar;
	static JList<String> archivos;
	static DefaultListModel<String> modelo;
	MouseListener mouseListener;
	JPanel panelBotones;
	JScrollPane scroll;
	//File list[];

	public DropBox() {
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));

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
		
        scroll = new JScrollPane(archivos);
        scroll.setMinimumSize(new Dimension(100, 200));

		c.add(scroll);

		panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));



		BtnSubir = new JButton("UPLOAD");
		BtnActualizar = new JButton("REFRESH");
		BtnDescargar = new JButton("DOWNLOAD");
                BtnEliminar = new JButton("DELETE");

		panelBotones.add(BtnSubir);
		panelBotones.add(BtnActualizar);
		panelBotones.add(BtnDescargar);
                panelBotones.add(BtnEliminar);

		c.add(panelBotones);

		BtnSubir.addActionListener(this);
                BtnSubir.setBorderPainted(false);
                BtnSubir.setBackground(Color.red);
                
		BtnActualizar.addActionListener(this);
                BtnActualizar.setBorderPainted(false);
                BtnActualizar.setBackground(Color.red);
                
		BtnDescargar.addActionListener(this);
                BtnDescargar.setBorderPainted(false);
                BtnDescargar.setBackground(Color.red);
                
                BtnEliminar.addActionListener(this);
                BtnEliminar.setBorderPainted(false);
                BtnEliminar.setBackground(Color.red);
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		    
		if(b == BtnSubir) {
			Cliente.SeleccionarArchivos();
		}
		else if(b == BtnActualizar) {
			modelo.clear();
			Cliente.Actualizar();
		}
		else if(b == BtnDescargar) {
			if(!archivos.isSelectionEmpty()) {
				int[] indices = archivos.getSelectedIndices();	
				String[] nombreSeleccion = new String[indices.length];

				for(int i = 0; i < indices.length; i++) {
					System.out.println(":::: " + indices[i]);
				    nombreSeleccion[i] = modelo.getElementAt(indices[i]);
				    System.out.println(":::file -> " + nombreSeleccion[i]);
				}

				Cliente.RecibirArchivos(nombreSeleccion, indices.length);
			}
			else {
				JOptionPane.showMessageDialog(null, "::: PLEASE SELECT FILES FOR DOWNLOAD :::");
			}
			
		}
                
                else if(b == BtnEliminar)
        {
            if (!archivos.isSelectionEmpty()) 
            {
                int[] indices = archivos.getSelectedIndices();
                String[] nombreSeleccion = new String[indices.length];

                for (int i = 0; i < indices.length; i++) 
                {
                    System.out.println(":::INDEX : " + indices[i] + ":::");
                    nombreSeleccion[i] = modelo.getElementAt(indices[i]);
                    System.out.println(":::FILE NAME: " + nombreSeleccion[i] +":::");
                }

                Cliente.EliminarArchivo(nombreSeleccion, indices.length);
            }
            else 
            {
                JOptionPane.showMessageDialog(null, ":::PLEASE, MAKE A SELECTION:::");
            }
        }
	}

	public static void main(String s[]) {
		DropBox f = new DropBox();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1080,720);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}
}