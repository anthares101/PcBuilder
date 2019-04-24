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
public class Cooler extends PcComponent {
    
    private ArrayList formFactors;
    private double height;
    
    public Cooler() {
        super();
        
        this.setHeight(0);
    }

    public String getFormFactor(int index) {
        return this.formFactors.get(index).toString();
    }
    
    public Boolean isFormFactorsEmpty(){
        return this.formFactors.isEmpty();
    }

    public double getHeight() {
        return this.height;
    }

    public void setFormFactors(ArrayList formFactors) {
        this.formFactors = formFactors;
    }
    
    public void addFormFactor(int index, String formFactor){
        this.formFactors.add(index, formFactor);
    }
    
    public void removeFormFactor(int index){
        this.formFactors.remove(index);
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public Boolean findFormFactor(String formFactor){
        int i = 0;
        
        while(!this.formFactors.get(i).toString().equals(formFactor) && 
                i < this.formFactors.size())
            i++;
        
        if(i == this.formFactors.size())
            return false;
        
        return true;
    }
    
}
