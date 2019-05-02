/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import java.util.ArrayList;

/**
 *
 * @author Sergi
 */
public class Builder extends javax.swing.JPanel implements DropEventListener {

    Double totalPrize;
    
    /**
     * Creates new form Builder
     */
    public Builder() {
        initComponents();
               
        this.totalPrize = 0.0;
        
        //Required for drop operation
        DropPcComponent transferHandler = new DropPcComponent();
        transferHandler.setDragEventListener(this);
        this.setTransferHandler(transferHandler);
        
        this.tools.setVisible(true);
        this.box.setVisible(false);
        this.cooler.setVisible(false);
        this.cpu.setVisible(false);
        this.gpu.setVisible(false);
        this.motherboard.setVisible(false);
        this.psu.setVisible(false);
        this.ram.setVisible(false);
        this.hardDisk.setVisible(false);
    }
    
    //Performed when a deop event happen
    @Override
    public void onDropEvent(ArrayList<String> data){
        //data --> 0.Name, 1.Prize, 2.Type
        //NumberFormat currency = NumberFormat.getCurrencyInstance(); For prize
        
        //Check the component type
        switch(Integer.parseInt(data.get(2))){
            case 0:
                this.setBoxVisible();
                this.setBoxName(data.get(0) + "  " + data.get(1));
                break;
            case 1:
                this.setMotherboardVisible();
                this.setMotherboardName(data.get(0) + "  " + data.get(1));
                break;
            case 2:
                this.setCpuVisible();
                this.setCpuName(data.get(0) + "  " + data.get(1));
                break;
            case 3:
                this.setCoolerVisible();
                this.setCoolerName(data.get(0) + "  " + data.get(1));
                break;
            case 4:
                this.setRamVisible();
                this.setRamName(data.get(0) + "  " + data.get(1));
                break;
            case 5:
                this.setGpuVisible();
                this.setGpuName(data.get(0) + "  " + data.get(1));
                break;
            case 6:
                this.setHardDiskVisible();
                this.setHardDiskName(data.get(0) + "  " + data.get(1));
                break;
            case 7:
                this.setPsuVisible();
                this.setPsuName(data.get(0) + "  " + data.get(1));
                break;
        }
    }
    
    public void setBoxVisible() {
        this.tools.setVisible(false);
        this.box.setVisible(true);
    }
    
    public void setCoolerVisible() {
        this.tools.setVisible(false);
        this.cooler.setVisible(true);
    }
    
    public void setCpuVisible() {
        this.tools.setVisible(false);
        this.cpu.setVisible(true);
    }
    
    public void setGpuVisible() {
        this.tools.setVisible(false);
        this.gpu.setVisible(true);
    }
    
    public void setMotherboardVisible() {
        this.tools.setVisible(false);
        this.motherboard.setVisible(true);
    }
    
    public void setPsuVisible() {
        this.tools.setVisible(false);
        this.psu.setVisible(true);
    }
    
    public void setRamVisible() {
        this.tools.setVisible(false);
        this.ram.setVisible(true);
    }
    
    public void setHardDiskVisible() {
        this.tools.setVisible(false);
        this.hardDisk.setVisible(true);
    }
    
    public void setBoxInvisible() {
        this.box.setVisible(false);
        
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setCoolerInvisible() {
        this.cooler.setVisible(false); 
        
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setCpuInvisible() {
        this.cpu.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setGpuInvisible() {
        this.gpu.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setMotherboardInvisible() {
        this.motherboard.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setPsuInvisible() {
        this.psu.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setRamInvisible() {
        this.ram.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setHardDiskInvisible() {
        this.hardDisk.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public Boolean isEmpty() {
        if(!this.box.isVisible() && !this.cooler.isVisible() &&
           !this.cpu.isVisible() && !this.gpu.isVisible() &&
           !this.hardDisk.isVisible() && !this.motherboard.isVisible() &&
           !this.psu.isVisible() && !this.ram.isVisible()) {
            
            return true;
        }
        
        return false;
    }
    
    public void setBoxName(String name) {
        this.boxName.setText(name);
    }
    
    public void setMotherboardName(String name) {
        this.motherboardName.setText(name);
    }
    
    public void setCpuName(String name) {
        this.cpuName.setText(name);
    }
    
    public void setGpuName(String name) {
        this.gpuName.setText(name);
    }
    
    public void setCoolerName(String name) {
        this.coolerName.setText(name);
    }
    
    public void setRamName(String name) {
        this.ramName.setText(name);
    }
    
    public void setPsuName(String name) {
        this.psuName.setText(name);
    }
    
    public void setHardDiskName(String name) {
        this.hardDiskName.setText(name);
    }
    
    public void addToTotal(Double prize) {
        this.totalPrize += prize;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cooler = new javax.swing.JLabel();
        hardDisk = new javax.swing.JLabel();
        cpu = new javax.swing.JLabel();
        ram = new javax.swing.JLabel();
        gpu = new javax.swing.JLabel();
        psu = new javax.swing.JLabel();
        motherboard = new javax.swing.JLabel();
        box = new javax.swing.JLabel();
        tools = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        boxName = new javax.swing.JLabel();
        motherboardName = new javax.swing.JLabel();
        cpuName = new javax.swing.JLabel();
        coolerName = new javax.swing.JLabel();
        ramName = new javax.swing.JLabel();
        gpuName = new javax.swing.JLabel();
        hardDiskName = new javax.swing.JLabel();
        psuName = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(802, 756));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cooler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/cooler.png"))); // NOI18N
        add(cooler, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        hardDisk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/hardDisk.png"))); // NOI18N
        add(hardDisk, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        cpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/cpu.png"))); // NOI18N
        add(cpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        ram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/ram.png"))); // NOI18N
        add(ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        gpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/gpu.png"))); // NOI18N
        add(gpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        psu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/psu.png"))); // NOI18N
        add(psu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        motherboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/motherboard.png"))); // NOI18N
        add(motherboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/box.png"))); // NOI18N
        add(box, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -30, -1, -1));

        tools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/tools.png"))); // NOI18N
        add(tools, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Caja:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Placa Base:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("CPU:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Disipador:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RAM:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("GPU:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Disco Duro:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("PSU:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, -1, -1));
        add(boxName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 700, -1));
        add(motherboardName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 670, -1));
        add(cpuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 710, -1));
        add(coolerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 670, -1));
        add(ramName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 700, -1));
        add(gpuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, 700, -1));
        add(hardDiskName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 680, 660, -1));
        add(psuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 700, 700, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel box;
    private javax.swing.JLabel boxName;
    private javax.swing.JLabel cooler;
    private javax.swing.JLabel coolerName;
    private javax.swing.JLabel cpu;
    private javax.swing.JLabel cpuName;
    private javax.swing.JLabel gpu;
    private javax.swing.JLabel gpuName;
    private javax.swing.JLabel hardDisk;
    private javax.swing.JLabel hardDiskName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel motherboard;
    private javax.swing.JLabel motherboardName;
    private javax.swing.JLabel psu;
    private javax.swing.JLabel psuName;
    private javax.swing.JLabel ram;
    private javax.swing.JLabel ramName;
    private javax.swing.JLabel tools;
    // End of variables declaration//GEN-END:variables
}
