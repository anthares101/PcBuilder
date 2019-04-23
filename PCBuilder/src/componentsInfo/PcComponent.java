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
public class PcComponent {
    
    private String name;
    private double prize;
    private String description;
    
    public PcComponent() {
        this.setName("");
        this.setPrize(0);
        this.setDescription("");
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getPrize(){
        return this.prize;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrize(double prize){
        this.prize = prize;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
}
