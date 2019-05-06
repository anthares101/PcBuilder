/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentsInfo;

import java.util.ArrayList;

/**
 *
 * @author anthares101
 */

public class Cooler extends PcComponent{
    
    private ArrayList<String> sockets;
    private double height;
    
    public Cooler() {
        super();
        
        this.setHeight(0);
    }

    public String getSocket(int index) {
        return this.sockets.get(index);
    }
    
    public int getSocketListSize() {
        return this.sockets.size();
    }
    
    public Boolean isSocketsEmpty(){
        return this.sockets.isEmpty();
    }

    public double getHeight() {
        return this.height;
    }

    public void setSockets(ArrayList<String> sockets) {
        this.sockets = sockets;
    }
    
    public void addSocket(String socket){
        this.sockets.add(socket);
    }
    
    public void removeSocket(String socket){
        this.sockets.remove(socket);
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public Boolean hasSocket(String formFactor){
        int i = 0;
        
        while(i < this.sockets.size() && !this.sockets.get(i).equals(formFactor))
            i++;
        
        return i != this.sockets.size();
    }
    
}
