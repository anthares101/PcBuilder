/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentsInfo;

/**
 *
 * @author anthares101
 */
public class PSU extends PcComponent {
    
    private int watts;
    
    public PSU() {
        super();
        
        this.setWatts(0);
    }

    public int getWatts() {
        return this.watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }
    
}
