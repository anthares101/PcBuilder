/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPage;

import Builder.Builder;
import PcComponentInfo.PcComponentInfo;
import componentsInfo.CPU;
import componentsInfo.ComponentReader;
import componentsInfo.Cooler;
import componentsInfo.GPU;
import componentsInfo.HardDisk;
import componentsInfo.Motherboard;
import componentsInfo.PSU;
import componentsInfo.PcBox;
import componentsInfo.RAM;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author anthares101
 */
public class mainPage extends javax.swing.JFrame implements PcComponent.DnDMoveEventListener {
    
    private int tabSelected;
    
    /**
     * Creates new form mainPage
     */
    public mainPage() {
        initComponents();
        
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane3.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane4.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane5.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane6.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane7.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane8.getVerticalScrollBar().setUnitIncrement(16);
        
        this.principal.add(new Builder());
        
        //Save the tab selected, necesary later
        this.tabSelected = components.getSelectedIndex();
    }
    
    //Action performed when the DnD move event happens
    @Override
    public void onDnDMoveEvent(Container panel){
        //Fix the last element constraints
        if(panel.getComponentCount() > 0){
            PcComponent.PcComponent pcComponentEdit = (PcComponent.PcComponent) panel.getComponent(panel.getComponentCount() - 1);
            //Delete last element
            panel.remove(pcComponentEdit);
            
            //Set constraints
            GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 1;
            gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new Insets (0,0,0,0);
            
            //Re-add last element
            panel.add(pcComponentEdit, gridBagConstraints);
        }
        
        //Reload the container
        container.revalidate();
        container.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        components = new javax.swing.JTabbedPane();
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
        information = new javax.swing.JPanel();
        principal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        container.setPreferredSize(new java.awt.Dimension(1337, 906));
        container.setLayout(new java.awt.BorderLayout());

        components.setBorder(null);
        components.setMaximumSize(new java.awt.Dimension(535, 756));
        components.setMinimumSize(new java.awt.Dimension(535, 756));
        components.setPreferredSize(new java.awt.Dimension(535, 756));
        components.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                componentsStateChanged(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(jPanel1);

        jPanel1.setBorder(null);
        jPanel1.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jPanel1);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("mainPage/Bundle"); // NOI18N
        components.addTab(bundle.getString("TAB1"), jScrollPane1); // NOI18N

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportView(jPanel2);

        jPanel2.setBorder(null);
        jPanel2.setLayout(new java.awt.GridBagLayout());
        jScrollPane2.setViewportView(jPanel2);

        components.addTab(bundle.getString("TAB2"), jScrollPane2); // NOI18N

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setViewportView(jPanel3);

        jPanel3.setBorder(null);
        jPanel3.setLayout(new java.awt.GridBagLayout());
        jScrollPane3.setViewportView(jPanel3);

        components.addTab(bundle.getString("TAB3"), jScrollPane3); // NOI18N

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setViewportView(jPanel4);

        jPanel4.setBorder(null);
        jPanel4.setLayout(new java.awt.GridBagLayout());
        jScrollPane4.setViewportView(jPanel4);

        components.addTab(bundle.getString("TAB4"), jScrollPane4); // NOI18N

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setViewportView(jPanel5);

        jPanel5.setBorder(null);
        jPanel5.setLayout(new java.awt.GridBagLayout());
        jScrollPane5.setViewportView(jPanel5);

        components.addTab(bundle.getString("TAB5"), jScrollPane5); // NOI18N

        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setViewportView(jPanel6);

        jPanel6.setBorder(null);
        jPanel6.setLayout(new java.awt.GridBagLayout());
        jScrollPane6.setViewportView(jPanel6);

        components.addTab(bundle.getString("TAB6"), jScrollPane6); // NOI18N

        jScrollPane7.setBorder(null);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setViewportView(jPanel7);

        jPanel7.setBorder(null);
        jPanel7.setLayout(new java.awt.GridBagLayout());
        jScrollPane7.setViewportView(jPanel7);

        components.addTab(bundle.getString("TAB7"), jScrollPane7); // NOI18N

        jScrollPane8.setBorder(null);
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setViewportView(jPanel8);

        jPanel8.setBorder(null);
        jPanel8.setLayout(new java.awt.GridBagLayout());
        jScrollPane8.setViewportView(jPanel8);

        components.addTab(bundle.getString("TAB8"), jScrollPane8); // NOI18N

        container.add(components, java.awt.BorderLayout.LINE_END);

        information.setBorder(null);
        information.setPreferredSize(new java.awt.Dimension(1337, 150));

        javax.swing.GroupLayout informationLayout = new javax.swing.GroupLayout(information);
        information.setLayout(informationLayout);
        informationLayout.setHorizontalGroup(
            informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1337, Short.MAX_VALUE)
        );
        informationLayout.setVerticalGroup(
            informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        container.add(information, java.awt.BorderLayout.PAGE_END);

        principal.setBorder(null);
        principal.setLayout(new java.awt.BorderLayout());
        container.add(principal, java.awt.BorderLayout.CENTER);

        getContentPane().add(container, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void componentsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_componentsStateChanged
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
        tabSelected = components.getSelectedIndex();

        //Read all the components from the database according with the tab index
        ArrayList componentList = new ArrayList();
        try {
            switch(components.getSelectedIndex()){
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
        String desc = new String();
        String path = new String();

        for(int i = 0; i < componentList.size(); i++){
            //If it is the last element...
            if(i == componentList.size() -1){
                gridBagConstraints.weightx = 1;
                gridBagConstraints.weighty = 1;
                gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
                gridBagConstraints.insets = new Insets (0,0,0,0);
            }
            
            pcComponent = new PcComponent.PcComponent();

            //Set a listener for DnD move event
            pcComponent.setDnDMoveEventListener(this);
            
            //Set the information read from the database in the component
            switch(components.getSelectedIndex()){
                case 0:
                    PcBox pcBox = (PcBox) componentList.get(i);

                    pcComponent.setComponentType(0);
                    pcComponent.setProductName(pcBox.getName());
                    pcComponent.setProductPrize(pcBox.getPrize());
                    path = "DataBases/PCBoxes_images/" + pcBox.getName();
                    pcComponent.setProductImage(new ImageIcon(path + "_142x141.jpg"));
                    desc = pcBox.getDescription();

                    //Add the GPU to the list
                    jPanel1.add(pcComponent, gridBagConstraints);

                    break;
                case 1:
                    Motherboard motherboard = (Motherboard) componentList.get(i);

                    pcComponent.setComponentType(1);
                    pcComponent.setProductName(motherboard.getName());
                    pcComponent.setProductPrize(motherboard.getPrize());
                    path = "DataBases/Motherboards_images/" + motherboard.getName();
                    pcComponent.setProductImage(new ImageIcon(path + "_142x141.jpg"));
                    desc = motherboard.getDescription();   
                    
                    //Add the GPU to the list
                    jPanel2.add(pcComponent, gridBagConstraints);
                    
                    break;
                case 2:
                    CPU cpu = (CPU) componentList.get(i);

                    pcComponent.setComponentType(2);
                    pcComponent.setProductName(cpu.getName());
                    pcComponent.setProductPrize(cpu.getPrize());
                    path = "DataBases/CPUs_images/" + cpu.getName();
                    pcComponent.setProductImage(new ImageIcon(path + "_142x141.jpg"));
                    desc = cpu.getDescription();
                    
                    //Add the GPU to the list
                    jPanel3.add(pcComponent, gridBagConstraints);

                    break;
                case 3:
                    Cooler cooler = (Cooler) componentList.get(i);

                    pcComponent.setComponentType(3);
                    pcComponent.setProductName(cooler.getName());
                    pcComponent.setProductPrize(cooler.getPrize());
                    path = "DataBases/Coolers_images/" + cooler.getName();
                    pcComponent.setProductImage(new ImageIcon(path + "_142x141.jpg"));
                    desc = cooler.getDescription();

                    //Add the GPU to the list
                    jPanel4.add(pcComponent, gridBagConstraints);

                    break;
                case 4:
                    RAM ram = (RAM) componentList.get(i);

                    pcComponent.setComponentType(4);
                    pcComponent.setProductName(ram.getName());
                    pcComponent.setProductPrize(ram.getPrize());
                    path = "DataBases/RAMs_images/" + ram.getName();
                    pcComponent.setProductImage(new ImageIcon(path + "_142x141.jpg"));
                    desc = ram.getDescription();

                    //Add the GPU to the list
                    jPanel5.add(pcComponent, gridBagConstraints);

                    break;
                case 5:
                    GPU gpu = (GPU) componentList.get(i);

                    pcComponent.setComponentType(5);
                    pcComponent.setProductName(gpu.getName());
                    pcComponent.setProductPrize(gpu.getPrize());
                    path = "DataBases/GPUs_images/" + gpu.getName();
                    pcComponent.setProductImage(new ImageIcon(path + "_142x141.jpg"));
                    desc = gpu.getDescription();

                    //Add the GPU to the list
                    jPanel6.add(pcComponent, gridBagConstraints);

                    break;
                case 6:
                    HardDisk hardDisk = (HardDisk) componentList.get(i);

                    pcComponent.setComponentType(6);
                    pcComponent.setProductName(hardDisk.getName());
                    pcComponent.setProductPrize(hardDisk.getPrize());
                    path = "DataBases/HardDisks_images/" + hardDisk.getName();
                    pcComponent.setProductImage(new ImageIcon(path + "_142x141.jpg"));
                    desc = hardDisk.getDescription();

                    //Add the GPU to the list
                    jPanel7.add(pcComponent, gridBagConstraints);

                    break;
                case 7:
                    PSU psu = (PSU) componentList.get(i);

                    pcComponent.setComponentType(7);
                    pcComponent.setProductName(psu.getName());
                    pcComponent.setProductPrize(psu.getPrize());
                    path = "DataBases/PSU_images/" + psu.getName();
                    pcComponent.setProductImage(new ImageIcon(path + "_142x141.jpg"));
                    desc = psu.getDescription();
                    
                    //Add the GPU to the list
                    jPanel8.add(pcComponent, gridBagConstraints);

                    break;
            }
            
            final String name = pcComponent.getProductName();
            final Double prize = pcComponent.getProductPrize();
            final Boolean visibility = pcComponent.getRecomendationVisibility();
            final String description = desc;
            final String iconPath = path;
            
            //Set a listenner for
            pcComponent.addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent me) {

                    if(principal.getComponentCount() > 1) {
                        principal.remove(principal.getComponentCount()-1);
                    }

                    PcComponentInfo pcInfo = new PcComponentInfo();
                    pcInfo.setProductName(name);
                    pcInfo.setProductPrize(prize);
                    pcInfo.setRecomendationVisibility(visibility);
                    pcInfo.setProductImage(new ImageIcon(iconPath + "_230x229.jpg"));
                    pcInfo.setComponentDescription(description);
                    
                    principal.add(pcInfo);
                    principal.revalidate();
                    principal.repaint();
                } 
            });
        }
    }//GEN-LAST:event_componentsStateChanged

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
    private javax.swing.JTabbedPane components;
    private javax.swing.JPanel container;
    private javax.swing.JPanel information;
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
    private javax.swing.JPanel principal;
    // End of variables declaration//GEN-END:variables
}
