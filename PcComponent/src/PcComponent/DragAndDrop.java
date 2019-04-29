/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PcComponent;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.NumberFormat;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

/**
 *
 * @author anthares101
 */
class DragAndDrop extends TransferHandler {
  @Override
  public int getSourceActions(JComponent c) {
    return TransferHandler.COPY_OR_MOVE;
  }

  @Override
  protected Transferable createTransferable(JComponent source) {
    @SuppressWarnings("unchecked")
    PcComponent sourcePcComponent = (PcComponent)source;
    
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    String data = sourcePcComponent.getProductName();
    data = data + ";" + currency.format(sourcePcComponent.getProductPrize());
    
    Transferable t = new StringSelection(data);
    
    return t;
  }

  @Override
  protected void exportDone(JComponent source, Transferable data, int action) {
    @SuppressWarnings("unchecked")
    PcComponent sourcePcComponent = (PcComponent) source;

    if (action == TransferHandler.MOVE) {
        Container container = sourcePcComponent.getParent();
        //Remove the component
        container.remove(sourcePcComponent);
        
        //Fix the last element constraints
        if(container.getComponentCount() > 0){
            PcComponent pcComponent = (PcComponent) container.getComponent(container.getComponentCount() - 1);
            //Delete last element
            container.remove(pcComponent);
            
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
            container.add(pcComponent, gridBagConstraints);
        }
      
        //Reload the container
        container.revalidate();
        container.repaint();
    }
  }

  @Override
  public boolean canImport(TransferHandler.TransferSupport support) {
    if (!support.isDrop()) {
      return false;
    }
    return support.isDataFlavorSupported(DataFlavor.stringFlavor);
  }

  @Override
  public boolean importData(TransferHandler.TransferSupport support) {
    if (!this.canImport(support)) {
      return false;
    }
    Transferable t = support.getTransferable();
    String data = null;
    try {
      data = (String) t.getTransferData(DataFlavor.stringFlavor);
      if (data == null) {
        return false;
      }
    } catch (UnsupportedFlavorException | IOException e) {
        return false;
    }

    @SuppressWarnings("unchecked")
    PcComponent targetPcComponent = (PcComponent) support.getComponent();

    targetPcComponent.setProductName(data);

    return true;
  }
}
