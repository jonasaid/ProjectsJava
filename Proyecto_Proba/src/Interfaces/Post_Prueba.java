package Interfaces;
import javax.swing.JOptionPane;


public class Post_Prueba extends javax.swing.JFrame {
    
    double sensibilidad, especificidad, prePrueba=0.2, probabilidadPostPMenos, probabilidadPostPMas; 
    static final double ESTA_VACUNADO = -0.1, CERCNIA_INFECTADO = 0.25, TIENE_SINTOMAS = 0.35, TIENE_COMORBILIDAD = 0.2; 
    
    double calcularLRMenos(){
        return redondearADosDecimales(redondearADosDecimales(1-sensibilidad)/especificidad);
    }
    
    double calcularLRMas(){
        return redondearADosDecimales(sensibilidad/redondearADosDecimales(1-especificidad));
    }
    
    void calcularProbabilidadesPost(){
        sensibilidad = (Double.parseDouble(cuadroSensibilidad.getText()))/100;
        sensibilidad = redondearADosDecimales(sensibilidad);
        if (sensibilidad <= 0) {
            sensibilidad = 0.01;
        }else if (sensibilidad >=1) {
            sensibilidad = 0.99;
        }
        especificidad = (Double.parseDouble(cuadroEspecificidad.getText()))/100;
        especificidad = redondearADosDecimales(especificidad);
        if (especificidad <= 0) {
            especificidad = 0.01;
        }else if (especificidad >=1) {
            especificidad = 0.99;
        }
        System.err.println("sensibilidad: "+ sensibilidad+ " especificidad: "+especificidad);
        double LRMas = calcularLRMas();
        double LRMenos = calcularLRMenos();
        //Obtener momios
        double momioPreP = redondearADosDecimales(prePrueba/redondearADosDecimales(1-prePrueba));
        System.out.println(momioPreP);
        double momioPostPMas = momioPreP*LRMas;
        double momioPostPMenos = momioPreP*LRMenos;
        System.err.println("Preprueba: "+ prePrueba+" momioPre: "+ momioPreP+ " LR+: "+LRMas+" LR-: "+LRMenos+" momio+: "+ momioPostPMas+ " momio-: "+ momioPostPMenos);
        //Convertir momios a probabilidades
        probabilidadPostPMas = momioPostPMas/redondearADosDecimales(1+momioPostPMas);
        probabilidadPostPMenos = momioPostPMenos/redondearADosDecimales(1+momioPostPMenos);
        System.out.println("probabilidadPostPMas: "+probabilidadPostPMas+" probabilidadPostPMenos: "+probabilidadPostPMenos);
        probabilidadPostPMas = redondearADosDecimales(probabilidadPostPMas*100);
        probabilidadPostPMenos  = redondearADosDecimales(probabilidadPostPMenos*100);
    }    
    
    void mostrarProbabilidadPrePrueba(){
        cuadroProbabilidadPreP.setText(Double.toString(redondearADosDecimales(prePrueba*100)));
    }
    
    public Post_Prueba(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cuadroProbabilidadPreP.setText("20.0");
        cuadroSensibilidad.setText("96.52");
        cuadroEspecificidad.setText("99.68");
        cajaVacunado.setSelected(true);
    }
    
    double redondearADosDecimales(double valorInicial) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, 2);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, 2))+parteEntera;
        return resultado;
    }
    
    void limitesInf_Sup(){
        if (prePrueba<0.1) {
            prePrueba=0.1;
        }
        if (prePrueba>.9) {
            prePrueba = .9;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cuadroSensibilidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cuadroEspecificidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        botonMostrarResultado = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        botonLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cajaSintomas = new javax.swing.JCheckBox();
        cajaContacto = new javax.swing.JCheckBox();
        cajaComorbilidad = new javax.swing.JCheckBox();
        cajaVacunado = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        cuadroProbabilidadPreP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        botonMenu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(101, 203, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(102, 51, 255)));

        jPanel2.setBackground(new java.awt.Color(153, 220, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CÁLCULO PROBABILIDAD POST PRUEBA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(153, 220, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        botonRegresar.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        botonRegresar.setForeground(new java.awt.Color(0, 51, 153));
        botonRegresar.setText("REGRESAR");
        botonRegresar.setContentAreaFilled(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));

        cuadroSensibilidad.setBackground(new java.awt.Color(153, 220, 255));
        cuadroSensibilidad.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        cuadroSensibilidad.setForeground(new java.awt.Color(153, 153, 153));
        cuadroSensibilidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuadroSensibilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cuadroSensibilidadMouseClicked(evt);
            }
        });
        cuadroSensibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroSensibilidadActionPerformed(evt);
            }
        });
        cuadroSensibilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cuadroSensibilidadKeyTyped(evt);
            }
        });

        jLabel8.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cuadroSensibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuadroSensibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));

        cuadroEspecificidad.setBackground(new java.awt.Color(153, 220, 255));
        cuadroEspecificidad.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        cuadroEspecificidad.setForeground(new java.awt.Color(153, 153, 153));
        cuadroEspecificidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuadroEspecificidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cuadroEspecificidadMouseClicked(evt);
            }
        });
        cuadroEspecificidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroEspecificidadActionPerformed(evt);
            }
        });
        cuadroEspecificidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cuadroEspecificidadKeyTyped(evt);
            }
        });

        jLabel10.setText("%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cuadroEspecificidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuadroEspecificidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)))
        );

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel4.setText("Sensibilidad de la prueba:");

        jPanel6.setBackground(new java.awt.Color(153, 220, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(255, 255, 255)));

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel2.setText("Instrucciones");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 13)); // NOI18N
        jLabel5.setText("Identifica los tópicos en los que los está tu situación para calcular la probabilidad pre prueba.");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 13)); // NOI18N
        jLabel6.setText("Luego ingresa la especificidad y sensibilidad de tu prueba.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(153, 220, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));

        botonMostrarResultado.setBackground(new java.awt.Color(255, 255, 255));
        botonMostrarResultado.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        botonMostrarResultado.setForeground(new java.awt.Color(0, 51, 153));
        botonMostrarResultado.setText("Imprimir Resultado");
        botonMostrarResultado.setContentAreaFilled(false);
        botonMostrarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarResultadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonMostrarResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonMostrarResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(153, 220, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        botonLimpiar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        botonLimpiar.setForeground(new java.awt.Color(0, 51, 153));
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setToolTipText("");
        botonLimpiar.setContentAreaFilled(false);
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel3.setText("Especificidad de la prueba:");

        cajaSintomas.setText("Tiene Síntomas");
        cajaSintomas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaSintomasMouseClicked(evt);
            }
        });
        cajaSintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaSintomasActionPerformed(evt);
            }
        });

        cajaContacto.setText("Ha tenido contacto con alguien infectado.");
        cajaContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaContactoMouseClicked(evt);
            }
        });
        cajaContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaContactoActionPerformed(evt);
            }
        });

        cajaComorbilidad.setText("Está en grupo de riesgo");
        cajaComorbilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaComorbilidadMouseClicked(evt);
            }
        });
        cajaComorbilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaComorbilidadActionPerformed(evt);
            }
        });

        cajaVacunado.setText("Está vacunado");
        cajaVacunado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaVacunadoMouseClicked(evt);
            }
        });
        cajaVacunado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaVacunadoActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));

        cuadroProbabilidadPreP.setBackground(new java.awt.Color(153, 220, 255));
        cuadroProbabilidadPreP.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        cuadroProbabilidadPreP.setForeground(new java.awt.Color(153, 153, 153));
        cuadroProbabilidadPreP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuadroProbabilidadPreP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cuadroProbabilidadPrePMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuadroProbabilidadPrePMousePressed(evt);
            }
        });
        cuadroProbabilidadPreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroProbabilidadPrePActionPerformed(evt);
            }
        });

        jLabel9.setText("%");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(cuadroProbabilidadPreP, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cuadroProbabilidadPreP)
                .addComponent(jLabel9))
        );

        jPanel15.setBackground(new java.awt.Color(153, 220, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));

        botonMenu.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        botonMenu.setForeground(new java.awt.Color(0, 51, 153));
        botonMenu.setText("MENÚ");
        botonMenu.setContentAreaFilled(false);
        botonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel11.setText("Probabilidad pre prueba:");

        jLabel7.setText("(Modificable)");

        jLabel13.setText("(Modificable)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                        .addComponent(jLabel13))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)))
                                .addGap(10, 10, 10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaSintomas)
                                    .addComponent(cajaVacunado))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaContacto)
                                    .addComponent(cajaComorbilidad)))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaSintomas)
                            .addComponent(cajaContacto))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaVacunado)
                            .addComponent(cajaComorbilidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Teorema_Bayes volver = new Teorema_Bayes();
        this.dispose();
        volver.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    boolean verificarDatos(){
        boolean valor=true;
        if(cuadroEspecificidad.getText() == null || cuadroEspecificidad.getText().isEmpty() || cuadroEspecificidad.getText().equals(" ")|| cuadroEspecificidad.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Introdujiste un valor que no es posible en la especificidad");
            valor=false;
        }else if (cuadroSensibilidad.getText() == null || cuadroSensibilidad.getText().isEmpty() || cuadroSensibilidad.getText().equals(" ")|| cuadroSensibilidad.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Introdujiste un valor que no es posible en la sensibilidad");
            valor=false;
        }else if(Double.parseDouble(cuadroSensibilidad.getText()) <= 0 || Double.parseDouble(cuadroSensibilidad.getText()) >= 100){
            JOptionPane.showMessageDialog(null, "Introdujiste un valor menor o igual a 0 \n ó mayor o igual a 100 en la sensibilidad");
            valor=false;
        }else if(Double.parseDouble(cuadroEspecificidad.getText()) <= 0 || Double.parseDouble(cuadroSensibilidad.getText()) >= 100){
            JOptionPane.showMessageDialog(null, "Introdujiste un valor menor o igual a 0 \n ó mayor o igual a 100 en la especificidad");
            valor=false;
        }
        return valor;
    }
    
    private void botonMostrarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarResultadoActionPerformed
        if (verificarDatos()){
            prePrueba = redondearADosDecimales(prePrueba);
            sensibilidad = redondearADosDecimales(sensibilidad);
            especificidad = redondearADosDecimales(especificidad);
            calcularProbabilidadesPost();
            System.out.println("probabilidadPostPMas: "+probabilidadPostPMas+" probabilidadPostPMenos: "+probabilidadPostPMenos);
            this.dispose();
            new Resultados_Post_Prueba(prePrueba*100,probabilidadPostPMas, probabilidadPostPMenos).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, modifica el o los errores");
        }
        
    }//GEN-LAST:event_botonMostrarResultadoActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        this.cuadroSensibilidad.setText("");
        this.cuadroEspecificidad.setText("");     
        cajaContacto.setSelected(false);
        cajaSintomas.setSelected(false);
        cajaVacunado.setSelected(false);
        cajaComorbilidad.setSelected(false);
        prePrueba = .1;
        mostrarProbabilidadPrePrueba();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void cajaSintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaSintomasActionPerformed
        if (cajaSintomas.isSelected()) {
            prePrueba = prePrueba + TIENE_SINTOMAS;
        }else{
            prePrueba = prePrueba - TIENE_SINTOMAS;
        }
        limitesInf_Sup();
        mostrarProbabilidadPrePrueba();
    }//GEN-LAST:event_cajaSintomasActionPerformed

    private void cajaContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaContactoActionPerformed
        if (cajaContacto.isSelected()) {
            prePrueba = prePrueba + CERCNIA_INFECTADO;
        }else{
            prePrueba = prePrueba - CERCNIA_INFECTADO;
        }
        limitesInf_Sup();
        mostrarProbabilidadPrePrueba();
    }//GEN-LAST:event_cajaContactoActionPerformed

    private void cajaVacunadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaVacunadoActionPerformed
        if (cajaVacunado.isSelected()) {
            prePrueba = prePrueba + ESTA_VACUNADO;
        }else{
            prePrueba = prePrueba - ESTA_VACUNADO;
        }
        limitesInf_Sup();
        mostrarProbabilidadPrePrueba();
    }//GEN-LAST:event_cajaVacunadoActionPerformed

    private void cajaComorbilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaComorbilidadActionPerformed
        if (cajaComorbilidad.isSelected()) {
            prePrueba = prePrueba + TIENE_COMORBILIDAD;            
        }else{
            prePrueba = prePrueba - TIENE_COMORBILIDAD;
        }
        limitesInf_Sup();
        mostrarProbabilidadPrePrueba();
    }//GEN-LAST:event_cajaComorbilidadActionPerformed

    private void botonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuActionPerformed
        Principal volver = new Principal();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonMenuActionPerformed

    private void cuadroSensibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroSensibilidadActionPerformed
        
    }//GEN-LAST:event_cuadroSensibilidadActionPerformed

    private void cuadroProbabilidadPrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroProbabilidadPrePActionPerformed
        
    }//GEN-LAST:event_cuadroProbabilidadPrePActionPerformed

    private void cuadroProbabilidadPrePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadroProbabilidadPrePMouseClicked
        JOptionPane.showMessageDialog(null, "No puedes modificar por tu cuenta esta entrada, por favor palomea las opciones proporcionadas");
    }//GEN-LAST:event_cuadroProbabilidadPrePMouseClicked

    private void cuadroProbabilidadPrePMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadroProbabilidadPrePMousePressed
        JOptionPane.showMessageDialog(null, "No puedes modificar por tu cuenta esta entrada, por favor palomea las opciones proporcionadas");
    }//GEN-LAST:event_cuadroProbabilidadPrePMousePressed

    private void cuadroSensibilidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuadroSensibilidadKeyTyped
        char caracterEscrito = evt.getKeyChar();
        if (((caracterEscrito < '0') || (caracterEscrito > '9')) && (caracterEscrito != '\b') && (caracterEscrito != '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros y el caracter '.'");
        }
        if(cuadroSensibilidad.getText().length() > 4){
            evt.consume();
        }
    }//GEN-LAST:event_cuadroSensibilidadKeyTyped

    private void cuadroEspecificidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroEspecificidadActionPerformed

    }//GEN-LAST:event_cuadroEspecificidadActionPerformed

    private void cajaSintomasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaSintomasMouseClicked
      
    }//GEN-LAST:event_cajaSintomasMouseClicked

    private void cuadroEspecificidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuadroEspecificidadKeyTyped
        char caracterEscrito = evt.getKeyChar();
        if (((caracterEscrito < '0') || (caracterEscrito > '9')) && (caracterEscrito != '\b') && (caracterEscrito != '.')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros y el caracter '.'");
        }
        if(cuadroEspecificidad.getText().length() > 4){
            evt.consume();
        }
    }//GEN-LAST:event_cuadroEspecificidadKeyTyped

    private void cajaContactoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaContactoMouseClicked

    }//GEN-LAST:event_cajaContactoMouseClicked

    private void cajaComorbilidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaComorbilidadMouseClicked
 
    }//GEN-LAST:event_cajaComorbilidadMouseClicked

    private void cajaVacunadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaVacunadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaVacunadoMouseClicked

    private void cuadroSensibilidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadroSensibilidadMouseClicked
        System.err.println(cuadroSensibilidad.getText());
    }//GEN-LAST:event_cuadroSensibilidadMouseClicked

    private void cuadroEspecificidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadroEspecificidadMouseClicked
        System.err.println(cuadroSensibilidad.getText());
    }//GEN-LAST:event_cuadroEspecificidadMouseClicked

    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Post_Prueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonMenu;
    private javax.swing.JButton botonMostrarResultado;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JCheckBox cajaComorbilidad;
    private javax.swing.JCheckBox cajaContacto;
    private javax.swing.JCheckBox cajaSintomas;
    private javax.swing.JCheckBox cajaVacunado;
    private javax.swing.JTextField cuadroEspecificidad;
    private javax.swing.JTextField cuadroProbabilidadPreP;
    private javax.swing.JTextField cuadroSensibilidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
