/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PcComponent;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.TransferHandler;

/**
 *
 * @author anthares101
 */
public class PcComponent extends javax.swing.JPanel {

    /**
     * Creates new form PcComponent
     */
    public PcComponent() {
        initComponents();
        
        this.visible = true;
        
        //Required for prize internationalitation
        this.setProductPrize(Double.parseDouble(this.jLabel3.getText()));
        
        //Required for drag and drop operation
        this.setTransferHandler(new DragAndDrop());
    }
    
    private boolean visible;
    private int componentType;
    
    public void setProductName(String name){
        this.jTextArea1.setText(name);
    }
    
    public void setProductPrize(double prize){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        this.jLabel3.setText(currency.format(prize));
    }
    
    public void setRecomendationVisibility(boolean visible){
        this.visible = visible;
        this.jLabel5.setVisible(visible);
    }
    
    public void setProductImage(ImageIcon image){
        this.jLabel1.setIcon(image);
    }
    
    public void setComponentType(int type){
        this.componentType = type;
    }
    
    public String getProductName(){
        return this.jTextArea1.getText();
    }
    
    public double getProductPrize(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Number prize = 0;
                
        try {
            prize = currency.parse(this.jLabel3.getText());
        } catch (ParseException ex) {
            Logger.getLogger(PcComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prize.doubleValue();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();

        setBackground(java.awt.Color.white);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PcComponent/Image/questionMarkIcon.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 30)); // NOI18N
        jLabel3.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 182, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PcComponent/Image/StarIcon.png"))); // NOI18N
        jLabel5.setText("Recomendado");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(java.awt.Color.white);
        jTextArea1.setColumns(15);
        jTextArea1.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Componente");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea1.setCaretColor(java.awt.Color.white);
        jTextArea1.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addComponent(jTextArea1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        TransferHandler handler = this.getTransferHandler();
        handler.exportAsDrag(this, evt, TransferHandler.COPY);
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
