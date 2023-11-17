
import java.net.URL;
import javax.swing.ImageIcon;
import java.net.*;
import java.io.*;
import java.util.zip.ZipOutputStream;

public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initDisco();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        int i = 0, numDisco = disco.length;
        carrito = new Disco[numDisco];
        for (int n = 0; n < numDisco; n++) {
            carrito[i] = null;
        }
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        panelCarrito = new javax.swing.JPanel();
        panelBoton = new javax.swing.JPanel();
        panelElementos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();

        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        botonComprar = new javax.swing.JButton();

        jPanel5 = new javax.swing.JPanel[numDisco];
        jButton2 = new javax.swing.JButton[numDisco];
        jLabel8 = new javax.swing.JLabel[numDisco];
        jLabel9 = new javax.swing.JLabel[numDisco];
        jLabel10 = new javax.swing.JLabel[numDisco];
        jLabel11 = new javax.swing.JLabel[numDisco];
        jLabel12 = new javax.swing.JLabel[numDisco];
        jLabel13 = new javax.swing.JLabel[numDisco];
        jLabel27 = new javax.swing.JLabel[numDisco];
        jLabel28 = new javax.swing.JLabel[numDisco];
        jLabel31 = new javax.swing.JLabel[numDisco];
        jLabel32 = new javax.swing.JLabel[numDisco];
        jLabel3 = new javax.swing.JLabel[numDisco];

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carrito");
        setBackground(new java.awt.Color(102, 255, 102));
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(51, 255, 102));

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));
        jPanel1.setAutoscrolls(true);

        jLabel1.setText("Bienvenido");

        //jPanel7.setAutoscrolls(true);
        //jPanel7.setPreferredSize(new java.awt.Dimension(400, 350));
        jPanel7.setLayout(new java.awt.GridLayout(4, 2, 5, 5));

        for (i = 0; i < numDisco; i++) {
            jPanel5[i] = new javax.swing.JPanel();
            jButton2[i] = new javax.swing.JButton();
            jLabel8[i] = new javax.swing.JLabel();
            jLabel9[i] = new javax.swing.JLabel();
            jLabel10[i] = new javax.swing.JLabel();
            jLabel11[i] = new javax.swing.JLabel();
            jLabel12[i] = new javax.swing.JLabel();
            jLabel13[i] = new javax.swing.JLabel();
            jLabel13[i] = new javax.swing.JLabel();
            jLabel27[i] = new javax.swing.JLabel();
            jLabel28[i] = new javax.swing.JLabel();
            jLabel31[i] = new javax.swing.JLabel();
            jLabel32[i] = new javax.swing.JLabel();
            jLabel3[i] = new javax.swing.JLabel();

            jPanel5[i].setBackground(new java.awt.Color(255, 102, 102));
            jPanel5[i].setBorder(new javax.swing.border.MatteBorder(null));
            jPanel5[i].setPreferredSize(new java.awt.Dimension(200, 200));
            java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();
            jPanel5Layout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            jPanel5Layout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
            jPanel5Layout.columnWeights = new double[]{0.0};
            jPanel5Layout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
            jPanel5[i].setLayout(jPanel5Layout);

            jLabel8[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel8[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel8[i].setText("Artista/Grupo:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 2;
            jPanel5[i].add(jLabel8[i], gridBagConstraints);

            jLabel27[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel27[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel27[i].setText("Album:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.gridwidth = 2;
            jPanel5[i].add(jLabel27[i], gridBagConstraints);

            jLabel28[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel28[i].setText(disco[i].getTitulo());
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.gridwidth = 5;
            jPanel5[i].add(jLabel28[i], gridBagConstraints);

            jLabel9[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel9[i].setText("Genero:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            jPanel5[i].add(jLabel9[i], gridBagConstraints);

            jLabel10[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel10[i].setText(disco[i].getArtista());
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 2;
            jPanel5[i].add(jLabel10[i], gridBagConstraints);

            jLabel11[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel11[i].setText(disco[i].getGenero());
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 4;
            jPanel5[i].add(jLabel11[i], gridBagConstraints);

            jLabel12[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel12[i].setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel12[i].setText("Precio:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;
            jPanel5[i].add(jLabel12[i], gridBagConstraints);

            jLabel13[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel13[i].setText(String.valueOf(disco[i].getPrecio()));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 5;
            jPanel5[i].add(jLabel13[i], gridBagConstraints);

            jLabel31[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel31[i].setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel31[i].setText("Cantidad:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 6;
            jPanel5[i].add(jLabel31[i], gridBagConstraints);

            jLabel32[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel32[i].setText(String.valueOf(disco[i].getCantidad()));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 6;
            jPanel5[i].add(jLabel32[i], gridBagConstraints);

            jButton2[i].setText("Agregar");
            final int n = i;
            jButton2[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt, disco[n].getTitulo());
                }
            });

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 6;
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.gridheight = 2;
            jPanel5[i].add(jButton2[i], gridBagConstraints);

            String path = "imagec\\" + disco[i].getNombreImagen();
            URL url = this.getClass().getResource(path);
            ImageIcon icon = new ImageIcon(url);
            jLabel3[i].setIcon(icon);
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.gridheight = 3;
            jPanel5[i].add(jLabel3[i], gridBagConstraints);

            jPanel7.add(jPanel5[i]);
        }
        scroll = new javax.swing.JScrollPane(jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(173, 173, 173)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Catalogo", jPanel1);
        jTabbedPane1.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));

        jLabel14.setText("Productos Agregados");

        panelCarrito.setBackground(new java.awt.Color(51, 51, 255));
        panelCarrito.setLayout(new java.awt.GridLayout(3, 1));

        botonComprar.setText("Comprar");
        botonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprarActionPerformed(evt);
            }
        });

        panelElementos.setLayout(new java.awt.GridLayout(10, 1, 5, 0));
        scroll2 = new javax.swing.JScrollPane(panelElementos);
        panelBoton.add(botonComprar);
        panelCarrito.setLayout(new java.awt.BorderLayout());
        panelCarrito.add(scroll2);
        panelCarrito.add(panelBoton, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel14)
                                .addContainerGap(382, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Carrito", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 700) / 2, (screenSize.height - 438) / 2, 700, 438);
    }// </editor-fold>                          

    public void initDisco() {
        try {
            Socket cl = new Socket("localhost", 8500);
            System.out.println("Conexion con servidor exitosa");
            ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
            disco = (Disco[]) ois.readObject();

            for (int i = 0, num = disco.length; i < num; i++) {
                Socket cl2 = new Socket("localhost", 8500);
                Socket cl3 = new Socket("localhost", 8500);

                System.out.println("-----------------");
                System.out.println("Disco: " + disco[i].getTitulo());
                System.out.println("Artista: " + disco[i].getArtista());
                System.out.println("Genero: " + disco[i].getGenero());
                System.out.println("Precio: " + disco[i].getPrecio());
                System.out.println("Imagen: " + disco[i].getNombreImagen());
                System.out.println("Cantidad: " + disco[i].getCantidad());
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl2.getOutputStream()));
                pw.println(disco[i].getNombreImagen());
                pw.flush();

                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("imagec\\" + disco[i].getNombreImagen()));
                BufferedInputStream bis = new BufferedInputStream(cl3.getInputStream());

                //cl2.setSoTimeout(3000);
                byte[] buf = new byte[1500];
                int leidos;
                while ((leidos = bis.read(buf, 0, buf.length)) != -1) {
                    bos.write(buf, 0, leidos);
                    bos.flush();
                }//while
                bis.close();
                bos.close();
                System.out.println("Archivo copiado....");
            }
            Socket cl2 = new Socket("localhost", 8500);
            Socket cl3 = new Socket("localhost",8500);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl2.getOutputStream()));
            pw.println("Ya");
            pw.flush();
        } catch (SocketException se) {
            System.out.println(se);
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, String album) {
        Disco agregar = null;
        for (int i = 0, num = disco.length; i < num; i++) {
            if (disco[i].getTitulo().equals(album)) {
                agregar = new Disco(disco[i]);
                break;
            }
        }
        if (carrito[0] == null) {
            carrito[0] = new Disco(agregar);
            carrito[0].setCantidad(1);
            javax.swing.JOptionPane.showMessageDialog(null, "Se agrego al carrito");
            addPanel();
        } else {
            for (int i = 0, num = carrito.length; i < num; i++) {
                if (carrito[i] == null) {
                    carrito[i] = new Disco(agregar);
                    carrito[i].setCantidad(1);
                    javax.swing.JOptionPane.showMessageDialog(null, "Se agrego al carrito");
                    addPanel();
                    break;
                }
                if (carrito[i].getTitulo().equals(album)) {
                    carrito[i].setCantidad(carrito[i].getCantidad() + 1);
                    javax.swing.JOptionPane.showMessageDialog(null, "Se agrego otro al carrito");
                    addPanel();
                    break;
                }
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt, String album) {
        Disco aux = null;
        for (int i = 0, num = carrito.length; i < num; i++) {
            if (carrito[i].getTitulo().equals(album)) {
                if (carrito[i].getCantidad() - 1 == 0) {
                    for (int n = i; (n < num - 1 && carrito[n] != null); n++) {
                        if (carrito[n + 1] == null) {
                            carrito[n] = null;
                        } else {
                            aux = carrito[n];
                            carrito[n] = carrito[n + 1];
                            carrito[n + 1] = aux;
                        }
                    }
                } else {
                    carrito[i].setCantidad(carrito[i].getCantidad() - 1);
                }
                javax.swing.JOptionPane.showMessageDialog(null, "Se quito del carrito");
                addPanel();
                break;
            }
        }
    }

    public void botonComprarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.carrito[0] == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Agregue productos al carrito");
            jTabbedPane1.setSelectedIndex(0);
            return;
        }
        try {
            Socket cl4 = new Socket("localhost", 8500);
            Socket cl5 = new Socket("localhost", 8500);

            ObjectOutputStream oos = new ObjectOutputStream(cl4.getOutputStream());
            oos.writeObject(this.carrito);

            BufferedReader br = new BufferedReader(new InputStreamReader(cl5.getInputStream()));
            String linea = "";
            String ticket = "";
            while (!(linea = br.readLine()).equals("null")) {
                ticket += linea + "\n";
            }
            javax.swing.JOptionPane.showMessageDialog(null, ticket);            
            jTabbedPane1.setSelectedIndex(0);
          
            String carpetaMiMusica = Cliente.generarRuta();
                     
            for (int i = 0; i <carrito.length; i++){
                Disco d = carrito[i];
                if (d == null) {
                    break;
                }else{
                    ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(carpetaMiMusica+d.getTitulo()));
                    oos1.writeObject(disco[i]);
                    oos.close();
                }
            }

            this.carrito = new Disco[disco.length];
            addPanel();
            initDisco();
            
            cl4.close();
            cl5.close();

        } catch (SocketException se) {
            System.out.println(se);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private void addPanel() {
        int numCarrito = 0;
        int numDisco = disco.length;
        for (; (numCarrito < numDisco && carrito[numCarrito] != null); numCarrito++);
        System.out.println("Elem num  car: " + numCarrito);
        if (numCarrito != 0) {

            jPanel9 = new javax.swing.JPanel[numCarrito];
            jLabel21 = new javax.swing.JLabel[numCarrito];
            jLabel22 = new javax.swing.JLabel[numCarrito];
            jLabel23 = new javax.swing.JLabel[numCarrito];
            jLabel24 = new javax.swing.JLabel[numCarrito];
            jLabel25 = new javax.swing.JLabel[numCarrito];
            jLabel26 = new javax.swing.JLabel[numCarrito];
            jLabel29 = new javax.swing.JLabel[numCarrito];
            jLabel30 = new javax.swing.JLabel[numCarrito];
            jLabel33 = new javax.swing.JLabel[numCarrito];
            jLabel34 = new javax.swing.JLabel[numCarrito];
            jLabel35 = new javax.swing.JLabel[numCarrito];
            jLabel36 = new javax.swing.JLabel[numCarrito];
            jLabel5 = new javax.swing.JLabel[numCarrito];
            jButton3 = new javax.swing.JButton[numCarrito];

        }
        java.awt.GridBagConstraints gridBagConstraints;

        gridBagConstraints = new java.awt.GridBagConstraints();
        panelElementos.removeAll();
        scroll2.removeAll();
        panelElementos.setLayout(new java.awt.GridLayout(numCarrito, 1, 5, 5));
        panelCarrito.removeAll();
        panelElementos.setAutoscrolls(true);

        for (int i = 0; i < numCarrito; i++) {
            jPanel9[i] = new javax.swing.JPanel();
            jLabel21[i] = new javax.swing.JLabel();
            jLabel22[i] = new javax.swing.JLabel();
            jLabel23[i] = new javax.swing.JLabel();
            jLabel24[i] = new javax.swing.JLabel();
            jLabel25[i] = new javax.swing.JLabel();
            jLabel26[i] = new javax.swing.JLabel();
            jLabel29[i] = new javax.swing.JLabel();
            jLabel30[i] = new javax.swing.JLabel();
            jLabel33[i] = new javax.swing.JLabel();
            jLabel34[i] = new javax.swing.JLabel();
            jLabel35[i] = new javax.swing.JLabel();
            jLabel36[i] = new javax.swing.JLabel();
            jLabel5[i] = new javax.swing.JLabel();
            jButton3[i] = new javax.swing.JButton();

            java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();

            jPanel9[i].setBackground(new java.awt.Color(255, 102, 102));
            jPanel9[i].setBorder(new javax.swing.border.MatteBorder(null));

            jPanel5Layout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            jPanel5Layout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
            jPanel5Layout.columnWeights = new double[]{0.0};
            jPanel5Layout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
            jPanel9[i].setLayout(jPanel5Layout);

            jLabel21[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel21[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel21[i].setText("Artista/Grupo:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            jPanel9[i].add(jLabel21[i], gridBagConstraints);

            jLabel35[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel35[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel35[i].setText("Album:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            jPanel9[i].add(jLabel35[i], gridBagConstraints);

            jLabel22[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel22[i].setText("Genero:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            jPanel9[i].add(jLabel22[i], gridBagConstraints);

            jLabel25[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel25[i].setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel25[i].setText("Precio:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = 0;
            jPanel9[i].add(jLabel25[i], gridBagConstraints);

            jLabel33[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel33[i].setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel33[i].setText("Cantidad:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 0;
            jPanel9[i].add(jLabel33[i], gridBagConstraints);

            jLabel23[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel23[i].setText(carrito[i].getArtista());
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            jPanel9[i].add(jLabel23[i], gridBagConstraints);

            jLabel36[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel36[i].setText(carrito[i].getTitulo());
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            jPanel9[i].add(jLabel36[i], gridBagConstraints);

            jLabel24[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel24[i].setText(carrito[i].getGenero());
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 1;
            jPanel9[i].add(jLabel24[i], gridBagConstraints);

            jLabel26[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel26[i].setText(String.valueOf(carrito[i].getPrecio()));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = 1;
            jPanel9[i].add(jLabel26[i], gridBagConstraints);

            jLabel34[i].setForeground(new java.awt.Color(255, 255, 255));
            jLabel34[i].setText(String.valueOf(carrito[i].getCantidad()));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 1;
            jPanel9[i].add(jLabel34[i], gridBagConstraints);

            jButton3[i].setText("Quitar");
            final int n = i;
            jButton3[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt, carrito[n].getTitulo());
                }
            });

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 6;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.gridheight = 2;
            jPanel9[i].add(jButton3[i], gridBagConstraints);

            String path = "imagec\\" + carrito[i].getNombreImagen();
            URL url = this.getClass().getResource(path);
            ImageIcon icon = new ImageIcon(url);
            jLabel5[i].setIcon(icon);
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.gridheight = 2;
            jPanel9[i].add(jLabel5[i], new java.awt.GridBagConstraints());
            panelElementos.add(jPanel9[i]);
        }
        //panelElementos.repaint();
        scroll2 = new javax.swing.JScrollPane(panelElementos);
        panelBoton.add(botonComprar);
        panelCarrito.setLayout(new java.awt.BorderLayout());
        panelCarrito.add(scroll2);
        panelCarrito.add(panelBoton, java.awt.BorderLayout.SOUTH);
        panelCarrito.updateUI();
        panelCarrito.repaint();
    }

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton [] jButton2;
	private javax.swing.JButton [] jButton3;
	private javax.swing.JButton botonComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel [] jLabel10;
    private javax.swing.JLabel [] jLabel11;
    private javax.swing.JLabel [] jLabel12;
    private javax.swing.JLabel [] jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel [] jLabel21;
    private javax.swing.JLabel [] jLabel22;
    private javax.swing.JLabel [] jLabel23;
    private javax.swing.JLabel [] jLabel24;
    private javax.swing.JLabel [] jLabel25;
    private javax.swing.JLabel [] jLabel26;
	private javax.swing.JLabel [] jLabel29;
	private javax.swing.JLabel [] jLabel30;
    private javax.swing.JLabel [] jLabel3;
    private javax.swing.JLabel [] jLabel5;
    private javax.swing.JLabel [] jLabel8;
    private javax.swing.JLabel [] jLabel9;
	private javax.swing.JLabel [] jLabel27;
	private javax.swing.JLabel [] jLabel28;
	private javax.swing.JLabel [] jLabel31;
	private javax.swing.JLabel [] jLabel32;
	private javax.swing.JLabel [] jLabel33;
	private javax.swing.JLabel [] jLabel34;
	private javax.swing.JLabel [] jLabel35;
	private javax.swing.JLabel [] jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel [] jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel [] jPanel9;
	private javax.swing.JPanel panelBoton;
	private javax.swing.JPanel panelCarrito;
	private javax.swing.JPanel panelElementos;
    private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JScrollPane scroll2;
	private Disco [] disco;
	private Disco [] carrito;
    // End of variables declaration//GEN-END:variables
}
