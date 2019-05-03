/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPage;

import Builder.Builder;
import Builder.ComponentDeleteEventListener;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author anthares101
 */
public class mainPage extends javax.swing.JFrame implements PcComponent.DragEventListener, PcComponent.MouseClickedEventListener, ComponentDeleteEventListener {
    
    /**
     * Creates new form mainPage
     */
    public mainPage() {
        super();
    }
    
    //Init the maninPage class (Avoid the 'Leaking this in constructor' warning)
    public void initMainPage(){
        initComponents();
        
        this.setTitle("PCBuilder");
        
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane3.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane4.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane5.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane6.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane7.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane8.getVerticalScrollBar().setUnitIncrement(16);
        
        this.finishBttn.setVisible(false);
        
        //Add Builder component and set the listener for the remove component event
        Builder builder = new Builder();
        builder.setComponentDeleteEventListener(this);
        this.principal.add(builder);
        
        this.prize.setText(builder.getTotalPrizeString());
    }
    
    //Action performed when a drag event happens (The argument in our case is not necesary)
    @Override
    public void onDragEvent(Container panel){
        this.componentsStateChanged(null);
        
        Builder builder = (Builder) this.principal.getComponent(0);
        this.prize.setText(builder.getTotalPrizeString());
       
        if(builder.isCompleted()) {
            this.finishBttn.setVisible(true);
        }
    }
    
    //Action performed when a mouse clicked event happens
    @Override
    public void onMouseClickedEvent(PcComponent.PcComponent pcComponent){
        if(principal.getComponentCount() > 1) {
            principal.remove(principal.getComponentCount()-1);
        }

        PcComponentInfo pcInfo = new PcComponentInfo();
        pcInfo.setProductName(pcComponent.getProductName());
        pcInfo.setProductPrize(pcComponent.getProductPrize());
        pcInfo.setRecomendationVisibility(pcComponent.getRecomendationVisibility());
        pcInfo.setProductImage(new ImageIcon(pcComponent.getProductBigImagePath()));
        pcInfo.setComponentDescription(pcComponent.getProductDescription());
        
        //Disable DnD when PcInfo is active
        PcComponent.PcComponent.setActiveDnD(false);
        principal.add(pcInfo);
        principal.revalidate();
        principal.repaint();
    }
    
    //Action performed when a remove component event happens (Update PcComponents tabs if necesary)
    @Override
    public void onComponentDeleteEvent(int type){
        if(this.components.getSelectedIndex() == type) {
            this.componentsStateChanged(null);
        }
        
        Builder builder = (Builder) this.principal.getComponent(0);
        this.prize.setText(builder.getTotalPrizeString());
        
        this.finishBttn.setVisible(false);
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
        finishBttn = new javax.swing.JButton();
        prize = new javax.swing.JLabel();
        principal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/mainPage/images/logo.png")).getImage()
        );
        setName("PCBuilder"); // NOI18N
        setResizable(false);

        container.setBackground(new java.awt.Color(255, 238, 224));
        container.setPreferredSize(new java.awt.Dimension(1337, 906));
        container.setLayout(new java.awt.BorderLayout());

        components.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 150, 86)));
        components.setMaximumSize(new java.awt.Dimension(535, 756));
        components.setMinimumSize(new java.awt.Dimension(535, 756));
        components.setPreferredSize(new java.awt.Dimension(535, 756));
        components.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                componentsStateChanged(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 251, 242));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(jPanel1);

        jPanel1.setBackground(new java.awt.Color(255, 238, 224));
        jPanel1.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jPanel1);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("mainPage/Bundle"); // NOI18N
        components.addTab(bundle.getString("TAB1"), jScrollPane1); // NOI18N

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportView(jPanel2);

        jPanel2.setBackground(new java.awt.Color(255, 238, 224));
        jPanel2.setLayout(new java.awt.GridBagLayout());
        jScrollPane2.setViewportView(jPanel2);

        components.addTab(bundle.getString("TAB2"), jScrollPane2); // NOI18N

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setViewportView(jPanel3);

        jPanel3.setBackground(new java.awt.Color(255, 238, 224));
        jPanel3.setLayout(new java.awt.GridBagLayout());
        jScrollPane3.setViewportView(jPanel3);

        components.addTab(bundle.getString("TAB3"), jScrollPane3); // NOI18N

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setViewportView(jPanel4);

        jPanel4.setBackground(new java.awt.Color(255, 238, 224));
        jPanel4.setLayout(new java.awt.GridBagLayout());
        jScrollPane4.setViewportView(jPanel4);

        components.addTab(bundle.getString("TAB4"), jScrollPane4); // NOI18N

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setViewportView(jPanel5);

        jPanel5.setBackground(new java.awt.Color(255, 238, 224));
        jPanel5.setLayout(new java.awt.GridBagLayout());
        jScrollPane5.setViewportView(jPanel5);

        components.addTab(bundle.getString("TAB5"), jScrollPane5); // NOI18N

        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setViewportView(jPanel6);

        jPanel6.setBackground(new java.awt.Color(255, 238, 224));
        jPanel6.setLayout(new java.awt.GridBagLayout());
        jScrollPane6.setViewportView(jPanel6);

        components.addTab(bundle.getString("TAB6"), jScrollPane6); // NOI18N

        jScrollPane7.setBorder(null);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setViewportView(jPanel7);

        jPanel7.setBackground(new java.awt.Color(255, 238, 224));
        jPanel7.setLayout(new java.awt.GridBagLayout());
        jScrollPane7.setViewportView(jPanel7);

        components.addTab(bundle.getString("TAB7"), jScrollPane7); // NOI18N

        jScrollPane8.setBorder(null);
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setViewportView(jPanel8);

        jPanel8.setBackground(new java.awt.Color(255, 238, 224));
        jPanel8.setLayout(new java.awt.GridBagLayout());
        jScrollPane8.setViewportView(jPanel8);

        components.addTab(bundle.getString("TAB8"), jScrollPane8); // NOI18N

        container.add(components, java.awt.BorderLayout.LINE_END);

        information.setBackground(new java.awt.Color(34, 86, 104));
        information.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 150, 86)));
        information.setForeground(new java.awt.Color(255, 255, 255));
        information.setPreferredSize(new java.awt.Dimension(1337, 150));

        finishBttn.setBackground(new java.awt.Color(55, 157, 146));
        finishBttn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        finishBttn.setForeground(new java.awt.Color(255, 255, 255));
        finishBttn.setText("Terminar");
        finishBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBttnActionPerformed(evt);
            }
        });

        prize.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        prize.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout informationLayout = new javax.swing.GroupLayout(information);
        information.setLayout(informationLayout);
        informationLayout.setHorizontalGroup(
            informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationLayout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(finishBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 670, Short.MAX_VALUE)
                .addComponent(prize)
                .addGap(144, 144, 144))
        );
        informationLayout.setVerticalGroup(
            informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prize))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        container.add(information, java.awt.BorderLayout.PAGE_END);

        principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 150, 86)));
        principal.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                principalComponentRemoved(evt);
            }
        });
        principal.setLayout(new java.awt.BorderLayout());
        container.add(principal, java.awt.BorderLayout.CENTER);

        getContentPane().add(container, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean pcComponentAlreadyInBuilder(int type, String pcComponentName){
        if(this.principal.getComponentCount() > 0){
            Builder builder = (Builder) this.principal.getComponents()[0];
            
            switch(type){
                case 0:
                    if(pcComponentName.equals(builder.getBoxName()))
                        return false;
                    break;
                case 1:
                    if(pcComponentName.equals(builder.getMotherboardName()))
                        return false;
                    break;
                case 2:
                    if(pcComponentName.equals(builder.getCpuName()))
                        return false;
                    break;
                case 3:
                    if(pcComponentName.equals(builder.getCoolerName()))
                        return false;
                    break;
                case 4:
                    if(pcComponentName.equals(builder.getRamName()))
                        return false;
                    break;
                case 5:
                    if(pcComponentName.equals(builder.getGpuName()))
                        return false;
                    break;
                case 6:
                    if(pcComponentName.equals(builder.getHardDiskName()))
                        return false;
                    break;
                case 7:
                    if(pcComponentName.equals(builder.getPsuName()))
                        return false;
                    break;
            }
        }
        
        return true;
    }
    
    private void componentsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_componentsStateChanged
        //Clear the last selected tab for performance improvemment
        switch(this.components.getSelectedIndex()){
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

        //Rule to put the component below that last component added
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets (0,0,5,0);

        //Add all the components to the list according to gridBagConstraints
        PcComponent.PcComponent pcComponent;

        for(int i = 0; i < componentList.size(); i++){
            pcComponent = new PcComponent.PcComponent();
            
            //Set the listeners for the pcComponent
            //Set a listener for drag event
            pcComponent.setDragEventListener(this);
            //Set a listener for mouse clicked event
            pcComponent.setMouseClickedEventListener(this);
            
            pcComponent.setComponentType(components.getSelectedIndex());
            //Set the information read from the database in the component
            switch(components.getSelectedIndex()){
                case 0:
                    PcBox pcBox = (PcBox) componentList.get(i);
                    
                    if(this.pcComponentAlreadyInBuilder(components.getSelectedIndex(), pcBox.getName())){
                        pcComponent.setComponentType(0);
                        pcComponent.setProductName(pcBox.getName());
                        pcComponent.setProductPrize(pcBox.getPrize());
                        pcComponent.setRecomendationVisibility(pcBox.isRecomended());
                        pcComponent.setProductDescription(pcBox.getDescription());
                        pcComponent.setProductBigImagePath("DataBases/PCBoxes_images/" + pcBox.getName() + "_230x229.jpg");
                        pcComponent.setProductImage(new ImageIcon("DataBases/PCBoxes_images/" + pcBox.getName() + "_142x141.jpg"));

                        //Add the GPU to the list
                        jPanel1.add(pcComponent, gridBagConstraints);
                    }
                    
                    break;
                case 1:
                    Motherboard motherboard = (Motherboard) componentList.get(i);
                    
                    if(this.pcComponentAlreadyInBuilder(components.getSelectedIndex(), motherboard.getName())){
                        pcComponent.setComponentType(1);
                        pcComponent.setProductName(motherboard.getName());
                        pcComponent.setProductPrize(motherboard.getPrize());
                        pcComponent.setRecomendationVisibility(motherboard.isRecomended());
                        pcComponent.setProductDescription(motherboard.getDescription());
                        pcComponent.setProductBigImagePath("DataBases/Motherboards_images/" + motherboard.getName() + "_230x229.jpg");
                        pcComponent.setProductImage(new ImageIcon("DataBases/Motherboards_images/" + motherboard.getName() + "_142x141.jpg"));   

                        //Add the GPU to the list
                        jPanel2.add(pcComponent, gridBagConstraints);
                    }
                    
                    break;
                case 2:
                    CPU cpu = (CPU) componentList.get(i);
                    
                    if(this.pcComponentAlreadyInBuilder(components.getSelectedIndex(), cpu.getName())){
                        pcComponent.setComponentType(2);
                        pcComponent.setProductName(cpu.getName());
                        pcComponent.setProductPrize(cpu.getPrize());
                        pcComponent.setRecomendationVisibility(cpu.isRecomended());
                        pcComponent.setProductDescription(cpu.getDescription());
                        pcComponent.setProductBigImagePath("DataBases/CPUs_images/" + cpu.getName() + "_230x229.jpg");
                        pcComponent.setProductImage(new ImageIcon("DataBases/CPUs_images/" + cpu.getName() + "_142x141.jpg"));

                        //Add the GPU to the list
                        jPanel3.add(pcComponent, gridBagConstraints);
                    }

                    break;
                case 3:
                    Cooler cooler = (Cooler) componentList.get(i);
                    
                    if(this.pcComponentAlreadyInBuilder(components.getSelectedIndex(), cooler.getName())){
                        pcComponent.setComponentType(3);
                        pcComponent.setProductName(cooler.getName());
                        pcComponent.setProductPrize(cooler.getPrize());
                        pcComponent.setRecomendationVisibility(cooler.isRecomended());
                        pcComponent.setProductDescription(cooler.getDescription());
                        pcComponent.setProductBigImagePath("DataBases/Coolers_images/" + cooler.getName() + "_230x229.jpg");
                        pcComponent.setProductImage(new ImageIcon("DataBases/Coolers_images/" + cooler.getName() + "_142x141.jpg"));

                        //Add the GPU to the list
                        jPanel4.add(pcComponent, gridBagConstraints);
                    }

                    break;
                case 4:
                    RAM ram = (RAM) componentList.get(i);
                    
                    if(this.pcComponentAlreadyInBuilder(components.getSelectedIndex(), ram.getName())){
                        pcComponent.setComponentType(4);
                        pcComponent.setProductName(ram.getName());
                        pcComponent.setProductPrize(ram.getPrize());
                        pcComponent.setRecomendationVisibility(ram.isRecomended());
                        pcComponent.setProductDescription(ram.getDescription());
                        pcComponent.setProductBigImagePath("DataBases/RAMs_images/" + ram.getName() + "_230x229.jpg");
                        pcComponent.setProductImage(new ImageIcon("DataBases/RAMs_images/" + ram.getName() + "_142x141.jpg"));

                        //Add the GPU to the list
                        jPanel5.add(pcComponent, gridBagConstraints);
                    }

                    break;
                case 5:
                    GPU gpu = (GPU) componentList.get(i);
                    
                    if(this.pcComponentAlreadyInBuilder(components.getSelectedIndex(), gpu.getName())){
                        pcComponent.setComponentType(5);
                        pcComponent.setProductName(gpu.getName());
                        pcComponent.setProductPrize(gpu.getPrize());
                        pcComponent.setRecomendationVisibility(gpu.isRecomended());
                        pcComponent.setProductDescription(gpu.getDescription());
                        pcComponent.setProductBigImagePath("DataBases/GPUs_images/" + gpu.getName() + "_230x229.jpg");
                        pcComponent.setProductImage(new ImageIcon("DataBases/GPUs_images/" + gpu.getName() + "_142x141.jpg"));

                        //Add the GPU to the list
                        jPanel6.add(pcComponent, gridBagConstraints);
                    }

                    break;
                case 6:
                    HardDisk hardDisk = (HardDisk) componentList.get(i);
                    
                    if(this.pcComponentAlreadyInBuilder(components.getSelectedIndex(), hardDisk.getName())){
                        pcComponent.setComponentType(6);
                        pcComponent.setProductName(hardDisk.getName());
                        pcComponent.setProductPrize(hardDisk.getPrize());
                        pcComponent.setRecomendationVisibility(hardDisk.isRecomended());
                        pcComponent.setProductDescription(hardDisk.getDescription());
                        pcComponent.setProductBigImagePath("DataBases/HardDisks_images/" + hardDisk.getName() + "_230x229.jpg");
                        pcComponent.setProductImage(new ImageIcon("DataBases/HardDisks_images/" + hardDisk.getName() + "_142x141.jpg"));

                        //Add the GPU to the list
                        jPanel7.add(pcComponent, gridBagConstraints);
                    }

                    break;
                case 7:
                    PSU psu = (PSU) componentList.get(i);
                    
                    if(this.pcComponentAlreadyInBuilder(components.getSelectedIndex(), psu.getName())){
                        pcComponent.setComponentType(7);
                        pcComponent.setProductName(psu.getName());
                        pcComponent.setProductPrize(psu.getPrize());
                        pcComponent.setRecomendationVisibility(psu.isRecomended());
                        pcComponent.setProductDescription(psu.getDescription());
                        pcComponent.setProductBigImagePath("DataBases/PSU_images/" + psu.getName() + "_230x229.jpg");
                        pcComponent.setProductImage(new ImageIcon("DataBases/PSU_images/" + psu.getName() + "_142x141.jpg"));

                        //Add the GPU to the list
                        jPanel8.add(pcComponent, gridBagConstraints);
                    }

                    break;
            }
        }
        
        //Fix the last element constraints
        javax.swing.JPanel panel;
        
        switch(components.getSelectedIndex()){
            case 0:
                panel = jPanel1;
                
                break;
            case 1:
                panel = jPanel2;
                
                break;
            case 2:
                panel = jPanel3;
                
                break;
            case 3:
                panel = jPanel4;
                
                break;
            case 4:
                panel = jPanel5;
                
                break;
            case 5:
                panel = jPanel6;
                
                break;
            case 6:
                panel = jPanel7;
                
                break;
            case 7:
                panel = jPanel8;
                
                break;
            default://Just initializes the panel variable if a new tab is added and not controlled
                panel = jPanel1;
        }
        
        if(panel.getComponentCount() > 0){
            PcComponent.PcComponent pcComponentEdit = (PcComponent.PcComponent) panel.getComponent(panel.getComponentCount() - 1);
            //Delete last element
            panel.remove(pcComponentEdit);
            
            //Set constraints
            gridBagConstraints = new java.awt.GridBagConstraints();
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
    }//GEN-LAST:event_componentsStateChanged

    private void principalComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_principalComponentRemoved
        //Enable DnD when PcInfo is closed
        PcComponent.PcComponent.setActiveDnD(true);
    }//GEN-LAST:event_principalComponentRemoved

    private void finishBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBttnActionPerformed
        
        Builder builder = (Builder) this.principal.getComponent(0);
        
        String info = "Importe total: " + builder.getTotalPrizeString();
        JPanel panel = new JPanel();
        panel.add(new JLabel("<html>" + info + "<br><br>¡Gracias por su compra!</html>", SwingConstants.CENTER));

        JOptionPane.showMessageDialog(this, panel, "Compra realizada",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("src/mainPage/images/purchase.png"));
    }//GEN-LAST:event_finishBttnActionPerformed

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
                page.initMainPage();
                page.setVisible(true);
                page.setLocationRelativeTo(null);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane components;
    private javax.swing.JPanel container;
    private javax.swing.JButton finishBttn;
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
    private javax.swing.JLabel prize;
    // End of variables declaration//GEN-END:variables
}
