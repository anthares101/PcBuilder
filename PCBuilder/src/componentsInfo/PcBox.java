/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentsInfo;

import java.util.Vector;

/**
 *
 * @author anthares101
 */
public class PcBox extends PcComponent {
    
    private Vector formFactors;
    private double height;
    private double weight;
    private double longitude;
    private double maxGPU;
    
    public PcBox() {
        super();
        
        this.setHeight(0);
        this.setLongitude(0);
        this.setWeight(0);
        this.setMaxGPU(0);
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

    public double getWeight() {
        return this.weight;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getMaxGPU() {
        return this.maxGPU;
    }

    public void setFormFactors(Vector formFactors) {
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

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setMaxGPU(double maxGPU) {
        this.maxGPU = maxGPU;
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
