/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PcComponentInfo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author thebender
 */
public class PcComponentInfo extends javax.swing.JPanel {

    boolean visible;
    int componentType;
    
    /**
     * Creates new form PcComponentInfo
     */
    public PcComponentInfo() {
        initComponents();

        this.visible = true;
        this.jTextArea1.setLineWrap(true);
        this.jScrollPane1.getVerticalScrollBar().setValue(0);
        
        //Required for prize internationalitation
        this.setProductPrize(Double.parseDouble(this.jLabel3.getText()));
    }
    
    public void setProductName(String name) {
        this.jLabel2.setText(name);
    }
    
    public void setProductPrize(double prize) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        this.jLabel3.setText(currency.format(prize));
    }
    
    public void setRecomendationVisibility(boolean visible){
        this.visible = visible;
        this.jLabel4.setVisible(visible);
    }
    
    public void setProductImage(ImageIcon image){
        this.jLabel1.setIcon(image);
    }
    
    public void setComponentType(int type){
        this.componentType = type;
    }
    
    public void setComponentDescription(String description) {
        this.jTextArea1.setText(description);
        this.jTextArea1.setLineWrap(true);
    }

    public String getProductName(){
        return this.jLabel2.getText();
    }
    
    public double getProductPrize(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Number prize = 0;
        
        try {
            prize = currency.parse(this.jLabel3.getText());
        } catch (ParseException ex) {
            Logger.getLogger(PcComponentInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (double) prize;
    }
    
    public boolean getRecomendationVisibility(){
        return this.visible;
    }
    
    public Icon getProductImage(){
        return this.jLabel1.getIcon();
    }
    
    public int getComponentType(){
        return this.componentType;
    }
    
    public String getComponentDescription() {
        return this.jTextArea1.getText();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();

        setBackground(java.awt.Color.white);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        jLabel5.setText("Descripción");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 182, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PcComponentInfo/Images/StarIcon.png"))); // NOI18N
        jLabel4.setText("Recomendado");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        jLabel3.setText("0.00");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel2.setText("Componente");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PcComponentInfo/Images/questionMarkIcon.png"))); // NOI18N

        jTextArea1.setBackground(java.awt.Color.white);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("-Disipación del calor óptima meidate 3 tubos de calor de contacto directos. \n-Opción para añadir un segundo ventilador con soportes Quick-Snap para aumentar el -rendimiento de refrigeración.\n-Ventilador de 92mm. termoregulado y velocidad moderada. \n-Refrigerador de CPU silenciosa: 17dBA (en velocidad mínima). \n-Sistema sencillo para cambiar el ventilador mediante clips.\n\nCARACTERÍSTICAS:\n-Heatpipes de cobre de alto rendimiento con una mecha unida por fusión polvo de cobre.\n-La tecnología patentada CDC ™ - 4 heatpipes de contacto directo que crean una superficie de contacto brecha-menos\n-Matriz de aluminio de la aleta con el diseño Nueva efecto túnel para mejorar la disipación de calor.\n-Teniendo 4ta generación - MTBF de 160.000 horas gracias a componentes altamente duraderos POM.\n-Nuevo diseño de Fan-cuchillas que crean vórtices para aumentar el flujo de aire sin crear más ruido.\n-Inteligente del motor del ventilador - el ventilador se detiene cuando se bloquea para evitar el daño, y se reinicia automáticamente el ventilador cuando se haya despejado.\n-El sistema de montaje universal para todas las plataformas Intel y AMD.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea1.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
