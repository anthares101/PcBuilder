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
public class CPU extends PcComponent {
    
    private String socket;
    
    public CPU() {
        super();
        
        this.setSocket("");
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }
    
}
