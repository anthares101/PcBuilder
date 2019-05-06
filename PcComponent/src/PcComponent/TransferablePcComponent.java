/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PcComponent;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anthares101
 */
public class TransferablePcComponent implements Transferable {
    protected DataFlavor dataflavor;
    protected DataFlavor[] supportedFlavors;
    private ArrayList<String> data;
    
    public TransferablePcComponent(ArrayList<String> data) {
        DataFlavor flavor = null;
        try {
            flavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\"" +  ArrayList.class.getName() + "\"");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferablePcComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dataflavor = flavor;
        this.supportedFlavors = new DataFlavor[] {flavor};
        this.data = data;
    }
    
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return supportedFlavors;
    }
    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        if (flavor.equals(dataflavor)) {
            return true;
        }
        return false;
    }
    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (flavor.equals(dataflavor)) {
            return this.data;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
