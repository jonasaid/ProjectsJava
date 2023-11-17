import java.awt.*;
import javax.swing.*;


public class ejemplo3 extends JFrame{
    public static void main(String[] args) {
    JFrame aWindow = new JFrame("This is a Flow Layout");
    aWindow.setBounds(300, 300, 300, 300); // Size
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    FlowLayout flow = new FlowLayout(); // Create a layout manager
    flow.setHgap(35);                   // Set the horizontal gap
    Container content = aWindow.getContentPane(); // Get the content pane
    content.setLayout(flow); // Set the container layout mgr
    // Now add six button components
    for (int i = 1; i <= 24; i++) {
      content.add(new JButton("Press " + i)); // Add a Button to content pane
    }
    aWindow.setVisible(true); // Display the window
  }
}
