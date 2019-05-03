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
        
        //Set the default recomendation visibility
        this.setRecomendationVisibility(false);
        this.recomendedVisibility = false;
        
        //Required for prize internationalitation
        this.setProductPrize(Double.parseDouble(this.jLabel3.getText()));
        
        //Required for drag and drop operation (No listener set)
        this.setTransferHandler(new DragPcComponent());
    }
    //Determines if DnD is allowed
    private static boolean activeDnD = true;
    
    private boolean recomendedVisibility;
    private int componentType;
    
    //Necesary for pcInfo
    private String description;
    private String bigImagePath;
    
    private MouseClickedEventListener listener;
  
    //Set a listener to the mouse clicked event
    public void setMouseClickedEventListener (MouseClickedEventListener listener) {
        this.listener = listener;
    }
    
    //Set a listener to the drag event
    public void setDragEventListener(DragEventListener listener){
        DragPcComponent dragAndDrop = (DragPcComponent) this.getTransferHandler();
        dragAndDrop.setDragEventListener(listener);
    }
    
    public void setProductName(String name){
        this.jTextArea1.setText(name);
    }
    
    public void setProductPrize(double prize){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        this.jLabel3.setText(currency.format(prize));
    }
    
    public void setRecomendationVisibility(boolean visible){
        this.recomendedVisibility = visible;
        this.jLabel5.setVisible(visible);
    }
    
    public void setProductImage(ImageIcon image){
        this.jLabel1.setIcon(image);
    }
    
    public void setComponentType(int type){
        this.componentType = type;
    }
    
    public void setProductDescription(String description){
        this.description = description;
    }
    
    public void setProductBigImagePath(String bigImagePath){
        this.bigImagePath = bigImagePath;
    }

    public static void setActiveDnD(boolean activeDnD) {
        PcComponent.activeDnD = activeDnD;
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
        return this.recomendedVisibility;
    }
    
    public Icon getProductImage(){
        return this.jLabel1.getIcon();
    }
    
    public int getComponentType(){
        return this.componentType;
    }

    public String getProductDescription() {
        return description;
    }

    public String getProductBigImagePath() {
        return bigImagePath;
    }

    public static boolean isActiveDnD() {
        return activeDnD;
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
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
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
        jTextArea1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTextArea1MouseDragged(evt);
            }
        });
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });

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

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
        //Throw the mouse clicked move event if listener is set
        if (this.listener != null) this.listener.onMouseClickedEvent(this);
    }//GEN-LAST:event_jTextArea1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //Throw the mouse clicked move event if listener is set
        if (this.listener != null) this.listener.onMouseClickedEvent(this);
    }//GEN-LAST:event_formMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(PcComponent.isActiveDnD()){
            TransferHandler handler = this.getTransferHandler();
            handler.exportAsDrag(this, evt, TransferHandler.MOVE);
        }
    }//GEN-LAST:event_formMouseDragged

    private void jTextArea1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseDragged
        if(PcComponent.isActiveDnD()){
            TransferHandler handler = this.getTransferHandler();
            handler.exportAsDrag(this, evt, TransferHandler.MOVE);
        }
    }//GEN-LAST:event_jTextArea1MouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
