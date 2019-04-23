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
public class Motherboard extends PcComponent {
    
    private String formFactor;
    private String socket;
    private int ramCompatibility;
    
    public Motherboard() {
        super();
        
        this.setFormFactor("");
        this.setRamCompatibility(0);
        this.setSocket("");
    }
    
    public String getFormFactor() {
        return this.formFactor;
    }

    public String getSocket() {
        return this.socket;
    }

    public int getRamCompatibility() {
        return this.ramCompatibility;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public void setRamCompatibility(int ramCompatibility) {
        this.ramCompatibility = ramCompatibility;
    }
}
