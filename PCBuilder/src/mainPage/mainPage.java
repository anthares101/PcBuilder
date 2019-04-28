/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPage;

import componentsInfo.CPU;
import componentsInfo.ComponentReader;
import componentsInfo.Cooler;
import componentsInfo.GPU;
import componentsInfo.HardDisk;
import componentsInfo.Motherboard;
import componentsInfo.PSU;
import componentsInfo.PcBox;
import componentsInfo.RAM;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author anthares101
 */
public class mainPage extends javax.swing.JFrame {
    
    private int tabSelected;
    
    /**
     * Creates new form mainPage
     */
    public mainPage() {
        initComponents();
        
        //Safe the tab selected, necesary later
        this.tabSelected = jTabbedPane1.getSelectedIndex();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(535, 700));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(535, 700));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(535, 700));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jScrollPane1.setViewportView(jPanel1);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jPanel1);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("mainPage/Bundle"); // NOI18N
        jTabbedPane1.addTab(bundle.getString("TAB1"), jScrollPane1); // NOI18N

        jPanel2.setLayout(new java.awt.GridBagLayout());
        jScrollPane2.setViewportView(jPanel2);

        jTabbedPane1.addTab(bundle.getString("TAB2"), jScrollPane2); // NOI18N

        jPanel3.setLayout(new java.awt.GridBagLayout());
        jScrollPane3.setViewportView(jPanel3);

        jTabbedPane1.addTab(bundle.getString("TAB3"), jScrollPane3); // NOI18N

        jPanel4.setLayout(new java.awt.GridBagLayout());
        jScrollPane4.setViewportView(jPanel4);

        jTabbedPane1.addTab(bundle.getString("TAB4"), jScrollPane4); // NOI18N

        jPanel5.setLayout(new java.awt.GridBagLayout());
        jScrollPane5.setViewportView(jPanel5);

        jTabbedPane1.addTab(bundle.getString("TAB5"), jScrollPane5); // NOI18N

        jPanel6.setLayout(new java.awt.GridBagLayout());
        jScrollPane6.setViewportView(jPanel6);

        jTabbedPane1.addTab(bundle.getString("TAB6"), jScrollPane6); // NOI18N

        jPanel7.setLayout(new java.awt.GridBagLayout());
        jScrollPane7.setViewportView(jPanel7);

        jTabbedPane1.addTab(bundle.getString("TAB7"), jScrollPane7); // NOI18N

        jPanel8.setLayout(new java.awt.GridBagLayout());
        jScrollPane8.setViewportView(jPanel8);

        jTabbedPane1.addTab(bundle.getString("TAB8"), jScrollPane8); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(792, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        //Clear the last selected tab for performance improvemment
        switch(this.tabSelected){
            case 0:
                jPanel1.removeAll();
                break;
            case 1:
                jPanel2.removeAll();
                break;
            case 2:
                jPanel3.removeAll();
                break;
            case 3:
                jPanel4.removeAll();
                break;
            case 4:
                jPanel5.removeAll();
                break;
            case 5:
                jPanel6.removeAll();
                break;
            case 6:
                jPanel7.removeAll();
                break;
            case 7:
                jPanel8.removeAll();
                break; 
        }
        
        //Safe the new selected tab
        tabSelected = jTabbedPane1.getSelectedIndex();

        //Read all the components from the database according with the tab index
        ArrayList componentList = new ArrayList();
        try {
            switch(jTabbedPane1.getSelectedIndex()){
                case 0:
                    componentList = ComponentReader.readPcBox();
                    break;
                case 1:
                    componentList = ComponentReader.readMotherboards();
                    break;
                case 2:
                    componentList = ComponentReader.readCPUs();
                    break;
                case 3:
                    componentList = ComponentReader.readCoolers();
                    break;
                case 4:
                    componentList = ComponentReader.readRAMs();
                    break;
                case 5:
                    componentList = ComponentReader.readGPUs();
                    break;
                case 6:
                    componentList = ComponentReader.readDisks();
                    break;
                case 7:
                    componentList = ComponentReader.readPSUs();
                    break;
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(mainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Rule to put the component bellow that last component added
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets (0,0,5,0);

        //Add all the GPUs to the list according to gridBagConstraints
        componentsInfo.PcComponent component = new componentsInfo.PcComponent();
        PcComponent.PcComponent pcComponent;

        for(int i = 0; i < componentList.size(); i++){
            //If it is the last element...
            if(i == componentList.size() -1){
                gridBagConstraints.weightx = 1;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
                gridBagConstraints.insets = new Insets (0,0,0,0);
            }

            //Set the information read from the database in the component
            pcComponent = new PcComponent.PcComponent();
            switch(jTabbedPane1.getSelectedIndex()){
                case 0:
                    PcBox pcBox = (PcBox) componentList.get(i);

                    pcComponent.setProductName(pcBox.getName());
                    pcComponent.setProductPrize(pcBox.getPrize());
                    pcComponent.setProductImage(new ImageIcon("DataBases/PCBoxes_images/" + pcBox.getName() + "_142x141.jpg"));

                    //Add the GPU to the list
                    jPanel1.add(pcComponent, gridBagConstraints);

                    break;
                case 1:
                    Motherboard motherboard = (Motherboard) componentList.get(i);

                    pcComponent.setProductName(motherboard.getName());
                    pcComponent.setProductPrize(motherboard.getPrize());
                    pcComponent.setProductImage(new ImageIcon("DataBases/Motherboards_images/" + motherboard.getName() + "_142x141.jpg"));   
                    
                    //Add the GPU to the list
                    jPanel2.add(pcComponent, gridBagConstraints);
                    
                    break;
                case 2:
                    CPU cpu = (CPU) componentList.get(i);

                    pcComponent.setProductName(cpu.getName());
                    pcComponent.setProductPrize(cpu.getPrize());
                    pcComponent.setProductImage(new ImageIcon("DataBases/CPUs_images/" + cpu.getName() + "_142x141.jpg"));
                    
                    //Add the GPU to the list
                    jPanel3.add(pcComponent, gridBagConstraints);

                    break;
                case 3:
                    Cooler cooler = (Cooler) componentList.get(i);

                    pcComponent.setProductName(cooler.getName());
                    pcComponent.setProductPrize(cooler.getPrize());
                    pcComponent.setProductImage(new ImageIcon("DataBases/Coolers_images/" + cooler.getName() + "_142x141.jpg"));

                    //Add the GPU to the list
                    jPanel4.add(pcComponent, gridBagConstraints);

                    break;
                case 4:
                    RAM ram = (RAM) componentList.get(i);

                    pcComponent.setProductName(ram.getName());
                    pcComponent.setProductPrize(ram.getPrize());
                    pcComponent.setProductImage(new ImageIcon("DataBases/RAMs_images/" + ram.getName() + "_142x141.jpg"));

                    //Add the GPU to the list
                    jPanel5.add(pcComponent, gridBagConstraints);

                    break;
                case 5:
                    GPU gpu = (GPU) componentList.get(i);

                    pcComponent.setProductName(gpu.getName());
                    pcComponent.setProductPrize(gpu.getPrize());
                    pcComponent.setProductImage(new ImageIcon("DataBases/GPUs_images/" + gpu.getName() + "_142x141.jpg"));

                    //Add the GPU to the list
                    jPanel6.add(pcComponent, gridBagConstraints);

                    break;
                case 6:
                    HardDisk hardDisk = (HardDisk) componentList.get(i);

                    pcComponent.setProductName(hardDisk.getName());
                    pcComponent.setProductPrize(hardDisk.getPrize());
                    pcComponent.setProductImage(new ImageIcon("DataBases/HardDisks_images/" + hardDisk.getName() + "_142x141.jpg"));

                    //Add the GPU to the list
                    jPanel7.add(pcComponent, gridBagConstraints);

                    break;
                case 7:
                    PSU psu = (PSU) componentList.get(i);

                    pcComponent.setProductName(psu.getName());
                    pcComponent.setProductPrize(psu.getPrize());
                    pcComponent.setProductImage(new ImageIcon("DataBases/PSU_images/" + psu.getName() + "_142x141.jpg"));

                    //Add the GPU to the list
                    jPanel8.add(pcComponent, gridBagConstraints);

                    break;
            }
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

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
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainPage page = new mainPage();
                page.setVisible(true);
                page.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
