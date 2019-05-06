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
public class RAM extends PcComponent {
    
    private int type;
    
    public RAM() {
        super();
        
        this.setType(0);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
