/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PcComponent;

import java.awt.Container;
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
  
  private DnDMoveEventListener listener;
  
  //Set a listener to the DnD move event
  public void setDnDMoveEventListener (DnDMoveEventListener listener) {
    this.listener = listener;
  }
  
  @Override
  public int getSourceActions(JComponent c) {
    return TransferHandler.MOVE;
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
      
        //Reload the container
        container.revalidate();
        container.repaint();
        
        //Throw the DnD move event if listener is set
        if (this.listener != null) this.listener.onDnDMoveEvent(container);
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
