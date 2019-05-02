/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        this.removeBox.setVisible(false);
        this.removeCooler.setVisible(false);
        this.removeCpu.setVisible(false);
        this.removeGpu.setVisible(false);
        this.removeMotherboard.setVisible(false);
        this.removePsu.setVisible(false);
        this.removeRam.setVisible(false);
        this.removeHardDisk.setVisible(false);
    }
    
    //Performed when a deop event happen
    @Override
    public void onDropEvent(ArrayList<String> data){
        //data --> 0.Name, 1.Prize, 2.Type
        //NumberFormat currency = NumberFormat.getCurrencyInstance(); For prize
        
        //Check the component type
        switch(Integer.parseInt(data.get(2))){
            case 0:
                if(this.box.isVisible()) {
                    //System.out.println("Estoy cambiando: "+this.boxName.getText()+"\n");
                    //System.out.println(this.totalPrize +"-"+ this.transformPrize(this.getPrize(this.boxName.getText()))+ "=");
                    this.substractToTotal(this.transformPrize(this.getPrize(this.boxName.getText())));
                    //System.out.println(this.totalPrize+"\n");
                    System.out.println("holi: "+this.transformPrize(this.getPrize(this.boxName.getText()))+"\n");
                }
                
                this.setBoxVisible();
                this.setBoxName(data.get(0) + " - " + data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));
                this.removeBox.setVisible(true);
                break;
            case 1:
                if(this.motherboard.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.getPrize(this.motherboardName.getText())));
                }
                
                this.setMotherboardVisible();
                this.setMotherboardName(data.get(0) + " - " + data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));
                this.removeMotherboard.setVisible(true);
                break;
            case 2:
                if(this.cpu.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.getPrize(this.cpuName.getText())));
                }
                
                this.setCpuVisible();
                this.setCpuName(data.get(0) + " - " + data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));
                this.removeCpu.setVisible(true);
                break;
            case 3:
                if(this.cooler.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.getPrize(this.coolerName.getText())));
                }
                
                this.setCoolerVisible();
                this.setCoolerName(data.get(0) + " - " + data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));
                this.removeCooler.setVisible(true);
                break;
            case 4:
                if(this.ram.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.getPrize(this.ramName.getText())));
                }
                
                this.setRamVisible();
                this.setRamName(data.get(0) + " - " + data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));
                this.removeRam.setVisible(true);
                break;
            case 5:
                if(this.gpu.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.getPrize(this.gpuName.getText())));
                }
                
                this.setGpuVisible();
                this.setGpuName(data.get(0) + " - " + data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));
                this.removeGpu.setVisible(true);
                break;
            case 6:
                if(this.hardDisk.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.getPrize(this.hardDiskName.getText())));
                }
                
                this.setHardDiskVisible();
                this.setHardDiskName(data.get(0) + " - " + data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));
                this.removeHardDisk.setVisible(true);
                break;
            case 7:
                if(this.psu.isVisible()) {
                    this.substractToTotal(this.transformPrize(this.getPrize(this.psuName.getText())));
                }
                
                this.setPsuVisible();
                this.setPsuName(data.get(0) + " - " + data.get(1));
                this.addToTotal(this.transformPrize(data.get(1)));
                this.removePsu.setVisible(true);
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
    
    /*private Double transfomrPrize(String prize) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);
        nf.setMinimumFractionDigits(2);
        String ammount= nf.format(currency);

        double prize  = Double.parseDouble(ammount);
        System.out.println("soy prize: "+prize+"\n");
        return prize;
    }*/
    
    private Double transformPrize(String currency) {
        
        String s;
        
        try {
            s = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse (currency).toString();
        } catch (ParseException e) {
            System.out.println("holiwi\n");
            return 0.0;
        }

        double prize  = Double.parseDouble(s);
        System.out.println("soy prize: "+prize+"\n");
        return prize;
    }
    
    private String getPrize(String string) {
        String prize;
        
        Scanner sc = new Scanner(string).useDelimiter("-");
        
        sc.next();
        prize = sc.next();
        
        return prize;
    }
    
    public void addToTotal(Double prize) {
        this.totalPrize += prize;
        System.out.println(this.totalPrize+"\n");
    }
    
    public void substractToTotal(Double prize) {
        this.totalPrize -= prize;
        System.out.println(this.totalPrize+"\n");
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
        removePsu = new javax.swing.JLabel();
        removeBox = new javax.swing.JLabel();
        removeMotherboard = new javax.swing.JLabel();
        removeCpu = new javax.swing.JLabel();
        removeCooler = new javax.swing.JLabel();
        removeRam = new javax.swing.JLabel();
        removeGpu = new javax.swing.JLabel();
        removeHardDisk = new javax.swing.JLabel();

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

        removePsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removePsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removePsuMouseClicked(evt);
            }
        });
        add(removePsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, -1, -1));

        removeBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeBoxMouseClicked(evt);
            }
        });
        add(removeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        removeMotherboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeMotherboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMotherboardMouseClicked(evt);
            }
        });
        add(removeMotherboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        removeCpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeCpu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCpuMouseClicked(evt);
            }
        });
        add(removeCpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        removeCooler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeCooler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCoolerMouseClicked(evt);
            }
        });
        add(removeCooler, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

        removeRam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeRam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeRamMouseClicked(evt);
            }
        });
        add(removeRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, -1, -1));

        removeGpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeGpu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeGpuMouseClicked(evt);
            }
        });
        add(removeGpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, -1, -1));

        removeHardDisk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Builder/images/remove.png"))); // NOI18N
        removeHardDisk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeHardDiskMouseClicked(evt);
            }
        });
        add(removeHardDisk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void removeBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeBoxMouseClicked
        this.removeBox.setVisible(false);
        this.substractToTotal(this.transformPrize(this.getPrize(this.boxName.getText())));
        this.boxName.setText("");
        this.setBoxInvisible();
    }//GEN-LAST:event_removeBoxMouseClicked

    private void removeMotherboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMotherboardMouseClicked
        this.removeMotherboard.setVisible(false);
        this.substractToTotal(this.transformPrize(this.getPrize(this.motherboardName.getText())));
        this.motherboardName.setText("");
        this.setBoxInvisible();
    }//GEN-LAST:event_removeMotherboardMouseClicked

    private void removeCpuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCpuMouseClicked
        this.removeCpu.setVisible(false);
        this.substractToTotal(this.transformPrize(this.getPrize(this.cpuName.getText())));
        this.cpuName.setText("");
        this.setBoxInvisible();
    }//GEN-LAST:event_removeCpuMouseClicked

    private void removeCoolerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCoolerMouseClicked
        this.removeCooler.setVisible(false);
        this.substractToTotal(this.transformPrize(this.getPrize(this.coolerName.getText())));
        this.coolerName.setText("");
        this.setBoxInvisible();
    }//GEN-LAST:event_removeCoolerMouseClicked

    private void removeRamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeRamMouseClicked
        this.removeRam.setVisible(false);
        this.substractToTotal(this.transformPrize(this.getPrize(this.ramName.getText())));
        this.ramName.setText("");
        this.setBoxInvisible();
    }//GEN-LAST:event_removeRamMouseClicked

    private void removeGpuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGpuMouseClicked
        this.removeGpu.setVisible(false);
        this.substractToTotal(this.transformPrize(this.getPrize(this.gpuName.getText())));
        this.gpuName.setText("");
        this.setBoxInvisible();
    }//GEN-LAST:event_removeGpuMouseClicked

    private void removeHardDiskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeHardDiskMouseClicked
        this.removeHardDisk.setVisible(false);
        this.substractToTotal(this.transformPrize(this.getPrize(this.hardDiskName.getText())));
        this.hardDiskName.setText("");
        this.setBoxInvisible();
    }//GEN-LAST:event_removeHardDiskMouseClicked

    private void removePsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removePsuMouseClicked
        this.removePsu.setVisible(false);
        this.substractToTotal(this.transformPrize(this.getPrize(this.psuName.getText())));
        this.psuName.setText("");
        this.setBoxInvisible();
    }//GEN-LAST:event_removePsuMouseClicked


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
    private javax.swing.JLabel removeBox;
    private javax.swing.JLabel removeCooler;
    private javax.swing.JLabel removeCpu;
    private javax.swing.JLabel removeGpu;
    private javax.swing.JLabel removeHardDisk;
    private javax.swing.JLabel removeMotherboard;
    private javax.swing.JLabel removePsu;
    private javax.swing.JLabel removeRam;
    private javax.swing.JLabel tools;
    // End of variables declaration//GEN-END:variables
}
