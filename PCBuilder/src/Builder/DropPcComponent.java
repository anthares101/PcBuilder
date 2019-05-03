/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.TransferHandler;

/**
 *
 * @author anthares101
 */
public class DropPcComponent extends TransferHandler {
    private DropEventListener listener;
    
    //Set a listener to the drop event
    public void setDragEventListener (DropEventListener listener) {
        this.listener = listener;
    }
    
    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        if (!support.isDrop()) {
            return false;
        }
        
        DataFlavor dataflavor = null;
        try {
            dataflavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\"" +  ArrayList.class.getName() + "\"");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DropPcComponent.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return support.isDataFlavorSupported(dataflavor);
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport support) {
        if (!this.canImport(support)) {
            return false;
        }
        Transferable t = support.getTransferable();
        ArrayList<String> data = null;
        try {
            data = (ArrayList<String>) t.getTransferData(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\"" +  ArrayList.class.getName() + "\""));
            if (data == null) {
              return false;
            }
        } catch (UnsupportedFlavorException | IOException | ClassNotFoundException e) {
            return false;
        }
        
        //Throw the drop event if listener is set
        if (this.listener != null) this.listener.onDropEvent(data);

        return true;
    }
}
