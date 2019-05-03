/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergi
 */
public class Builder extends javax.swing.JPanel implements DropEventListener {
    
    //All the operations are procesed in cents
    private int totalPrize;
    private ComponentDeleteEventListener listener;
    
    /**
     * Creates new form Builder
     */
    public Builder() {
        initComponents();
               
        this.totalPrize = 0;
        
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
        this.removeBox.setVisible(false);
        this.removeCooler.setVisible(false);
        this.removeCpu.setVisible(false);
        this.removePsu.setVisible(false);
        this.removeMotherboard.setVisible(false);
        this.removeRam.setVisible(false);
        this.removeHardDisk.setVisible(false);
        this.removeGpu.setVisible(false);
    }
    
    //Set a listener to the remove component event
    public void setComponentDeleteEventListener (ComponentDeleteEventListener listener) {
        this.listener = listener;
    }
    
    //Performed when a drop event happen
    @Override
    public void onDropEvent(ArrayList<String> data){
        //data --> 0.Name, 1.Prize, 2.Type
        
        //Check the component type
        switch(Integer.parseInt(data.get(2))){
            case 0:
                if(this.box.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.boxPrize.getText()));
                }
                
                this.setBoxVisible();
                this.setBoxName(data.get(0));
                this.setBoxPrize(data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));

                break;
            case 1:
                if(this.motherboard.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.motherboardPrize.getText()));
                }
                
                this.setMotherboardVisible();
                this.setMotherboardName(data.get(0));
                this.setMotherboardPrize(data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));

                break;
            case 2:
                if(this.cpu.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.cpuPrize.getText()));
                }
                
                this.setCpuVisible();
                this.setCpuName(data.get(0));
                this.setCpuPrize(data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));

                break;
            case 3:
                if(this.cooler.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.coolerPrize.getText()));
                }
                
                this.setCoolerVisible();
                this.setCoolerName(data.get(0));
                this.setCoolerPrize(data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));

                break;
            case 4:
                if(this.ram.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.ramPrize.getText()));
                }
                
                this.setRamVisible();
                this.setRamName(data.get(0));
                this.setRamPrize(data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));

                break;
            case 5:
                if(this.gpu.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.gpuPrize.getText()));
                }
                
                this.setGpuVisible();
                this.setGpuName(data.get(0));
                this.setGpuPrize(data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));

                break;
            case 6:
                if(this.hardDisk.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.hardDiskPrize.getText()));
                }
                
                this.setHardDiskVisible();
                this.setHardDiskName(data.get(0));
                this.setHardDiskPrize(data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));

                break;
            case 7:
                if(this.psu.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.psuPrize.getText()));
                }
                
                this.setPsuVisible();
                this.setPsuName(data.get(0));
                this.setPsuPrize(data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));

                break;
        }
    }
    
    public Double getTotalPrize() {
        int ammount = this.totalPrize;
        int decimals = ammount % 100;
        int units = (ammount - decimals) / 100;
        String prize = String.valueOf(units) + "." + String.valueOf(decimals);
        Double doublePrize = Double.valueOf(prize);
        
        return doublePrize;
    }
    
    public String getTotalPrizeString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        return nf.format(this.getTotalPrize());
    }
    
    public void setBoxVisible() {
        this.tools.setVisible(false);
        this.box.setVisible(true);
        this.removeBox.setVisible(true);
    }
    
    public void setCoolerVisible() {
        this.tools.setVisible(false);
        this.cooler.setVisible(true);
        this.removeCooler.setVisible(true);
    }
    
    public void setCpuVisible() {
        this.tools.setVisible(false);
        this.cpu.setVisible(true);
        this.removeCpu.setVisible(true);
    }
    
    public void setGpuVisible() {
        this.tools.setVisible(false);
        this.gpu.setVisible(true);
        this.removeGpu.setVisible(true);
    }
    
    public void setMotherboardVisible() {
        this.tools.setVisible(false);
        this.motherboard.setVisible(true);
        this.removeMotherboard.setVisible(true);
    }
    
    public void setPsuVisible() {
        this.tools.setVisible(false);
        this.psu.setVisible(true);
        this.removePsu.setVisible(true);
    }
    
    public void setRamVisible() {
        this.tools.setVisible(false);
        this.ram.setVisible(true);
        this.removeRam.setVisible(true);
    }
    
    public void setHardDiskVisible() {
        this.tools.setVisible(false);
        this.hardDisk.setVisible(true);
        this.removeHardDisk.setVisible(true);
    }
    
    public void setBoxInvisible() {
        this.box.setVisible(false);
        this.removeBox.setVisible(false);
        
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setCoolerInvisible() {
        this.cooler.setVisible(false); 
        this.removeCooler.setVisible(false);
        
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setCpuInvisible() {
        this.cpu.setVisible(false);
        this.removeCpu.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setGpuInvisible() {
        this.gpu.setVisible(false);
        this.removeGpu.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setMotherboardInvisible() {
        this.motherboard.setVisible(false);
        this.removeMotherboard.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setPsuInvisible() {
        this.psu.setVisible(false);
        this.removePsu.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setRamInvisible() {
        this.ram.setVisible(false);
        this.removeRam.setVisible(false);
                
        if(this.isEmpty()) {
            this.tools.setVisible(true);
        }
    }
    
    public void setHardDiskInvisible() {
        this.hardDisk.setVisible(false);
        this.removeHardDisk.setVisible(false);
                
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
    
    public Boolean isCompleted() {
        if(this.box.isVisible() && this.cooler.isVisible() &&
           this.cpu.isVisible() && this.gpu.isVisible() &&
           this.hardDisk.isVisible() && this.motherboard.isVisible() &&
           this.psu.isVisible() && this.ram.isVisible()) {
            
            return true;
        }
        
        return false;
    }
    
    public void setBoxName(String name) {
        this.boxName.setText(name);
    }
    
    public void setBoxPrize(String prize) {
        this.boxPrize.setText(prize);
    }
    
    public void setMotherboardName(String name) {
        this.motherboardName.setText(name);
    }
    
    public void setMotherboardPrize(String prize) {
        this.motherboardPrize.setText(prize);
    }
    
    public void setCpuName(String name) {
        this.cpuName.setText(name);
    }
    
    public void setCpuPrize(String prize) {
        this.cpuPrize.setText(prize);
    }
    
    public void setGpuName(String name) {
        this.gpuName.setText(name);
    }
    
    public void setGpuPrize(String prize) {
        this.gpuPrize.setText(prize);
    }
    
    public void setCoolerName(String name) {
        this.coolerName.setText(name);
    }
    
    public void setCoolerPrize(String prize) {
        this.coolerPrize.setText(prize);
    }
    
    public void setRamName(String name) {
        this.ramName.setText(name);
    }
    
    public void setRamPrize(String prize) {
        this.ramPrize.setText(prize);
    }
    
    public void setPsuName(String name) {
        this.psuName.setText(name);
    }
    
    public void setPsuPrize(String prize) {
        this.psuPrize.setText(prize);
    }
    
    public void setHardDiskName(String name) {
        this.hardDiskName.setText(name);
    }
    
    public void setHardDiskPrize(String prize) {
        this.hardDiskPrize.setText(prize);
    }

    public String getBoxName() {
        return boxName.getText();
    }

    public String getCoolerName() {
        return coolerName.getText();
    }

    public String getCpuName() {
        return cpuName.getText();
    }

    public String getGpuName() {
        return gpuName.getText();
    }

    public String getHardDiskName() {
        return hardDiskName.getText();
    }

    public String getMotherboardName() {
        return motherboardName.getText();
    }

    public String getPsuName() {
        return psuName.getText();
    }

    public String getRamName() {
        return ramName.getText();
    }
    
    
    
    //Transform from String euros to int cents
    private int transformPrize(String prize) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        Number prizeDouble = null;
        try {
            prizeDouble = currency.parse(prize);
        } catch (ParseException ex) {
            Logger.getLogger(Builder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        var prizeInt = (int) (prizeDouble.doubleValue()*100);

        return prizeInt;
    }
    
    public void addToTotal(int prize) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        this.totalPrize += prize;
    }
    
    public void substractToTotal(int prize) {
        this.totalPrize -= prize;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        images = new javax.swing.JPanel();
        hardDisk = new javax.swing.JLabel();
        ram = new javax.swing.JLabel();
        cooler = new javax.swing.JLabel();
        cpu = new javax.swing.JLabel();
        gpu = new javax.swing.JLabel();
        psu = new javax.swing.JLabel();
        motherboard = new javax.swing.JLabel();
        box = new javax.swing.JLabel();
        tools = new javax.swing.JLabel();
        components = new javax.swing.JPanel();
        removes = new javax.swing.JPanel();
        info = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        boxName = new javax.swing.JLabel();
        boxPrize = new javax.swing.JLabel();
        motherboardName = new javax.swing.JLabel();
        motherboardPrize = new javax.swing.JLabel();
        cpuName = new javax.swing.JLabel();
        cpuPrize = new javax.swing.JLabel();
        coolerName = new javax.swing.JLabel();
        coolerPrize = new javax.swing.JLabel();
        ramName = new javax.swing.JLabel();
        ramPrize = new javax.swing.JLabel();
        gpuName = new javax.swing.JLabel();
        gpuPrize = new javax.swing.JLabel();
        hardDiskName = new javax.swing.JLabel();
        hardDiskPrize = new javax.swing.JLabel();
        psuName = new javax.swing.JLabel();
        psuPrize = new javax.swing.JLabel();
        removeBox = new javax.swing.JLabel();
        removeMotherboard = new javax.swing.JLabel();
        removeHardDisk = new javax.swing.JLabel();
        removeRam = new javax.swing.JLabel();
        removeGpu = new javax.swing.JLabel();
        removeCooler = new javax.swing.JLabel();
        removePsu = new javax.swing.JLabel();
        removeCpu = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(802, 756));
        setLayout(new java.awt.BorderLayout());

        images.setBackground(java.awt.Color.white);
        images.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hardDisk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/hardDisk.png"))); // NOI18N
        images.add(hardDisk, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        ram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/ram.png"))); // NOI18N
        images.add(ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        cooler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/cooler.png"))); // NOI18N
        images.add(cooler, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        cpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/cpu.png"))); // NOI18N
        images.add(cpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        gpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/gpu.png"))); // NOI18N
        images.add(gpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        psu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/psu.png"))); // NOI18N
        images.add(psu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        motherboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/motherboard.png"))); // NOI18N
        images.add(motherboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/box.png"))); // NOI18N
        images.add(box, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, -10, -1, -1));

        tools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/tools.png"))); // NOI18N
        images.add(tools, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        add(images, java.awt.BorderLayout.CENTER);

        components.setBackground(java.awt.Color.white);
        components.setPreferredSize(new java.awt.Dimension(802, 200));
        components.setLayout(new java.awt.BorderLayout());

        removes.setBackground(java.awt.Color.white);
        removes.setPreferredSize(new java.awt.Dimension(30, 200));
        removes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        components.add(removes, java.awt.BorderLayout.LINE_START);

        info.setBackground(java.awt.Color.white);
        info.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Caja:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Placa Base:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("CPU:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Disipador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RAM:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("GPU:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Disco duro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("PSU:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(jLabel8, gridBagConstraints);

        boxName.setText("arrastre a esta ventana para montar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 30);
        info.add(boxName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(boxPrize, gridBagConstraints);

        motherboardName.setText("arrastre a esta ventana para montar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 30);
        info.add(motherboardName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(motherboardPrize, gridBagConstraints);

        cpuName.setText("arrastre a esta ventana para montar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 30);
        info.add(cpuName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(cpuPrize, gridBagConstraints);

        coolerName.setText("arrastre a esta ventana para montar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 30);
        info.add(coolerName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(coolerPrize, gridBagConstraints);

        ramName.setText("arrastre a esta ventana para montar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 30);
        info.add(ramName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(ramPrize, gridBagConstraints);

        gpuName.setText("arrastre a esta ventana para montar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 30);
        info.add(gpuName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(gpuPrize, gridBagConstraints);

        hardDiskName.setText("arrastre a esta ventana para montar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 30);
        info.add(hardDiskName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(hardDiskPrize, gridBagConstraints);

        psuName.setText("arrastre a esta ventana para montar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 30);
        info.add(psuName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        info.add(psuPrize, gridBagConstraints);

        removeBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeBoxMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 3, 12);
        info.add(removeBox, gridBagConstraints);

        removeMotherboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeMotherboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMotherboardMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 3, 12);
        info.add(removeMotherboard, gridBagConstraints);

        removeHardDisk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeHardDisk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeHardDiskMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 3, 12);
        info.add(removeHardDisk, gridBagConstraints);

        removeRam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeRam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeRamMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 3, 12);
        info.add(removeRam, gridBagConstraints);

        removeGpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeGpu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeGpuMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 3, 12);
        info.add(removeGpu, gridBagConstraints);

        removeCooler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeCooler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCoolerMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 3, 12);
        info.add(removeCooler, gridBagConstraints);

        removePsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removePsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removePsuMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 3, 12);
        info.add(removePsu, gridBagConstraints);

        removeCpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeCpu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCpuMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 3, 12);
        info.add(removeCpu, gridBagConstraints);

        components.add(info, java.awt.BorderLayout.CENTER);

        add(components, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void removeBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeBoxMouseClicked
        this.substractToTotal(this.transformPrize(this.boxPrize.getText()));
        this.boxName.setText("arrastre a esta ventana para montar");
        this.boxPrize.setText("");
        this.setBoxInvisible();
        
        //PcComponents in tabs are updated if listener is set
        if (this.listener != null) this.listener.onComponentDeleteEvent(0);
    }//GEN-LAST:event_removeBoxMouseClicked

    private void removeMotherboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMotherboardMouseClicked
        this.substractToTotal(this.transformPrize(this.motherboardPrize.getText()));
        this.motherboardName.setText("arrastre a esta ventana para montar");
        this.motherboardPrize.setText("");
        this.setMotherboardInvisible();
        
        //PcComponents in tabs are updated if listener is set
        if (this.listener != null) this.listener.onComponentDeleteEvent(1);
    }//GEN-LAST:event_removeMotherboardMouseClicked

    private void removeCpuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCpuMouseClicked
        this.substractToTotal(this.transformPrize(this.cpuPrize.getText()));
        this.cpuName.setText("arrastre a esta ventana para montar");
        this.cpuPrize.setText("");
        this.setCpuInvisible();
        
        //PcComponents in tabs are updated if listener is set
        if (this.listener != null) this.listener.onComponentDeleteEvent(2);
    }//GEN-LAST:event_removeCpuMouseClicked

    private void removeCoolerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCoolerMouseClicked
        this.substractToTotal(this.transformPrize(this.coolerPrize.getText()));
        this.coolerName.setText("arrastre a esta ventana para montar");
        this.coolerPrize.setText("");
        this.setCoolerInvisible();
        
        //PcComponents in tabs are updated if listener is set
        if (this.listener != null) this.listener.onComponentDeleteEvent(3);
    }//GEN-LAST:event_removeCoolerMouseClicked

    private void removeRamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeRamMouseClicked
        this.substractToTotal(this.transformPrize(this.ramPrize.getText()));
        this.ramName.setText("arrastre a esta ventana para montar");
        this.ramPrize.setText("");
        this.setRamInvisible();
        
        //PcComponents in tabs are updated if listener is set
        if (this.listener != null) this.listener.onComponentDeleteEvent(4);
    }//GEN-LAST:event_removeRamMouseClicked

    private void removeGpuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGpuMouseClicked
        this.substractToTotal(this.transformPrize(this.gpuPrize.getText()));
        this.gpuName.setText("arrastre a esta ventana para montar");
        this.gpuPrize.setText("");
        this.setGpuInvisible();
        
        //PcComponents in tabs are updated if listener is set
        if (this.listener != null) this.listener.onComponentDeleteEvent(5);
    }//GEN-LAST:event_removeGpuMouseClicked

    private void removeHardDiskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeHardDiskMouseClicked
        this.substractToTotal(this.transformPrize(this.hardDiskPrize.getText()));
        this.hardDiskName.setText("arrastre a esta ventana para montar");
        this.hardDiskPrize.setText("");
        this.setHardDiskInvisible();
        
        //PcComponents in tabs are updated if listener is set
        if (this.listener != null) this.listener.onComponentDeleteEvent(6);
    }//GEN-LAST:event_removeHardDiskMouseClicked

    private void removePsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removePsuMouseClicked
        this.substractToTotal(this.transformPrize(this.psuPrize.getText()));
        this.psuName.setText("arrastre a esta ventana para montar");
        this.psuPrize.setText("");
        this.setPsuInvisible();
        
        //PcComponents in tabs are updated if listener is set
        if (this.listener != null) this.listener.onComponentDeleteEvent(7);
    }//GEN-LAST:event_removePsuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel box;
    private javax.swing.JLabel boxName;
    private javax.swing.JLabel boxPrize;
    private javax.swing.JPanel components;
    private javax.swing.JLabel cooler;
    private javax.swing.JLabel coolerName;
    private javax.swing.JLabel coolerPrize;
    private javax.swing.JLabel cpu;
    private javax.swing.JLabel cpuName;
    private javax.swing.JLabel cpuPrize;
    private javax.swing.JLabel gpu;
    private javax.swing.JLabel gpuName;
    private javax.swing.JLabel gpuPrize;
    private javax.swing.JLabel hardDisk;
    private javax.swing.JLabel hardDiskName;
    private javax.swing.JLabel hardDiskPrize;
    private javax.swing.JPanel images;
    private javax.swing.JPanel info;
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
    private javax.swing.JLabel motherboardPrize;
    private javax.swing.JLabel psu;
    private javax.swing.JLabel psuName;
    private javax.swing.JLabel psuPrize;
    private javax.swing.JLabel ram;
    private javax.swing.JLabel ramName;
    private javax.swing.JLabel ramPrize;
    private javax.swing.JLabel removeBox;
    private javax.swing.JLabel removeCooler;
    private javax.swing.JLabel removeCpu;
    private javax.swing.JLabel removeGpu;
    private javax.swing.JLabel removeHardDisk;
    private javax.swing.JLabel removeMotherboard;
    private javax.swing.JLabel removePsu;
    private javax.swing.JLabel removeRam;
    private javax.swing.JPanel removes;
    private javax.swing.JLabel tools;
    // End of variables declaration//GEN-END:variables
}
