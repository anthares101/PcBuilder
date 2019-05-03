/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PcComponent;

import java.awt.Container;
import java.awt.datatransfer.Transferable;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

/**
 *
 * @author anthares101
 */
class DragPcComponent extends TransferHandler {
  
    private DragEventListener listener;
  
    //Set a listener to the drag event
    public void setDragEventListener (DragEventListener listener) {
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
        
        //Copy the component information
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        ArrayList<String> data = new ArrayList();
        data.add(sourcePcComponent.getProductName());
        data.add(currency.format(sourcePcComponent.getProductPrize()));
        data.add(String.valueOf(sourcePcComponent.getComponentType()));

        Transferable t = new TransferablePcComponent(data);

        return t;
    }
    //Because the builder manage the component list refresh, is not necesary
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
            if (this.listener != null) this.listener.onDragEvent(container);
        }
    }
}
