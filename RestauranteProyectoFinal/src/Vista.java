
import java.awt.*;
import javax.swing.*;


public class Vista extends JFrame{
 public JButton pesos, dolares;
 public JPanel panelB, panelR;
 public JLabel lResultado;
 public JTextField campoTexto;
 
 public Vista() {
  getContentPane().setLayout(new BorderLayout());
   
  panelB = new JPanel();
  panelB.setLayout(new FlowLayout());
   
  panelR = new JPanel();
  panelR.setLayout(new FlowLayout());
   
  pesos = new JButton("Convertir a Pesos");
  dolares = new JButton("Convertir a Dolares");
   
  lResultado = new JLabel("Resultado:");
  campoTexto = new JTextField(20);
   
  panelB.add(pesos); //Agregar botón convertir a pesos
  panelB.add(dolares); //Agregar botón convertir a dolares
   
  panelR.add(lResultado);
   
  add(campoTexto, BorderLayout.NORTH);
  add(panelB, BorderLayout.SOUTH);
  add(panelR, BorderLayout.CENTER);
 }
}